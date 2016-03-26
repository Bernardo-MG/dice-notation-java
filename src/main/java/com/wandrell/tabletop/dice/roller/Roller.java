
package com.wandrell.tabletop.dice.roller;

import java.util.Collection;

import com.wandrell.tabletop.dice.Dice;

public interface Roller {

    public interface RollerResult<V> {

        public Collection<Integer> getBareRollResults();

        public Collection<V> getMappedRollResults();

    }

    public interface RollMapper<V> {

        public V getValueFor(final Integer roll);

    }

    public RollerResult<Integer> roll(final Dice dice);

    public <V> RollerResult<V> roll(final Dice dice,
            final RollMapper<V> mapper);

}
