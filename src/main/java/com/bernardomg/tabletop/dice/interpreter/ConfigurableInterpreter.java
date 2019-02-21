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

package com.bernardomg.tabletop.dice.interpreter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.visitor.NotationAccumulator;

public final class ConfigurableInterpreter<V> implements DiceInterpreter<V> {

    /**
     * Logger.
     */
    private static final Logger                                     LOGGER = LoggerFactory
            .getLogger(ConfigurableInterpreter.class);

    /**
     * Transformer to generate a list from the received expression.
     */
    private final DiceInterpreter<Iterable<DiceNotationExpression>> traverser;

    private final Supplier<NotationAccumulator<V>>                  visitorSupplier;

    public ConfigurableInterpreter(
            final DiceInterpreter<Iterable<DiceNotationExpression>> trav,
            final Supplier<NotationAccumulator<V>> supplier) {
        super();

        traverser = checkNotNull(trav, "Received a null pointer as visitor");
        visitorSupplier = checkNotNull(supplier,
                "Received a null pointer as visitor");
    }

    @Override
    public final V transform(final DiceNotationExpression expression) {
        final Iterable<DiceNotationExpression> exps;

        checkNotNull(expression, "Received a null pointer as expression");

        LOGGER.debug("Root expression {}", expression);

        // The expression is broken down
        exps = traverser.transform(expression);

        // The expressions are filtered, taking all the dice
        return process(exps);
    }

    private final V
            process(final Iterable<DiceNotationExpression> expressions) {
        final NotationAccumulator<V> visitor;

        visitor = visitorSupplier.get();
        for (final DiceNotationExpression current : expressions) {
            if (current instanceof BinaryOperation) {
                visitor.binaryOperation((BinaryOperation) current);
            } else if (current instanceof ConstantOperand) {
                visitor.constantOperand((ConstantOperand) current);
            } else if (current instanceof DiceOperand) {
                visitor.diceOperand((DiceOperand) current);
            } else {
                LOGGER.warn("Unsupported expression of type {}",
                        current.getClass());
            }
        }

        return visitor.getValue();
    }

}
