
package com.bernardomg.tabletop.dice.random;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;

import com.bernardomg.tabletop.dice.Dice;

public abstract class AbstractNumberGenerator implements NumberGenerator {

    public AbstractNumberGenerator() {
        super();
    }

    @Override
    public final Iterable<Integer> generate(final Dice dice) {
        final Collection<Integer> rolls; // Roll results
        final Integer quantity;
        final Boolean negative;

        checkNotNull(dice, "Received a null pointer as dice");

        if (dice.getQuantity() < 0) {
            quantity = 0 - dice.getQuantity();
            negative = true;
        } else {
            quantity = dice.getQuantity();
            negative = false;
        }

        rolls = new ArrayList<Integer>();
        for (Integer i = 0; i < quantity; i++) {
            if (negative) {
                rolls.add(0 - generate(dice.getSides()));
            } else {
                rolls.add(generate(dice.getSides()));
            }
        }

        return rolls;
    }

}
