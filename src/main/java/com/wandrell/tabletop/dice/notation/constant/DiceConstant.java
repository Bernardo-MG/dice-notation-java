package com.wandrell.tabletop.dice.notation.constant;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceFormulaComponent;

public final class DiceConstant implements DiceFormulaComponent {

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
