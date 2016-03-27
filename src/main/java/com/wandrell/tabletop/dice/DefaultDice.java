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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Implementation of {@code Dice} for a general use.
 * <p>
 * This just supports the most basic representation of a dice. If complex
 * notation, or operations such as dice mapping, are needed, then other classes
 * should be used.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultDice implements Dice {

    /**
     * Number of dice.
     * <p>
     * This is greater or equal to zero.
     */
    private final Integer diceQuantity;

    /**
     * Number of sides in each die.
     * <p>
     * This is greater than zero.
     */
    private final Integer diceSides;

    /**
     * Copy constructor for {@code DefaultDice}.
     * 
     * @param dice
     *            the dice to copy
     */
    public DefaultDice(final DefaultDice dice) {
        super();

        checkNotNull(dice, "Received a null pointer as dice");

        diceSides = dice.diceSides;
        diceQuantity = dice.diceQuantity;
    }

    /**
     * Constructs a {@code DefaultDice} with the specified quantity and sides.
     * <p>
     * The quantity can't be a negative value, and the number of sides should be
     * greater than zero. Otherwise an exception is thrown.
     * 
     * @param quantity
     *            the number of dice
     * @param sides
     *            the sides each die has
     */
    public DefaultDice(final Integer quantity, final Integer sides) {
        super();

        checkNotNull(quantity, "Received a null pointer as quantity");
        checkNotNull(sides, "Received a null pointer as sides");

        checkArgument(quantity >= 0, "The quantity of dice can't be negative");
        checkArgument(sides >= 1, "The number of sides can't be lower than 1");

        diceSides = sides;
        diceQuantity = quantity;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DefaultDice other;

        other = (DefaultDice) obj;

        return Objects.equal(diceQuantity, other.diceQuantity)
                && Objects.equal(diceSides, other.diceSides);
    }

    /**
     * Returns the number of dice which compose this group.
     * <p>
     * This is a positive value or zero.
     * 
     * @return the number of dice being rolled
     */
    @Override
    public final Integer getQuantity() {
        return diceQuantity;
    }

    /**
     * Returns the number of sides of the die being rolled.
     * <p>
     * All the dice will have this same number of sides.
     * <p>
     * This is a positive value greater than zero.
     * 
     * @return the die's number of sides
     */
    @Override
    public final Integer getSides() {
        return diceSides;
    }

    @Override
    public final String getStringRepresentation() {
        return String.format("%dd%d", getQuantity(), getSides());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(diceQuantity, diceSides);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("quantity", diceQuantity)
                .add("sides", diceSides).toString();
    }

}
