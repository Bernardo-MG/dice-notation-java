package com.wandrell.tabletop.dice.notation.operation;

import java.util.Collection;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.roller.Roller;

public final class DiceOperand implements Operand {

    private final Dice   dice;
    private final Roller roller;

    public DiceOperand(final Dice dice, final Roller roller) {
        super();

        this.dice = dice;
        this.roller = roller;
    }

    @Override
    public final Integer getValue() {
        final Collection<Integer> values;
        Integer sum;

        values = getRoller().roll(getDice()).getBareRollResults();

        sum = 0;
        for (final Integer value : values) {
            sum += value;
        }

        return sum;
    }

    private final Dice getDice() {
        return dice;
    }

    private final Roller getRoller() {
        return roller;
    }

}
