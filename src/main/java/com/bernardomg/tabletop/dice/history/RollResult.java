
package com.bernardomg.tabletop.dice.history;

import com.bernardomg.tabletop.dice.Dice;

public interface RollResult {

    public Iterable<Integer> getAllRolls();

    public Dice getDice();

    public Integer getFinalRoll();

}
