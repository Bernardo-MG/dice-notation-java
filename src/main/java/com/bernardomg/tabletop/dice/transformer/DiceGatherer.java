/**
 * Copyright 2014-2019 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dice.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Dice notation expression which returns all the dice sets contained inside the
 * expression.
 * <p>
 * This will search for dice operands, and acquire the dice inside of them.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceGatherer implements DiceInterpreter<Iterable<Dice>> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DiceGatherer.class);

    /**
     * Default constructor.
     */
    public DiceGatherer() {
        super();
    }

    @Override
    public final Iterable<Dice>
            transform(final DiceNotationExpression expression) {
        final Iterable<DiceNotationExpression> exps;

        checkNotNull(expression, "Received a null pointer as expression");

        LOGGER.debug("Root expression {}", expression);

        // The expression is broken down
        exps = getExpressions(expression);

        // The expressions are filtered, taking all the dice
        return filterDice(exps);
    }

    /**
     * Filters the received expressions, returning only the dice contained in
     * them, in the same order they are in the received list.
     * 
     * @param exps
     *            expressions to filter
     * @return all the dice in the expressions
     */
    private final Iterable<Dice>
            filterDice(final Iterable<DiceNotationExpression> exps) {
        final Collection<Dice> result;
        DiceNotationExpression previous;

        previous = null;
        result = new ArrayList<>();
        for (final DiceNotationExpression exp : exps) {
            if (exp instanceof DiceOperand) {
                if (previous instanceof SubtractionOperation) {
                    // Right side on a subtraction
                    // Change sign
                    result.add(reverse(((DiceOperand) exp).getDice()));
                } else {
                    result.add(((DiceOperand) exp).getDice());
                }
            }
            previous = exp;
        }

        return result;
    }

    /**
     * Breaks down the root expression into an inorder list.
     * 
     * @param root
     *            root expression
     * @return inorder list with all the expressions from the tree
     */
    private final Iterable<DiceNotationExpression>
            getExpressions(final DiceNotationExpression root) {
        final Stack<DiceNotationExpression> nodes;
        final Collection<DiceNotationExpression> stack;
        DiceNotationExpression current;

        current = root;

        nodes = new Stack<>();
        stack = new ArrayList<>();
        while ((!nodes.isEmpty()) || (current != null)) {
            LOGGER.debug("Transforming expression {}", current);
            if (current == null) {
                // Left nodes exhausted
                // Moves to the previous right node
                current = nodes.pop();

                // This is the next node for inorder traverse
                stack.add(current);

                if (current instanceof BinaryOperation) {
                    // Moves to a right node
                    current = ((BinaryOperation) current).getRight();
                } else {
                    // Not binary node
                    // There is no right node
                    current = null;
                }
            } else {
                // Store and keep moving
                nodes.push(current);
                if (current instanceof BinaryOperation) {
                    // Next left node
                    current = ((BinaryOperation) current).getLeft();
                } else {
                    // Not binary node
                    // There is no left node
                    current = null;
                }
            }
        }

        return stack;
    }

    /**
     * Reverses the sign of a dice, changing positive values to negatives, and
     * viceversa.
     * 
     * @param dice
     *            dice to reverse
     * @return dice with the sign reversed
     */
    private final Dice reverse(final Dice dice) {
        return new DefaultDice(0 - dice.getQuantity(), dice.getSides());
    }

}
