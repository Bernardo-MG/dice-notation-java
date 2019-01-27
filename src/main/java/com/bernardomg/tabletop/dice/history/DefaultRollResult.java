/**
 * Copyright 2014-2019 the original author or authors
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.Dice;

/**
 * Immutable roll result.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DefaultRollResult implements RollResult {

    /**
     * All the generated values.
     */
    private final Iterable<Integer> allRolls;

    /**
     * Rolled dice.
     */
    private final Dice              dice;

    /**
     * Sum of all the generated values.
     */
    private final Integer           finalRoll;

    /**
     * Constructs a roll result with the specified data.
     * 
     * @param rolled
     *            rolled dice
     * @param rolls
     *            generated values
     * @param result
     *            sum of all the values
     */
    public DefaultRollResult(final Dice rolled, final Iterable<Integer> rolls,
            final Integer result) {
        super();

        dice = checkNotNull(rolled, "Received a null pointer as dice");
        allRolls = checkNotNull(rolls, "Received a null pointer as rolls");
        finalRoll = checkNotNull(result,
                "Received a null pointer as final roll");
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
    public final Integer getFinalRoll() {
        return finalRoll;
    }

}
