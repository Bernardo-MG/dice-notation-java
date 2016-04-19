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

package com.wandrell.tabletop.dice.notation.operation;

import java.util.Collection;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.notation.operation.constant.DiceConstant;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;

public final class DiceOperand implements Operand {

    private final DiceConstant dice;

    private final Roller       roller;

    public DiceOperand(final DiceConstant dice) {
        super();

        this.dice = dice;
        this.roller = new DefaultRoller();
    }

    public DiceOperand(final DiceConstant dice, final Roller roller) {
        super();

        this.dice = dice;
        this.roller = roller;
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

        final DiceOperand other;

        other = (DiceOperand) obj;

        return Objects.equal(dice, other.dice);
    }

    public final DiceConstant getDice() {
        return dice;
    }

    @Override
    public final String getStringRepresentation() {
        return getDice().getStringRepresentation();
    }

    @Override
    public final Integer getValue() {
        final Collection<Integer> values;
        Integer sum;

        values = getRoller().roll(getDice().getDice());

        sum = 0;
        for (final Integer value : values) {
            sum += value;
        }

        return sum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dice);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("dice", dice).toString();
    }

    private final Roller getRoller() {
        return roller;
    }

}
