
package com.bernardomg.tabletop.dice.history;

public interface RollHistory {

    public Integer getFinalRoll();

    public Iterable<RollResult> getRollResults();

}
