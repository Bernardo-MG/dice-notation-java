package com.wandrell.tabletop.dice.notation.operation;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;

public final class AdditionOperation implements BinaryOperation {

    final Operand operandLeft;
    final Operand operandRight;

    public AdditionOperation(final Operand operandLeft,
            final Operand operandRight) {
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
    public final Operand getLeft() {
        return operandLeft;
    }

    @Override
    public final String getPrintableText() {
        final String left;
        final String right;

        left = getLeft().getPrintableText();
        right = getRight().getPrintableText();

        return String.format("%s+%s", left, right);
    }

    @Override
    public final Operand getRight() {
        return operandRight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(operandLeft, operandRight);
    }

    @Override
    public final Operand operate() {
        return new IntegerConstant(getLeft().getValue() + getRight().getValue());
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("left", operandLeft)
                .add("right", operandRight).toString();
    }

}
