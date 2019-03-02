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

package com.bernardomg.tabletop.dice.random;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Random}-based number generator.
 * <p>
 * The generated numbers will be integers in a closed interval, beginning at 1
 * and ending in a specified maximum value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class RandomNumberGenerator extends AbstractNumberGenerator {

    /**
     * Logger.
     */
    private static final Logger  LOGGER      = LoggerFactory
            .getLogger(RandomNumberGenerator.class);

    /**
     * Lower limit for the number generation procedure.
     * <p>
     * As dice should always have a positive number of sides, the lowest allowed
     * value will be one. Even if there are no dice with less that two sides.
     */
    private static final Integer LOWER_LIMIT = 1;

    /**
     * Random number generator for generating roll values.
     * <p>
     * To keep the seed, a single instance is used on all the rolls.
     */
    private final Random         random      = new Random();

    /**
     * Default constructor.
     */
    public RandomNumberGenerator() {
        super();
    }

    /**
     * Generates a random value.
     * <p>
     * This value is in the interval [1,max].
     * <p>
     * TODO: Should be a protected method
     * 
     * @param max
     *            the maximum value which can be generated
     * @return a random value in the interval [1,max]
     */
    @Override
    public final Integer generate(final Integer max) {
        final Integer result;

        if (max < LOWER_LIMIT) {
            LOGGER.warn(
                    "Received {} as maximum value, but this is lower than {}",
                    max, LOWER_LIMIT);
            result = 0;
        } else {
            result = random.nextInt(Math.abs(LOWER_LIMIT - max) + 1)
                    + LOWER_LIMIT;
        }

        return result;
    }

}
