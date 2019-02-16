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

/**
 * Immutable roll history.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DefaultRollHistory implements RollHistory {

    /**
     * The text representation of the roll history.
     */
    private final String               historyText;

    /**
     * The results of each expression.
     */
    private final Iterable<RollResult> rollResults;

    /**
     * Sum of all the generated values.
     */
    private final Integer              totalRoll;

    /**
     * Constructs a roll history with the specified data.
     * 
     * @param results
     *            each roll result
     * @param text
     *            history text
     * @param total
     *            sum of all the values
     */
    public DefaultRollHistory(final Iterable<RollResult> results,
            final String text, final Integer total) {
        super();

        rollResults = checkNotNull(results,
                "Received a null pointer as roll results");
        historyText = checkNotNull(text,
                "Received a null pointer as history text");
        totalRoll = checkNotNull(total,
                "Received a null pointer as total roll");
    }

    @Override
    public final String getHistoryText() {
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
