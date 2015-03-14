package com.wandrell.tabletop.dice;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class DefaultDice implements Dice {

    private final Integer diceCount;
    private final Integer diceSides;

    public DefaultDice(final DefaultDice dice) {
        super();

        checkNotNull(dice, "Received a null pointer as dice");

        diceSides = dice.diceSides;
        diceCount = dice.diceCount;
    }

    public DefaultDice(final Integer quantity, final Integer sides) {
        super();

        checkNotNull(quantity, "Received a null pointer as quantity");
        checkNotNull(sides, "Received a null pointer as sides");

        checkArgument(quantity >= 0, "The quantity of dice can't be negative");
        checkArgument(sides >= 1, "The number of sides can't be lower than 1");

        diceSides = sides;
        diceCount = quantity;
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

        final DefaultDice other;

        other = (DefaultDice) obj;

        return Objects.equal(diceCount, other.diceCount)
                && Objects.equal(diceSides, other.diceSides);
    }

    @Override
    public final String getPrintableText() {
        return String.format("%dd%d", getQuantity(), getSides());
    }

    @Override
    public final Integer getQuantity() {
        return diceCount;
    }

    @Override
    public final Integer getSides() {
        return diceSides;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(diceCount, diceSides);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("quantity", diceCount)
                .add("sides", diceSides).toString();
    }

}
