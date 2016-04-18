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

package com.wandrell.tabletop.dice.test.unit.generator;

import java.util.Collection;
import java.util.Iterator;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.number.NumberGenerator;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;

public final class TestRandomGeneratorDefaultRoller {

	public TestRandomGeneratorDefaultRoller() {
		super();
	}

	@Test
	public final void testRandomGenerator_Bare_Returns() {
		final Dice dice;
		final Roller<Integer> roller;
		final Collection<Integer> result;
		final NumberGenerator generator;
		final Iterator<Integer> itrInteger;

		dice = Mockito.mock(Dice.class);

		Mockito.when(dice.getQuantity()).thenReturn(3);
		Mockito.when(dice.getSides()).thenReturn(6);

		generator = Mockito.mock(NumberGenerator.class);

		Mockito.when(generator.generate(Matchers.anyInt())).thenReturn(3, 5, 1);

		roller = new DefaultRoller(generator);

		result = roller.roll(dice);

		itrInteger = result.iterator();

		Assert.assertEquals(itrInteger.next(), (Integer) 3);
		Assert.assertEquals(itrInteger.next(), (Integer) 5);
		Assert.assertEquals(itrInteger.next(), (Integer) 1);
	}

	@Test
	public final void testRandomGenerator_Mapped_Returns() {
		final Dice dice;
		final Roller<Integer> roller;
		final Collection<Integer> result;
		final NumberGenerator generator;
		final Iterator<Integer> itrInteger;

		dice = Mockito.mock(Dice.class);

		Mockito.when(dice.getQuantity()).thenReturn(3);
		Mockito.when(dice.getSides()).thenReturn(6);

		generator = Mockito.mock(NumberGenerator.class);

		Mockito.when(generator.generate(Matchers.anyInt())).thenReturn(3, 5, 1);

		roller = new DefaultRoller(generator);

		result = roller.roll(dice);

		itrInteger = result.iterator();

		Assert.assertEquals(itrInteger.next(), (Integer) 3);
		Assert.assertEquals(itrInteger.next(), (Integer) 5);
		Assert.assertEquals(itrInteger.next(), (Integer) 1);
	}

}
