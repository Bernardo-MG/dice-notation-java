
package com.bernardomg.tabletop.dice.history;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultRollHistory implements RollHistory {

    private final Iterable<Integer>    allRolls;

    private final Integer              finalRoll;

    private final Iterable<RollResult> rollResults;

    public DefaultRollHistory(final Integer result,
            final Iterable<Integer> rolls, final Iterable<RollResult> results) {
        super();

        finalRoll = checkNotNull(result,
                "Received a null pointer as final roll");
        allRolls = checkNotNull(rolls, "Received a null pointer as rolls");
        rollResults = checkNotNull(results,
                "Received a null pointer as roll results");
    }

    @Override
    public Iterable<Integer> getAllRolls() {
        return allRolls;
    }

    @Override
    public Integer getFinalRoll() {
        return finalRoll;
    }

    @Override
    public Iterable<RollResult> getRollResults() {
        return rollResults;
    }

}
