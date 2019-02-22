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

package com.bernardomg.tabletop.dice.test.unit.roll;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;
import com.bernardomg.tabletop.dice.roll.DefaultRollGenerator;
import com.bernardomg.tabletop.dice.visitor.RollTransformer;

/**
 * Units tests for {@link RandomNumberGenerator}, verifying that it generates
 * values as expected.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDefaultRollGenerator {

    /**
     * Default constructor.
     */
    public TestDefaultRollGenerator() {
        super();
    }

    @Test
    public final void testRoll_AppliesTransformer() {
        final Dice dice;
        final RollTransformer trans;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        trans = Mockito.mock(RollTransformer.class);

        new DefaultRollGenerator(trans).roll(dice);

        Mockito.verify(trans, Mockito.times(1))
                .transform(ArgumentMatchers.any(), ArgumentMatchers.any());
    }

    @Test
    public final void testRoll_GeneratesOnce() {
        final Dice dice;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2, 3));

        new DefaultRollGenerator(generator).roll(dice);

        Mockito.verify(generator, Mockito.times(1))
                .generate((Dice) ArgumentMatchers.any());
    }

    /**
     * Verifies that the roller returns a value for each dice set.
     */
    @Test
    public final void testRoll_ReturnsGenerated_AllRolls() {
        final Dice dice;
        final Iterator<Integer> rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2));

        rolled = new DefaultRollGenerator(generator).roll(dice).getAllRolls()
                .iterator();

        Assertions.assertEquals(new Integer(1), rolled.next());
        Assertions.assertEquals(new Integer(2), rolled.next());
    }

    /**
     * Verifies that the roller returns a value for each dice set.
     */
    @Test
    public final void testRoll_ReturnsGenerated_TotalRoll_MultipleValues() {
        final Dice dice;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2, 3));

        rolled = new DefaultRollGenerator(generator).roll(dice).getTotalRoll();

        Assertions.assertEquals(new Integer(6), rolled);
    }

    @Test
    public final void testRoll_ReturnsGenerated_TotalRoll_SingleValue() {
        final Dice dice;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(5));

        rolled = new DefaultRollGenerator(generator).roll(dice).getTotalRoll();

        Assertions.assertEquals(new Integer(5), rolled);
    }

}
