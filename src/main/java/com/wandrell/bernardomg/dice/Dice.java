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

package com.bernardomg.bernardomg.dice;

/**
 * A group of dice, all with the same number of sides.
 * <p>
 * This is meant to represent a group of dice by itself, to handle complex
 * notation the classes in the {@link com.bernardomg.bernardomg.dice.notation
 * notation} package should be used.
 * <p>
 * The number of dice are expected to be positive or zero, and the number of
 * sides greater than zero, as any other value would make no sense.
 * <p>
 * No other limitation is expected. In the real world the number of sides which
 * a die may physically have are limited by the rules of geometry, but there is
 * no reason to take care of that.
 * <p>
 * The main use of a dice is generating a random number. While this is not
 * supported by the interface, any implementation of
 * {@link com.bernardomg.bernardomg.dice.roller.Roller Roller} will take care of
 * that concern.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * @see com.bernardomg.bernardomg.dice.roller.Roller Roller
 */
public interface Dice {

    /**
     * Returns the number of dice which compose this group.
     * <p>
     * This is expected to be a positive value or zero.
     * 
     * @return the number of dice being rolled
     */
    public Integer getQuantity();

    /**
     * Returns the number of sides of the dice in the group.
     * <p>
     * All the dice will have this same number of sides.
     * <p>
     * This is expected to be a positive value greater than zero.
     * 
     * @return the dice's number of sides
     */
    public Integer getSides();

}
