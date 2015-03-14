package com.wandrell.tabletop.dice.roller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import com.wandrell.tabletop.dice.Dice;

public final class DefaultRoller implements Roller {

    private final RollMapper<Integer> defaultMapper;
    private final RandomGenerator     generator;

    public interface RandomGenerator {

        public Integer generate(final Integer sides);

    }

    {
        defaultMapper = new RollMapper<Integer>() {

            @Override
            public final Integer getValueFor(final Integer roll) {
                return roll;
            }

        };
    }

    public DefaultRoller() {
        super();

        generator = new DefaultRandomGenerator();
    }

    public DefaultRoller(final RandomGenerator generator) {
        super();

        this.generator = generator;
    }

    @Override
    public final RollerResult<Integer> roll(final Dice dice) {
        return roll(dice, getDefaultMapper());
    }

    @Override
    public final <V> RollerResult<V> roll(final Dice dice,
            final RollMapper<V> mapper) {
        final Collection<Integer> bare;
        final Collection<V> mapped;
        Integer roll;   // Stores each of the roll results

        checkNotNull(dice, "Received a null pointer as dice");
        checkNotNull(mapper, "Received a null pointer as mapper");

        bare = new LinkedList<>();
        mapped = new LinkedList<>();
        for (Integer i = 0; i < dice.getQuantity(); i++) {
            roll = getRandomGenerator().generate(dice.getSides());

            bare.add(roll);
            mapped.add(mapper.getValueFor(roll));
        }

        return new DefaultRollerResult<V>(bare, mapped);
    }

    private final RollMapper<Integer> getDefaultMapper() {
        return defaultMapper;
    }

    private final RandomGenerator getRandomGenerator() {
        return generator;
    }

}
