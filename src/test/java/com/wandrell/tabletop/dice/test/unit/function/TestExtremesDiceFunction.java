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

package com.wandrell.tabletop.dice.test.unit.function;

import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.function.DiceFunction;
import com.wandrell.tabletop.dice.notation.function.ExtremesDiceFunction;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceFunctionValuesTestParametersFactory;

public final class TestExtremesDiceFunction {

	protected static final String HIGHEST_KEEP = "highest_keep";

	protected static final String HIGHEST_REMOVE = "highest_remove";

	protected static final String LOWEST_KEEP = "lowest_keep";

	protected static final String LOWEST_REMOVE = "lowest_remove";

	@DataProvider(name = HIGHEST_KEEP)
	public final static Iterator<Object[]> getHighestKeep() throws Exception {
		return DiceFunctionValuesTestParametersFactory.getInstance()
				.getHighestKeep();
	}

	@DataProvider(name = HIGHEST_REMOVE)
	public final static Iterator<Object[]> getHighestRemove() throws Exception {
		return DiceFunctionValuesTestParametersFactory.getInstance()
				.getHighestRemove();
	}

	@DataProvider(name = LOWEST_KEEP)
	public final static Iterator<Object[]> getLowestKeep() throws Exception {
		return DiceFunctionValuesTestParametersFactory.getInstance()
				.getLowestKeep();
	}

	@DataProvider(name = LOWEST_REMOVE)
	public final static Iterator<Object[]> getLowestRemove() throws Exception {
		return DiceFunctionValuesTestParametersFactory.getInstance()
				.getLowestRemove();
	}

	public TestExtremesDiceFunction() {
		super();
		// TODO: Make these tests parameterized
	}

	@Test(dataProvider = HIGHEST_KEEP)
	public final void testKeep_Highest(final Integer count,
			final Collection<Integer> rolls, final Collection<Integer> expected) {
		final DiceFunction function;

		function = new ExtremesDiceFunction(
				ExtremesDiceFunction.Extreme.HIGHEST,
				ExtremesDiceFunction.KeepRemove.KEEP, count);

		Assert.assertEquals(function.applyFunction(rolls), expected);
	}

	@Test(dataProvider = LOWEST_KEEP)
	public final void testKeep_Lowest(final Integer count,
			final Collection<Integer> rolls, final Collection<Integer> expected) {
		final DiceFunction function;

		function = new ExtremesDiceFunction(
				ExtremesDiceFunction.Extreme.LOWEST,
				ExtremesDiceFunction.KeepRemove.KEEP, count);

		Assert.assertEquals(function.applyFunction(rolls), expected);
	}

	@Test(dataProvider = HIGHEST_REMOVE)
	public final void testRemove_Highest(final Integer count,
			final Collection<Integer> rolls, final Collection<Integer> expected) {
		final DiceFunction function;

		function = new ExtremesDiceFunction(
				ExtremesDiceFunction.Extreme.HIGHEST,
				ExtremesDiceFunction.KeepRemove.REMOVE, count);

		Assert.assertEquals(function.applyFunction(rolls), expected);
	}

	@Test(dataProvider = LOWEST_REMOVE)
	public final void testRemove_Lowest(final Integer count,
			final Collection<Integer> rolls, final Collection<Integer> expected) {
		final DiceFunction function;

		function = new ExtremesDiceFunction(
				ExtremesDiceFunction.Extreme.LOWEST,
				ExtremesDiceFunction.KeepRemove.REMOVE, count);

		Assert.assertEquals(function.applyFunction(rolls), expected);
	}

}
