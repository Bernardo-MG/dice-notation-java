package com.wandrell.tabletop.dice.notation.operation;

public final class IntegerOperand implements Operand {

    private final Integer value;

    public IntegerOperand(final Integer value) {
        super();

        this.value = value;
    }

    @Override
    public final Integer getValue() {
        return value;
    }

}
