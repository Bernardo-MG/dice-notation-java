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

package com.wandrell.tabletop.dice.roller.random;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Random;

/**
 * {@link Random}-based number generator.
 * <p>
 * The generated numbers will be integers in a closed interval, beginning at 1
 * and ending in a specified maximum value.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class RandomNumberGenerator implements NumberGenerator {

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
     * 
     * @param max
     *            the maximum value which can be generated
     * @return a random value in the interval [1,max]
     */
    @Override
    public final Integer generate(final Integer max) {
        checkArgument(max >= LOWER_LIMIT, String.format(
                "The maximum value can't be lower than %d", LOWER_LIMIT));

        return getRandom().nextInt(Math.abs(LOWER_LIMIT - max) + 1)
                + LOWER_LIMIT;
    }

    /**
     * Returns the random numbers generator class.
     * 
     * @return the random numbers generator class
     */
    private final Random getRandom() {
        return random;
    }

}
