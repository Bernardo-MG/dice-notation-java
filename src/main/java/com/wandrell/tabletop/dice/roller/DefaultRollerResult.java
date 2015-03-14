package com.wandrell.tabletop.dice.roller;

import java.util.Collection;

import com.wandrell.tabletop.dice.roller.Roller.RollerResult;

public final class DefaultRollerResult<V> implements RollerResult<V> {

    final Collection<Integer> bare;
    final Collection<V>       mapped;

    public DefaultRollerResult(final Collection<Integer> bare,
            final Collection<V> mapped) {
        super();

        this.bare = bare;
        this.mapped = mapped;
    }

    @Override
    public final Collection<Integer> getBareRollResults() {
        return bare;
    }

    @Override
    public final Collection<V> getMappedRollResults() {
        return mapped;
    }

}
