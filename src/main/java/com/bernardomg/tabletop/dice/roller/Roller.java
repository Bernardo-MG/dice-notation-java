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

package com.bernardomg.tabletop.dice.roller;

import com.bernardomg.tabletop.dice.Dice;

/**
 * Generates random integer values from a {@link Dice}. The name makes reference
 * to the act of rolling the dice, which is the way to generate random values
 * from them.
 * <p>
 * A die can be considered an interval on the range [1,(number of sides)], from
 * which a random number is picked each time a roll is made. This is done as
 * many times as the quantity of dice received.
 * <p>
 * Once all the dice have been rolled the results will be returned as a
 * {@code Collection}. This is expected to contain the values in the same order
 * they were generated.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * @see Dice
 */
public interface Roller {

    /**
     * Generates a collection of random values from the received {@code Dice}.
     * <p>
     * These are expected to be returned in the same order they were generated.
     * 
     * @param dice
     *            the dice to roll
     * @return a collection of random values generated from the dice
     */
    public Iterable<Integer> roll(final Dice dice);

}
