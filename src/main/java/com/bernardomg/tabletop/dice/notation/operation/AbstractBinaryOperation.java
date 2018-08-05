/**
 * Copyright 2014-2017 the original author or authors
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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.BiFunction;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public abstract class AbstractBinaryOperation implements BinaryOperation {

    /**
     * Left sided operand.
     */
    private final DiceNotationExpression                operandLeft;

    /**
     * Right sided operand.
     */
    private final DiceNotationExpression                operandRight;

    /**
     * Operation to apply.
     */
    private final BiFunction<Integer, Integer, Integer> operation;

    /**
     * Constructs a subtraction operation with the specified operands.
     * 
     * @param left
     *            the left sided operand
     * @param right
     *            the right sided operand
     * @param func
     *            operation to apply
     */
    public AbstractBinaryOperation(final DiceNotationExpression left,
            final DiceNotationExpression right,
            final BiFunction<Integer, Integer, Integer> func) {
        super();

        operandLeft = checkNotNull(left,
                "Received a null pointer as left operand");
        operandRight = checkNotNull(right,
                "Received a null pointer as right operand");
        operation = checkNotNull(func, "Received a null pointer as operation");
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final AbstractBinaryOperation other;

        other = (AbstractBinaryOperation) obj;

        return Objects.equal(operandLeft, other.operandLeft)
                && Objects.equal(operandRight, other.operandRight);
    }

    @Override
    public final DiceNotationExpression getLeft() {
        return operandLeft;
    }

    @Override
    public final BiFunction<Integer, Integer, Integer> getOperation() {
        return operation;
    }

    @Override
    public final DiceNotationExpression getRight() {
        return operandRight;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(operandLeft, operandRight);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("left", operandLeft)
                .add("right", operandRight).toString();
    }

}
