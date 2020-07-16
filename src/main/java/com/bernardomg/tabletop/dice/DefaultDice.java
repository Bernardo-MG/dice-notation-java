/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Immutable group of dice.
 * <p>
 * Some basic constraints are applied to the dice values. The quantity should be
 * equal or higher than zero, and the number of sides equal or higher than one.
 * If any other value is received then an exception will be thrown.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
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
     * Constructs a dice group with the specified quantity and number sides.
     * <p>
     * The quantity can't be a negative value, and the number of sides should be
     * greater than zero. Otherwise an exception will be thrown.
     * 
     * @param quantity
     *            the number of dice
     * @param sides
     *            the number sides each die has
     */
    public DefaultDice(final Integer quantity, final Integer sides) {
        super();

        diceQuantity = checkNotNull(quantity,
                "Received a null pointer as quantity");
        diceSides = checkNotNull(sides, "Received a null pointer as sides");
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
     * Returns the number of sides of the dice in the group.
     * <p>
     * All the dice will have this same number of sides.
     * <p>
     * This is a positive value greater than zero.
     * 
     * @return the dice's number of sides
     */
    @Override
    public final Integer getSides() {
        return diceSides;
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
