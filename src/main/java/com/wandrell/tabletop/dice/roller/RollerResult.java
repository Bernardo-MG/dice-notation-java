
package com.wandrell.tabletop.dice.roller;

import java.util.Collection;

public interface RollerResult<V> {

    public Collection<Integer> getBareRollResults();

    public Collection<V> getMappedRollResults();

}
