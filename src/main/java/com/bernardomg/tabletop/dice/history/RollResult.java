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

import com.bernardomg.tabletop.dice.Dice;

/**
 * Result from rolling a dice set.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface RollResult {

    /**
     * All the values generated from rolling the dice, in the order they were
     * generated.
     * 
     * @return all the dice rolls
     */
    public Iterable<Integer> getAllRolls();

    /**
     * The dice set which generated the value.
     * 
     * @return the dice set
     */
    public Dice getDice();

    /**
     * The sum of all the rolled values.
     * 
     * @return the sum of all the rolled values
     */
    public Integer getTotalRoll();

}
