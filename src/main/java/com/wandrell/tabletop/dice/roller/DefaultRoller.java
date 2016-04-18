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

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.mapper.DefaultRollMapper;
import com.wandrell.tabletop.dice.random.DefaultNumberGenerator;
import com.wandrell.tabletop.dice.random.NumberGenerator;

/**
 * Generates random integer values from a {@link Dice}.
 * 
 * @author Bernardo Martínez Garrido
 * @see Dice
 */
public final class DefaultRoller implements Roller<Integer> {

	/**
	 * The base roller.
	 * <p>
	 * This is to apply extension through composition.
	 */
	private final Roller<Integer> roller;

	/**
	 * Default constructor.
	 */
	public DefaultRoller() {
		super();

		roller = new MappedRoller<Integer>(new DefaultRollMapper(),
				new DefaultNumberGenerator());
	}

	/**
	 * Constructs an instance with the specified random number generator.
	 * 
	 * @param generator
	 *            the random number generator to use
	 */
	public DefaultRoller(final NumberGenerator generator) {
		super();

		checkNotNull(generator, "Received a null pointer as number generator");

		roller = new MappedRoller<Integer>(new DefaultRollMapper(), generator);
	}

	/**
	 * Generates a collection of random integer values from the received
	 * {@code Dice}.
	 * 
	 * @param dice
	 *            the dice to roll
	 * @return a collection of random values
	 */
	@Override
	public final Collection<Integer> roll(final Dice dice) {
		return getRoller().roll(dice);
	}

	/**
	 * The base roller.
	 * 
	 * @return the base roller
	 */
	private final Roller<Integer> getRoller() {
		return roller;
	}

}
