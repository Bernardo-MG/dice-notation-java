/**
 * Copyright 2014-2023 the original author or authors
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

import com.bernardomg.tabletop.dice.Dice;

/**
 * Generates a random integer value. This allows tuning the actual probabilities distributions.
 * <p>
 * The possible values which the generator may return are expected to begin at 1, and end in a specified maximum value.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface NumberGenerator {

    /**
     * Generates a collection of random values from the received {@code Dice}.
     * <p>
     * These are returned in the same order they were generated.
     *
     * @param dice
     *            the dice to roll
     * @return a collection of random values generated from the dice
     */
    public Iterable<Integer> generate(final Dice dice);

    /**
     * Generates a random value.
     * <p>
     * This is expected to be in the interval [1,max].
     *
     * @param max
     *            the maximum value which can be generated
     * @return a random value
     */
    public Integer generate(final Integer max);

}
