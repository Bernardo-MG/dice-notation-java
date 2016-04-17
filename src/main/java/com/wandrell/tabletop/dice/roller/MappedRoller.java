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
import com.wandrell.tabletop.dice.generator.RandomNumberGenerator;
import com.wandrell.tabletop.dice.mapper.RollMapper;

public final class MappedRoller<V> implements Roller<V> {

	private final RandomNumberGenerator generator;

	private final RollMapper<V> mapper;

	public MappedRoller(final RollMapper<V> mapper,
			final RandomNumberGenerator generator) {
		super();

		this.mapper = mapper;
		this.generator = generator;
	}

	private final RollMapper<V> getMapper() {
		return mapper;
	}

	private final RandomNumberGenerator getRandomGenerator() {
		return generator;
	}

	@Override
	public final RollerResult<V> roll(final Dice dice) {
		final Collection<Integer> bare;
		final Collection<V> mapped;
		Integer roll; // Stores each of the roll results

		checkNotNull(dice, "Received a null pointer as dice");

		bare = new LinkedList<>();
		mapped = new LinkedList<>();
		for (Integer i = 0; i < dice.getQuantity(); i++) {
			roll = getRandomGenerator().generate(dice.getSides());

			bare.add(roll);
			mapped.add(getMapper().getValueFor(roll));
		}

		return new DefaultRollerResult<V>(bare, mapped);
	}

}
