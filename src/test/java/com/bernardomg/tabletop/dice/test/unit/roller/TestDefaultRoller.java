/**
 * Copyright 2014-2018 the original author or authors
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

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;
import com.bernardomg.tabletop.dice.roller.random.NumberGenerator;
import com.google.common.collect.Iterables;

/**
 * Units tests for {@code DefaultRoller}, checking that it returns values as
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
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(-1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertEquals((Integer) (-1),
                roller.roll(dice).iterator().next());
    }

    /**
     * Verifies that the roller handles dice with negative sides.
     */
    @Test
    public final void testRoll_NegativeSides() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(-1);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertEquals((Integer) (1),
                roller.roll(dice).iterator().next());
    }

    /**
     * Verifies that the roller returns no results when the dice quantity is 0.
     */
    @Test
    public final void testRoll_NoDice_Empty() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(0);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertTrue(Iterables.isEmpty(roller.roll(dice)));
    }

    /**
     * Verifies that the roller handles dice with no sides.
     */
    @Test
    public final void testRoll_NoSides() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(0);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertEquals(0, Iterables.size(roller.roll(dice)));
    }

    /**
     * Verifies that the roller returns as many values as the quantity of dice.
     */
    @Test
    public final void testRoll_ResultsSize() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(10);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertEquals(10, Iterables.size(roller.roll(dice)));
    }

    /**
     * Verifies that the roller returns the values generated by its number
     * generator.
     */
    @Test
    public final void testRoll_ReturnsGenerated() {
        final Roller roller;                // Roller being tested
        final Dice dice;                    // Die to roll
        final NumberGenerator generator;    // Number generator used
        final Iterable<Integer> result;   // Roll results
        final Iterator<Integer> itrInteger; // Results iterator

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate(ArgumentMatchers.any())).thenReturn(3,
                5, 1);

        // Initializes roller
        roller = new DefaultRoller(generator);

        // Rolls dice
        result = roller.roll(dice);
        itrInteger = result.iterator();

        Assertions.assertEquals((Integer) 3, itrInteger.next());
        Assertions.assertEquals((Integer) 5, itrInteger.next());
        Assertions.assertEquals((Integer) 1, itrInteger.next());
    }

    /**
     * Verifies that the roller handles the smallest possible dice.
     */
    @Test
    public final void testRoll_Smallest() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Initializes roller
        roller = new DefaultRoller();

        Assertions.assertEquals((Integer) 1,
                roller.roll(dice).iterator().next());
    }

}
