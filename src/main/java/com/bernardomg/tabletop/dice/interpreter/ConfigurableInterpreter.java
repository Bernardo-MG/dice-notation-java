/**
 * Copyright 2014-2022 the original author or authors
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

package com.bernardomg.tabletop.dice.interpreter;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.visitor.NotationAccumulator;

/**
 * An interpreter which can be customized.
 * <p>
 * It chains a traverser, which is another interpreter returning an {@code Iterable<DiceNotationExpression>}, with a
 * {@link NotationAccumulator}. The traverser will flatten the notation tree, and then the accumulator will go through
 * it.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 * @param <V>
 *            type of the generated object
 */
public final class ConfigurableInterpreter<V> implements DiceInterpreter<V> {

    /**
     * Logger.
     */
    private static final Logger                                     LOGGER = LoggerFactory
        .getLogger(ConfigurableInterpreter.class);

    /**
     * Accumulator for generating the final result.
     */
    private final NotationAccumulator<V>                            accumulator;

    /**
     * Intrepreter to flatten the received tree.
     */
    private final DiceInterpreter<Iterable<DiceNotationExpression>> traverser;

    /**
     * Constructs an interpreter.
     * 
     * @param trav
     *            traverser to flatten the tree
     * @param accum
     *            accumulator to generate the result
     */
    public ConfigurableInterpreter(final DiceInterpreter<Iterable<DiceNotationExpression>> trav,
            final NotationAccumulator<V> accum) {
        super();

        traverser = Objects.requireNonNull(trav, "Received a null pointer as traverser");
        accumulator = Objects.requireNonNull(accum, "Received a null pointer as accumulator");
    }

    @Override
    public final V transform(final DiceNotationExpression expression) {
        final Iterable<DiceNotationExpression> exps;
        final V                                result;

        Objects.requireNonNull(expression, "Received a null pointer as expression");

        LOGGER.debug("Root expression {}", expression);

        // The expression is broken down
        exps = traverser.transform(expression);

        LOGGER.trace("Traversed root into {}", exps);

        // The expressions are filtered, taking all the dice
        result = process(exps);

        LOGGER.trace("Processed expressions into {}", result);

        return result;
    }

    /**
     * Returns the result from applying the accumulator in all the nodes.
     * 
     * @param nodes
     *            flattened tree
     * @return the result from applying the accumulator
     */
    private final V process(final Iterable<DiceNotationExpression> nodes) {

        accumulator.reset();

        for (final DiceNotationExpression current : nodes) {
            LOGGER.debug("Current expression: {}", current);
            if (current instanceof BinaryOperation) {
                accumulator.binaryOperation((BinaryOperation) current);
            } else if (current instanceof ConstantOperand) {
                accumulator.constantOperand((ConstantOperand) current);
            } else if (current instanceof DiceOperand) {
                accumulator.diceOperand((DiceOperand) current);
            } else {
                LOGGER.warn("Unsupported expression of type {}", current.getClass());
            }
        }

        return accumulator.getValue();
    }

}
