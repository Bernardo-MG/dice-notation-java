/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.random;

/**
 * Generates a random integer value.
 * <p>
 * This allows hiding the actual method used for generating said value, allowing
 * tuning the actual probabilities of the values.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface NumberGenerator {

    /**
     * Generates a random value in the interval [1,max].
     * 
     * @param max
     *            the maximum value allowed
     * @return a random value in the interval [1,max]
     */
    public Integer generate(final Integer max);

}
