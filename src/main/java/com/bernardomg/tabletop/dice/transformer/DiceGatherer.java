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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
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
    private static final Logger                                     LOGGER   = LoggerFactory
            .getLogger(DiceGatherer.class);

    /**
     * Transformer to generate a list from the received expression.
     */
    private final DiceInterpreter<Iterable<DiceNotationExpression>> expander = new InorderTransformer();

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
        exps = expander.transform(expression);

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
