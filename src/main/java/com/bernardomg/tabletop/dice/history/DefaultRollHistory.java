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

import java.util.Objects;

import lombok.Data;
import lombok.NonNull;

/**
 * Immutable roll history.
 * <p>
 * To allow returning a clean text output of the full history it receives a text history in the constructor. This will
 * be returned by the {@code toString} method.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Data
public final class DefaultRollHistory implements RollHistory {

    /**
     * The text representation of the roll history.
     * <p>
     * Used as the string representation of the history.
     */
    @NonNull
    private final String               historyText;

    /**
     * The results of each expression.
     */
    @NonNull
    private final Iterable<RollResult> rollResults;

    /**
     * Sum of all the generated values.
     */
    @NonNull
    private final Integer              totalRoll;

    /**
     * Constructs a roll history with the specified data.
     * <p>
     * The text history will be used for the {@code toString} method.
     *
     * @param results
     *            each roll result
     * @param text
     *            history text
     * @param total
     *            sum of all the values
     */
    public DefaultRollHistory(@NonNull final Iterable<RollResult> results, @NonNull final String text,
            @NonNull final Integer total) {
        super();

        rollResults = Objects.requireNonNull(results, "Received a null pointer as roll results");
        historyText = Objects.requireNonNull(text, "Received a null pointer as history text");
        totalRoll = Objects.requireNonNull(total, "Received a null pointer as total roll");
    }

    @Override
    public final String toString() {
        return historyText;
    }

}
