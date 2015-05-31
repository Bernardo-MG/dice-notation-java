package com.wandrell.tabletop.dice.notation.constant;

import com.wandrell.tabletop.dice.notation.DiceFormulaComponent;

public final class IntegerConstant implements DiceFormulaComponent {

    private final Integer value;

    public IntegerConstant(final Integer value) {
        super();

        this.value = value;
    }

    @Override
    public final String getPrintableText() {
        return getValue().toString();
    }

    public final Integer getValue() {
        return value;
    }

}
