/**
 * Copyright 2014-2022 the original author or authors
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

import lombok.Data;
import lombok.NonNull;

/**
 * Immutable roll result. Contains all the values generated and the sum of them.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Data
public final class DefaultRollResult implements RollResult {

    /**
     * All the generated values.
     */
    @NonNull
    private final Iterable<Integer> allRolls;

    /**
     * Rolled dice.
     */
    @NonNull
    private final Dice              dice;

    /**
     * Sum of all the generated values.
     */
    @NonNull
    private final Integer           totalRoll;

    /**
     * Constructs a roll result with the specified data.
     * 
     * @param d
     *            dice which generated the result
     * @param rolls
     *            generated values
     * @param total
     *            sum of all the values
     */
    public DefaultRollResult(@NonNull final Dice d,
            @NonNull final Iterable<Integer> rolls,
            @NonNull final Integer total) {
        super();

        dice = Objects.requireNonNull(d, "Received a null pointer as dice");
        allRolls = Objects.requireNonNull(rolls,
                "Received a null pointer as rolls");
        totalRoll = Objects.requireNonNull(total,
                "Received a null pointer as total roll");
    }

    /**
     * Constructs a roll result with a single value.
     * 
     * @param total
     *            sum of all the values
     */
    public DefaultRollResult(@NonNull final Integer total) {
        super();

        dice = new DefaultDice(1, total);
        totalRoll = Objects.requireNonNull(total,
                "Received a null pointer as total roll");

        allRolls = Arrays.asList(total);
    }

}
