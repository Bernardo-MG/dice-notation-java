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

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

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
        final Stack<DiceNotationExpression> nodes;
        final Collection<Dice> result;
        DiceNotationExpression current;

        checkNotNull(expression, "Received a null pointer as expression");

        nodes = new Stack<>();
        nodes.push(expression);

        LOGGER.debug("Root expression {}", expression);

        result = new ArrayList<>();
        while (!nodes.isEmpty()) {
            current = nodes.pop();
            LOGGER.debug("Transforming expression {}", current);
            if (current instanceof BinaryOperation) {
                // TODO: If it is a subtraction then the right value sign should
                // be reversed
                nodes.push(((BinaryOperation) current).getRight());
                nodes.push(((BinaryOperation) current).getLeft());
            } else if (current instanceof DiceOperand) {
                result.add(((DiceOperand) current).getDice());
            }
        }

        return result;
    }

}
