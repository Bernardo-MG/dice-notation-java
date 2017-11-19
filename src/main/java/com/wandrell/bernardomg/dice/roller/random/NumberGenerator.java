/**
 * Copyright 2014-2017 the original author or authors
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

package com.bernardomg.bernardomg.dice.roller.random;

/**
 * Generates a random integer value.
 * <p>
 * This is meant to be used by the implementations of
 * {@link com.bernardomg.bernardomg.dice.roller.Roller Roller}, to tune the actual
 * probabilities distributions.
 * <p>
 * The possible values which the generator may return are expected to begin at
 * 1, and end in a specified maximum value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 * @see com.bernardomg.bernardomg.dice.roller.Roller Roller
 */
public interface NumberGenerator {

    /**
     * Generates a random value.
     * <p>
     * This is expected to be in the interval [1,max].
     * 
     * @param max
     *            the maximum value which can be generated
     * @return a random value
     */
    public Integer generate(final Integer max);

}
