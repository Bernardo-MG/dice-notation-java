
package com.bernardomg.tabletop.dice.history;

public interface RollHistory {

    public Iterable<Integer> getAllRolls();

    public Integer getFinalRoll();

    public Iterable<RollResult> getRollResults();

}
