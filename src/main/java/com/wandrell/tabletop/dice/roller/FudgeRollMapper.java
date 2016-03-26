
package com.wandrell.tabletop.dice.roller;

import com.wandrell.tabletop.dice.roller.Roller.RollMapper;

public final class FudgeRollMapper implements RollMapper<Integer> {

    @Override
    public final Integer getValueFor(final Integer roll) {
        final Integer result;

        if (roll <= 2) {
            result = -1;
        } else if (roll >= 5) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }

}
