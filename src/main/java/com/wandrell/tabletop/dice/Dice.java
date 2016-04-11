/**
 * Copyright 2015-2016 the original author or authors
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

package com.wandrell.tabletop.dice;

/**
 * Represents a group of dice, all with the same number of sides.
 * <p>
 * This group is described by the exact number of dice and their sides. For
 * representing complex notation use the classes fulfilling that purpose.
 * <p>
 * The number of dice should be always positive or zero, and the number of sides
 * should be greater than zero, as any other value would make no sense.
 * <p>
 * No other limitation is applied, even if in the real world the number of sides
 * which a die may physically have are limited by the rules of geometry. This
 * can be easily ignores as, after all, it is not strange to see representations
 * and simulations of impossible dice, such as d3, being used on games.
 * <p>
 * While this interface does not give direct support to it, the main use of a
 * dice is generating a random number. For that use, a die can be considered an
 * interval on the range [1,(number of sides)], from which a random number is
 * picked each time a roll is made.
 * <p>
 * The number of dice indicates how many rolls are to be made.
 * <p>
 * Dice also have a textual representation, being it
 * "(number)d(sides)+modifier)". For example, a single die of six sides is a
 * "1d6", and three dice of twenty sides are "3d20".
 * <p>
 * This textual representation is also one of the most basic structures used on
 * dice/RPG notation.
 * 
 * @author Bernardo Martínez Garrido
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
     * Returns the number of sides of the die being rolled.
     * <p>
     * All the dice will have this same number of sides.
     * <p>
     * This is expected to be a positive value greater than zero.
     * 
     * @return the die's number of sides
     */
    public Integer getSides();

}
