package com.wandrell.tabletop.dice.notation.operation.constant;

import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public final class IntegerConstant implements DiceExpressionComponent, Operand {

    private final Integer value;

    public IntegerConstant(final Integer value) {
        super();

        this.value = value;
    }

    @Override
    public final String getPrintableText() {
        return getValue().toString();
    }

    @Override
    public final Integer getValue() {
        return value;
    }

}
