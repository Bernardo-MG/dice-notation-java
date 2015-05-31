package com.wandrell.tabletop.dice.notation.operation;

import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;

public final class SubstractionOperation implements BinaryOperation {

    final Operand operand1;
    final Operand operand2;

    public SubstractionOperation(final Operand operand1, final Operand operand2) {
        super();

        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public final Operand getLeft() {
        return operand1;
    }

    @Override
    public final String getPrintableText() {
        final String left;
        final String right;

        left = getLeft().getPrintableText();
        right = getRight().getPrintableText();

        return String.format("%s - %s", left, right);
    }

    @Override
    public final Operand getRight() {
        return operand2;
    }

    @Override
    public final Operand operate() {
        return new IntegerConstant(getLeft().getValue() - getRight().getValue());
    }

}
