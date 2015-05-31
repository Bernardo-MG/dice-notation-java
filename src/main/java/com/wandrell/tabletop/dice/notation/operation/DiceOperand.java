package com.wandrell.tabletop.dice.notation.operation;

import java.util.Collection;

import com.wandrell.tabletop.dice.notation.operation.constant.DiceConstant;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;

public final class DiceOperand implements Operand {

    private final DiceConstant dice;
    private final Roller       roller;

    public DiceOperand(final DiceConstant dice) {
        super();

        this.dice = dice;
        this.roller = new DefaultRoller();
    }

    public DiceOperand(final DiceConstant dice, final Roller roller) {
        super();

        this.dice = dice;
        this.roller = roller;
    }

    public final DiceConstant getDice() {
        return dice;
    }

    @Override
    public final String getPrintableText() {
        return getDice().getPrintableText();
    }

    @Override
    public final Integer getValue() {
        final Collection<Integer> values;
        Integer sum;

        values = getRoller().roll(getDice().getDice()).getBareRollResults();

        sum = 0;
        for (final Integer value : values) {
            sum += value;
        }

        return sum;
    }

    private final Roller getRoller() {
        return roller;
    }

}
