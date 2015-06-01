package com.wandrell.tabletop.dice.notation.operation.constant;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;

public final class DiceConstant implements DiceExpressionComponent {

    private final Dice dice;

    public DiceConstant(final Dice dice) {
        super();

        this.dice = dice;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DiceConstant other;

        other = (DiceConstant) obj;

        return Objects.equal(dice, other.dice);
    }

    public final Dice getDice() {
        return dice;
    }

    @Override
    public final String getPrintableText() {
        return getDice().getPrintableText();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dice);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("dice", dice).toString();
    }

}
