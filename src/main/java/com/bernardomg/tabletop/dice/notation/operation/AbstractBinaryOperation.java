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

package com.bernardomg.tabletop.dice.notation.operation;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.BiFunction;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Abstract class for binary operations, containing all the common fields.
 * <p>
 * These fields are the operands and the operation, stored as a
 * {@link BiFunction}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public abstract class AbstractBinaryOperation implements BinaryOperation {

    /**
     * Left sided operand.
     */
    private final DiceNotationExpression                left;

    /**
     * Operation to apply.
     */
    private final BiFunction<Integer, Integer, Integer> operation;

    /**
     * Right sided operand.
     */
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
    public AbstractBinaryOperation(final DiceNotationExpression leftOperand,
            final DiceNotationExpression rightOperand,
            final BiFunction<Integer, Integer, Integer> func) {
        super();

        left = checkNotNull(leftOperand,
                "Received a null pointer as left operand");
        right = checkNotNull(rightOperand,
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

        return Objects.equal(left, other.left)
                && Objects.equal(right, other.right);
    }

    @Override
    public final DiceNotationExpression getLeft() {
        return left;
    }

    @Override
    public final BiFunction<Integer, Integer, Integer> getOperation() {
        return operation;
    }

    @Override
    public final DiceNotationExpression getRight() {
        return right;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(left, right);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("left", left)
                .add("right", right).toString();
    }

}
