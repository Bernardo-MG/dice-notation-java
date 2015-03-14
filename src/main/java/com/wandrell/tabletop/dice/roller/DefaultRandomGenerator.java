package com.wandrell.tabletop.dice.roller;

import java.util.Random;

import com.wandrell.tabletop.dice.roller.DefaultRoller.RandomGenerator;

public final class DefaultRandomGenerator implements RandomGenerator {

    /**
     * Random number generator for generating roll values.
     * <p>
     * To keep the seed, a single instance is used on all the rolls.
     */
    private final Random random = new Random();

    public DefaultRandomGenerator() {
        super();
    }

    @Override
    public final Integer generate(final Integer sides) {
        final Integer lowerLimit;
        Integer result;

        lowerLimit = 1;

        result = getRandom().nextInt(Math.abs(lowerLimit - sides) + 1)
                + lowerLimit;

        if (sides < 0) {
            result += -1;
        }

        return result;
    }

    private final Random getRandom() {
        return random;
    }

}
