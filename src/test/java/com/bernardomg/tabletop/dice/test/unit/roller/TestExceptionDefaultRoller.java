/**
 * Copyright 2014-2017 the original author or authors
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
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;

/**
 * Units tests for {@code DefaultRoller}, checking that it throws exceptions
 * when required.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestExceptionDefaultRoller {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultRoller() {
        super();
    }

    /**
     * Tests that rolling a dice with negative quantity throws an exception.
     */
    @Test
    public final void testRoll_NegativeQuantity() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller
        final Executable closure;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(-10);
        Mockito.when(dice.getSides()).thenReturn(6);

        // Initializes roller
        roller = new DefaultRoller();

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                roller.roll(dice);
            }

        };

        Assertions.assertThrows(IllegalArgumentException.class, closure);
    }

    /**
     * Tests that rolling a dice with negative sides throws an exception.
     */
    @Test
    public final void testRoll_NegativeSides() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller
        final Executable closure;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(10);
        Mockito.when(dice.getSides()).thenReturn(-6);

        // Initializes roller
        roller = new DefaultRoller();

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                roller.roll(dice);
            }

        };

        Assertions.assertThrows(IllegalArgumentException.class, closure);
    }

    /**
     * Tests that rolling a dice with 0 as sides throws an exception.
     */
    @Test
    public final void testRoll_NoSides() {
        final Dice dice;     // Mocked dice
        final Roller roller; // Tested roller
        final Executable closure;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(10);
        Mockito.when(dice.getSides()).thenReturn(0);

        // Initializes roller
        roller = new DefaultRoller();

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                roller.roll(dice);
            }

        };

        Assertions.assertThrows(IllegalArgumentException.class, closure);
    }

}
