/**
 * Copyright 2014-2020 the original author or authors
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

/**
 * Full history of rolls generated from a dice notation expression.
 * <p>
 * A {@link RollResult} will be present for each dice set rolled.
 * <p>
 * Note that constants may be represented as dice set with a single side, and as
 * many dice as the value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface RollHistory {

    /**
     * The results from rolling each dice set.
     * 
     * @return the results from rolling each dice set
     */
    public Iterable<RollResult> getRollResults();

    /**
     * The sum of all the rolled values.
     * 
     * @return the sum of all the rolled values
     */
    public Integer getTotalRoll();

}
