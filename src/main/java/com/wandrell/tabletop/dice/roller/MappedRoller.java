/**
 * Copyright 2014-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dice.roller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedList;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.mapper.RollMapper;
import com.wandrell.tabletop.dice.number.NumberGenerator;

/**
 * Generates a random result from a {@link Dice}, by mapping the integers
 * generated from it into any kind of value.
 * <p>
 * As the {@code Dice} are just value objects, and don't generate random numbers
 * by themselves, a {@link NumberGenerator} is used for the actual creation of
 * random values.
 * <p>
 * These numbers are then transformed with the help of a {@link RollMapper} into
 * the actual results.
 * 
 * @author Bernardo Martínez Garrido
 * @param <V>
 *            the type of value to return
 * @see Dice
 * @see NumberGenerator
 * @see RollMapper
 */
public final class MappedRoller<V> implements Roller<V> {

	/**
	 * The random numbers generator.
	 * <p>
	 * It will use the dice for the interval in which the values should be
	 * created.
	 */
	private final NumberGenerator generator;

	/**
	 * The mapper for the generated numbers.
	 * <p>
	 * It will transform the values created from the dice into the actual
	 * results.
	 */
	private final RollMapper<V> mapper;

	/**
	 * Constructs an instance with the specified mapper and random number
	 * generator.
	 * <p>
	 * These are the two objects in charge of generating the results of rolling
	 * a dice.
	 * 
	 * @param mapper
	 *            the roll mapper to use
	 * @param generator
	 *            the random number generator to use
	 */
	public MappedRoller(final RollMapper<V> mapper,
			final NumberGenerator generator) {
		super();

		this.mapper = checkNotNull(mapper, "Received a null pointer as mapper");
		this.generator = checkNotNull(generator,
				"Received a null pointer as generator");
	}

	@Override
	public final Collection<V> roll(final Dice dice) {
		final Collection<V> mapped; // Mapped results
		Integer roll; // Stores each of the roll results

		checkNotNull(dice, "Received a null pointer as dice");

		mapped = new LinkedList<>();
		for (Integer i = 0; i < dice.getQuantity(); i++) {
			roll = getNumberGenerator().generate(dice.getSides());

			mapped.add(getMapper().getValueFor(roll));
		}

		return mapped;
	}

	/**
	 * Returns the roll values mapper.
	 * 
	 * @return the roll values mapper
	 */
	private final RollMapper<V> getMapper() {
		return mapper;
	}

	/**
	 * Returns the random number generator.
	 * 
	 * @return the random number generator
	 */
	private final NumberGenerator getNumberGenerator() {
		return generator;
	}

}
