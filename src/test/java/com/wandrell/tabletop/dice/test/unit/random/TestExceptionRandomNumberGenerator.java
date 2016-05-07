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

package com.wandrell.tabletop.dice.test.unit.random;

import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.roller.random.NumberGenerator;
import com.wandrell.tabletop.dice.roller.random.RandomNumberGenerator;

/**
 * Units tests for {@code RandomNumberGenerator}, checking that it throws
 * exceptions when required.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Generating a value for a negative max throws an exception.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionRandomNumberGenerator {

    /**
     * Default constructor.
     */
    public TestExceptionRandomNumberGenerator() {
        super();
    }

    /**
     * Tests that generating a value for a negative max throws an exception.
     */
    @Test(expectedExceptions = { IllegalArgumentException.class })
    public final void testGenerate_NegativeMax() {
        final NumberGenerator generator; // Tested generator

        generator = new RandomNumberGenerator();

        generator.generate(-1);
    }

}
