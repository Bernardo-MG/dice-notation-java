package com.wandrell.tabletop.dice.mapper;

public interface RollMapper<V> {

	public V getValueFor(final Integer roll);

}
