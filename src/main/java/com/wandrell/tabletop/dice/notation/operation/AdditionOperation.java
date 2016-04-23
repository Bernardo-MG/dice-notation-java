/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.notation.operation;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.notation.operand.DiceNotationOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerExpression;

public final class AdditionOperation implements BinaryOperation {

    final DiceNotationOperand operandLeft;

    final DiceNotationOperand operandRight;

    public AdditionOperation(final DiceNotationOperand operandLeft,
            final DiceNotationOperand operandRight) {
        super();

        this.operandLeft = operandLeft;
        this.operandRight = operandRight;
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

        final AdditionOperation other;

        other = (AdditionOperation) obj;

        return Objects.equal(operandLeft, other.operandLeft)
                && Objects.equal(operandRight, other.operandRight);
    }

    @Override
    public final DiceNotationOperand getLeft() {
        return operandLeft;
    }

    @Override
    public final DiceNotationOperand getRight() {
        return operandRight;
    }

    @Override
    public final String getStringRepresentation() {
        final String left;
        final String right;

        left = getLeft().getStringRepresentation();
        right = getRight().getStringRepresentation();

        return String.format("%s+%s", left, right);
    }

    @Override
    public final Integer getValue() {
        return operate().getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(operandLeft, operandRight);
    }

    @Override
    public final DiceNotationOperand operate() {
        return new IntegerExpression(getLeft().getValue()
                + getRight().getValue());
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("left", operandLeft)
                .add("right", operandRight).toString();
    }

}
