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

package com.wandrell.tabletop.dice.test.unit.roller;

import java.util.Iterator;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.generator.DefaultRandomNumberGenerator;
import com.wandrell.tabletop.dice.mapper.RollMapper;
import com.wandrell.tabletop.dice.roller.MappedRoller;
import com.wandrell.tabletop.dice.roller.Roller;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceValuesTestParametersFactory;

public final class TestRollMapperDefaultRoller {

	protected static final String DATA = "data";

	@DataProvider(name = DATA)
	public final static Iterator<Object[]> getData() throws Exception {
		return DiceValuesTestParametersFactory.getInstance().getDice();
	}

	public TestRollMapperDefaultRoller() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = DATA)
	public final void testRoll_ResultsSize_MappedRollValues_Mapped(
			final Integer quantity, final Integer sides) {
		final Dice dice;
		final Roller<String> roller;
		final RollMapper<String> mapper;

		dice = Mockito.mock(Dice.class);

		Mockito.when(dice.getQuantity()).thenReturn(quantity);
		Mockito.when(dice.getSides()).thenReturn(sides);

		mapper = Mockito.mock(RollMapper.class);

		Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
				.thenReturn("ABC");

		roller = new MappedRoller<String>(mapper,
				new DefaultRandomNumberGenerator());

		Assert.assertEquals((Integer) roller.roll(dice).getMappedRollResults()
				.size(), quantity);
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testRollMapper_Alphanumeric_Returns() {
		final Dice dice;
		final Roller<String> roller;
		final RollMapper<String> mapper;
		final String value;
		final Iterator<String> itrValues;

		value = "ABC";

		dice = Mockito.mock(Dice.class);

		Mockito.when(dice.getQuantity()).thenReturn(5);
		Mockito.when(dice.getSides()).thenReturn(6);

		mapper = Mockito.mock(RollMapper.class);

		Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
				.thenReturn(value);

		roller = new MappedRoller<String>(mapper,
				new DefaultRandomNumberGenerator());

		itrValues = roller.roll(dice).getMappedRollResults().iterator();

		Assert.assertEquals(itrValues.next(), value);
		Assert.assertEquals(itrValues.next(), value);
		Assert.assertEquals(itrValues.next(), value);
		Assert.assertEquals(itrValues.next(), value);
		Assert.assertEquals(itrValues.next(), value);
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testRollMapper_Returns() {
		final Dice dice;
		final Roller<Integer> roller;
		final RollMapper<Integer> mapper;
		final Iterator<Integer> itrValues;

		dice = Mockito.mock(Dice.class);

		Mockito.when(dice.getQuantity()).thenReturn(3);
		Mockito.when(dice.getSides()).thenReturn(6);

		mapper = Mockito.mock(RollMapper.class);

		Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
				.thenReturn(11, 14, 1);

		roller = new MappedRoller<Integer>(mapper,
				new DefaultRandomNumberGenerator());

		itrValues = roller.roll(dice).getMappedRollResults().iterator();

		Assert.assertEquals(itrValues.next(), (Integer) 11);
		Assert.assertEquals(itrValues.next(), (Integer) 14);
		Assert.assertEquals(itrValues.next(), (Integer) 1);
	}

}
