/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.roller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;
import com.google.common.collect.Iterables;

/**
 * Units tests for {@link DefaultRoller}, checking that it returns values as
 * expected.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDefaultRoller {

    /**
     * Default constructor.
     */
    public TestDefaultRoller() {
        super();
    }

    /**
     * Verifies that the roller handles negative dice.
     */
    @Test
    public final void testRoll_NegativeQuantity() {
        final Dice dice;      // Mocked dice
        final Roller roller;  // Tested roller
        final Integer rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(-1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice).iterator().next();

        Assertions.assertEquals((Integer) (-1), rolled);
    }

    /**
     * Verifies that the roller returns 0 when the sides are negative.
     */
    @Test
    public final void testRoll_NegativeSides_Zero() {
        final Dice dice;      // Mocked dice
        final Roller roller;  // Tested roller
        final Integer rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(-1);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice).iterator().next();

        Assertions.assertEquals((Integer) (0), rolled);
    }

    /**
     * Verifies that the roller returns no results when the dice quantity is 0.
     */
    @Test
    public final void testRoll_NoDice_Empty() {
        final Dice dice;                // Mocked dice
        final Roller roller;            // Tested roller
        final Iterable<Integer> rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(0);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice);

        Assertions.assertTrue(Iterables.isEmpty(rolled));
    }

    /**
     * Verifies that the roller returns 0 when there are no sides.
     */
    @Test
    public final void testRoll_NoSides_Zero() {
        final Dice dice;      // Mocked dice
        final Roller roller;  // Tested roller
        final Integer rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(0);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice).iterator().next();

        Assertions.assertEquals((Integer) (0), rolled);
    }

    /**
     * Verifies that the roller returns as many values as the quantity of dice.
     */
    @Test
    public final void testRoll_ResultsSize() {
        final Dice dice;                // Mocked dice
        final Roller roller;            // Tested roller
        final Iterable<Integer> rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(10);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice);

        Assertions.assertEquals(10, Iterables.size(rolled));
    }

    /**
     * Verifies that the roller handles the smallest possible dice.
     */
    @Test
    public final void testRoll_Smallest_ResultsSize() {
        final Dice dice;                // Mocked dice
        final Roller roller;            // Tested roller
        final Iterable<Integer> rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice);

        Assertions.assertEquals(1, Iterables.size(rolled));
    }

    /**
     * Verifies that the roller handles the smallest possible dice.
     */
    @Test
    public final void testRoll_Smallest_Value() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller
        final Integer rolled; // Generated value

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Initializes roller and generates value
        roller = new DefaultRoller();
        rolled = roller.roll(dice).iterator().next();

        Assertions.assertEquals((Integer) 1, rolled);
    }

}
