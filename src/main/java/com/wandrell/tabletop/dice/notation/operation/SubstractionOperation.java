package com.wandrell.tabletop.dice.notation.operation;

public final class SubstractionOperation implements BinaryOperation {

    public SubstractionOperation() {
        super();
    }

    @Override
    public final Operand
            operate(final Operand operand1, final Operand operand2) {
        return new IntegerOperand(operand1.getValue() - operand2.getValue());
    }

}
