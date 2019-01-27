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
     * Sum of all the generated values.
     */
    private final Integer              finalRoll;

    /**
     * The results of each dice set.
     */
    private final Iterable<RollResult> rollResults;

    /**
     * Constructs a roll history with the specified data.
     * 
     * @param results
     *            each roll result
     * @param result
     *            sum of all the values
     */
    public DefaultRollHistory(final Iterable<RollResult> results,
            final Integer result) {
        super();

        rollResults = checkNotNull(results,
                "Received a null pointer as roll results");
        finalRoll = checkNotNull(result,
                "Received a null pointer as final roll");
    }

    @Override
    public final Integer getFinalRoll() {
        return finalRoll;
    }

    @Override
    public final Iterable<RollResult> getRollResults() {
        return rollResults;
    }

}
