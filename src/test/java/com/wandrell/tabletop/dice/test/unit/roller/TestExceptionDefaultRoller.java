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

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;

/**
 * Units tests for {@code DefaultRoller}, checking that it throws exceptions
 * when required.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Rolling a dice with negative sides throws an exception.</li>
 * <li>Rolling a dice with negative quantity throws an exception.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionDefaultRoller {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultRoller() {
        super();
    }

    /**
     * Tests that rolling a dice with negative quantity throws an exception..
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public final void testRoll_NegativeQuantity() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(-10);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller
        roller = new DefaultRoller();

        roller.roll(dice);
    }

    /**
     * Tests that rolling a dice with negative sides throws an exception..
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public final void testRoll_NegativeSides() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(10);
        Mockito.when(dice.getSides()).thenReturn(-6);

        // Initializes roller
        roller = new DefaultRoller();

        roller.roll(dice);
    }

}
