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

package com.bernardomg.tabletop.dice.notation.operation;

import java.util.function.BiFunction;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

import lombok.Data;
import lombok.NonNull;

/**
 * Abstract class for binary operations, containing all the common fields.
 * <p>
 * These fields are the operands and the operation, stored as a
 * {@link BiFunction}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Data
public abstract class AbstractBinaryOperation implements BinaryOperation {

    /**
     * Left sided operand.
     */
    @NonNull
    private final DiceNotationExpression                left;

    /**
     * Operation to apply.
     */
    @NonNull
    private final BiFunction<Integer, Integer, Integer> operation;

    /**
     * Right sided operand.
     */
    @NonNull
    private final DiceNotationExpression                right;

    /**
     * Constructs a subtraction operation with the specified operands.
     * 
     * @param leftOperand
     *            the left sided operand
     * @param rightOperand
     *            the right sided operand
     * @param func
     *            operation to apply
     */
    public AbstractBinaryOperation(
            @NonNull final DiceNotationExpression leftOperand,
            @NonNull final DiceNotationExpression rightOperand,
            @NonNull final BiFunction<Integer, Integer, Integer> func) {
        super();

        left = leftOperand;
        right = rightOperand;
        operation = func;
    }

}
