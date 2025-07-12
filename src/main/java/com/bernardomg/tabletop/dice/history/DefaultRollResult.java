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

package com.bernardomg.tabletop.dice.history;

import java.util.Arrays;
import java.util.Objects;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;

/**
 * Immutable roll result. Contains all the values generated and the sum of them.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final record DefaultRollResult(Dice dice, Iterable<Integer> allRolls, Integer totalRoll) implements RollResult {

    /**
     * Constructs a roll result with the specified data.
     *
     * @param dice
     *            dice which generated the result
     * @param allRolls
     *            generated values
     * @param totalRoll
     *            sum of all the values
     */
    public DefaultRollResult(final Dice dice, final Iterable<Integer> allRolls, final Integer totalRoll) {
        this.dice = Objects.requireNonNull(dice, "Received a null pointer as dice");
        this.allRolls = Objects.requireNonNull(allRolls, "Received a null pointer as rolls");
        this.totalRoll = Objects.requireNonNull(totalRoll, "Received a null pointer as total roll");
    }

    /**
     * Constructs a roll result with a single value.
     *
     * @param totalRoll
     *            sum of all the values
     */
    public DefaultRollResult(final Integer totalRoll) {
        this(new DefaultDice(1, totalRoll), Arrays.asList(totalRoll), totalRoll);
    }

    @Override
    public final Iterable<Integer> getAllRolls() {
        return allRolls;
    }

    @Override
    public final Dice getDice() {
        return dice;
    }

    @Override
    public final Integer getTotalRoll() {
        return totalRoll;
    }

}
