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

package com.bernardomg.tabletop.dice.test.unit.random;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;

/**
 * Units tests for {@link RandomNumberGenerator}, verifying that it generates
 * values as expected.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestRandomNumberGenerator {

    /**
     * Default constructor.
     */
    public TestRandomNumberGenerator() {
        super();
    }

    /**
     * Verifies that if the maximum is negative then the result is zero.
     */
    @Test
    public final void testGenerate_NegativeMax_Zero() {
        final NumberGenerator generator;
        final Integer generated;

        generator = new RandomNumberGenerator();

        generated = generator.generate(-1);

        Assertions.assertEquals((Integer) (0), generated);
    }

    /**
     * Verifies that the generated numbers are kept inside the expected
     * interval.
     */
    @Test
    public final void testGenerate_ValuesInBounds() {
        final NumberGenerator generator;   // Tested generator
        final Integer lowerLimit;          // Lowest allowed number
        final Integer upperLimit;          // Highest allowed number
        final Collection<Integer> numbers; // Generated numbers
        final Integer times;               // Times to run the test loop
        final Integer max;                 // Max for the number generation

        generator = new RandomNumberGenerator();

        times = 100;
        max = 10;
        lowerLimit = 1;
        upperLimit = max;

        numbers = new ArrayList<Integer>();
        for (Integer i = 0; i < times; i++) {
            numbers.add(generator.generate(max));
        }

        for (final Integer number : numbers) {
            Assertions.assertTrue(number >= lowerLimit);
            Assertions.assertTrue(number <= upperLimit);
        }
    }

    /**
     * Verifies that if the maximum is zero then the result is zero.
     */
    @Test
    public final void testGenerate_ZeroMax_Zero() {
        final NumberGenerator generator;
        final Integer generated;

        generator = new RandomNumberGenerator();

        generated = generator.generate(0);

        Assertions.assertEquals((Integer) (0), generated);
    }

}
