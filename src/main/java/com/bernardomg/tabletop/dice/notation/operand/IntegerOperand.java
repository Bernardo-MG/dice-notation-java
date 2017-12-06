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

package com.bernardomg.tabletop.dice.notation.operand;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Operand for using an integer value on a dice notation expression.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class IntegerOperand implements DiceNotationExpression {

    /**
     * Operand value.
     */
    private final Integer operandValue;

    /**
     * Constructs an operand with the specified value.
     * 
     * @param value
     *            the operand value
     */
    public IntegerOperand(final Integer value) {
        super();

        operandValue = checkNotNull(value, "Received a null pointer as value");
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

        final IntegerOperand other;

        other = (IntegerOperand) obj;

        return Objects.equal(operandValue, other.operandValue);
    }

    @Override
    public final String getExpression() {
        return getValue().toString();
    }

    /**
     * Returns the integer value of the operand.
     * 
     * @return the integer value of the operand
     */
    @Override
    public final Integer getValue() {
        return operandValue;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(operandValue);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("value", operandValue)
                .toString();
    }

}
