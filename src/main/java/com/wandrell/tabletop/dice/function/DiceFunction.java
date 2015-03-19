package com.wandrell.tabletop.dice.function;

import java.util.Collection;

public interface DiceFunction {

    public Collection<Integer> applyFunction(final Collection<Integer> rolls);

}
