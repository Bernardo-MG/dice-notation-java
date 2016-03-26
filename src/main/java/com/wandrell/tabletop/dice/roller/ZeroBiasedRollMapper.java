
package com.wandrell.tabletop.dice.roller;

import com.wandrell.tabletop.dice.roller.Roller.RollMapper;

public final class ZeroBiasedRollMapper implements RollMapper<Integer> {

    @Override
    public final Integer getValueFor(final Integer roll) {
        return roll - 1;
    }

}
