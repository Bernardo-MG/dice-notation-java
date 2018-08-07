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
 * Operand for using dice values on a dice notation expression.
 * <p>
 * The value from a dice operand is random, and will be generated each time it
 * is acquired.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * @see Dice
 */
public final class DefaultDiceOperand implements DiceOperand {

    /**
     * Operand dice.
     * <p>
     * This will be used to generate the random value this operand uses.
     */
    private final Dice operandDice;

    /**
     * Constructs a dice operand with the specified dice and roller.
     * 
     * @param dice
     *            dice for the operand
     */
    public DefaultDiceOperand(final Dice dice) {
        super();

        operandDice = checkNotNull(dice, "Received a null pointer as dice");
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

        return Objects.equal(operandDice, other.operandDice);
    }

    @Override
    public final Dice getDice() {
        return operandDice;
    }

    @Override
    public final String getExpression() {
        return String.format("%dd%d", getDice().getQuantity(),
                getDice().getSides());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(operandDice);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("dice", operandDice)
                .toString();
    }

}
