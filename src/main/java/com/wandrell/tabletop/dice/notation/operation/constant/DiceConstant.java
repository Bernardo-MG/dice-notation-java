package com.wandrell.tabletop.dice.notation.operation.constant;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;

public final class DiceConstant implements DiceExpressionComponent {

    private final Dice dice;

    public DiceConstant(final Dice dice) {
        super();

        this.dice = dice;
    }

    public final Dice getDice() {
        return dice;
    }

    @Override
    public final String getPrintableText() {
        return getDice().toString();
    }

}
