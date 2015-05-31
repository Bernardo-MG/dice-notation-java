package com.wandrell.tabletop.dice.notation;

public final class IntegerComponent implements DiceNotationComponent {

    private Integer value;

    public IntegerComponent(final Integer value) {
        super();

        this.value = value;
    }

    @Override
    public final String getPrintableText() {
        return getValue().toString();
    }

    public Integer getValue() {
        return value;
    }

}
