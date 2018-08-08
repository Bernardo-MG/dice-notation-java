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

package com.bernardomg.tabletop.dice.notation.operand;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.Dice;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Default implementation of the dice operand.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultDiceOperand implements DiceOperand {

    /**
     * Operand dice value.
     */
    private final Dice dice;

    /**
     * Constructs a dice operand with the specified dice.
     * 
     * @param diceSet
     *            dice for the operand
     */
    public DefaultDiceOperand(final Dice diceSet) {
        super();

        dice = checkNotNull(diceSet, "Received a null pointer as dice");
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

        final DefaultDiceOperand other;

        other = (DefaultDiceOperand) obj;

        return Objects.equal(dice, other.dice);
    }

    @Override
    public final Dice getDice() {
        return dice;
    }

    @Override
    public final String getExpression() {
        return String.format("%dd%d", getDice().getQuantity(),
                getDice().getSides());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(dice);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("dice", dice).toString();
    }

}
