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

package com.wandrell.tabletop.dice.test.unit.dice;

import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;

public final class TestExceptionConstructorDefaultDice {

	public TestExceptionConstructorDefaultDice() {
		super();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testQuantity_Negative() {
		new DefaultDice(-1, 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testSides_Negative() {
		new DefaultDice(0, -1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testSides_Zero() {
		new DefaultDice(0, 0);
	}

}
