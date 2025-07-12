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

import java.util.Objects;

/**
 * Immutable roll history.
 * <p>
 * To allow returning a clean text output of the full history it receives a text history in the constructor. This will
 * be returned by the {@code toString} method.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final record DefaultRollHistory(Iterable<RollResult> rollResults, String historyText, Integer totalRoll)
        implements RollHistory {

    /**
     * Constructs a roll history with the specified data.
     * <p>
     * The text history will be used for the {@code toString} method.
     *
     * @param rollResults
     *            each roll result
     * @param historyText
     *            history text
     * @param totalRoll
     *            sum of all the values
     */
    public DefaultRollHistory(final Iterable<RollResult> rollResults, final String historyText,
            final Integer totalRoll) {

        this.rollResults = Objects.requireNonNull(rollResults, "Received a null pointer as roll results");
        this.historyText = Objects.requireNonNull(historyText, "Received a null pointer as history text");
        this.totalRoll = Objects.requireNonNull(totalRoll, "Received a null pointer as total roll");
    }

    @Override
    public final String toString() {
        return historyText;
    }

    @Override
    public final Iterable<RollResult> getRollResults() {
        return rollResults;
    }

    @Override
    public final Integer getTotalRoll() {
        return totalRoll;
    }

}
