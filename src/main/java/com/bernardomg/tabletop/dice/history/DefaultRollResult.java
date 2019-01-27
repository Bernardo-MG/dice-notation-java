
package com.bernardomg.tabletop.dice.history;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.Dice;

public final class DefaultRollResult implements RollResult {

    private final Iterable<Integer> allRolls;

    private final Dice              dice;

    private final Integer           finalRoll;

    public DefaultRollResult(final Dice rolled, final Iterable<Integer> rolls,
            final Integer result) {
        super();

        dice = checkNotNull(rolled, "Received a null pointer as dice");
        allRolls = checkNotNull(rolls, "Received a null pointer as rolls");
        finalRoll = checkNotNull(result, "Received a null pointer as final roll");
    }

    @Override
    public final Iterable<Integer> getAllRolls() {
        return allRolls;
    }

    @Override
    public Dice getDice() {
        return dice;
    }

    @Override
    public Integer getFinalRoll() {
        return finalRoll;
    }

}
