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

package com.bernardomg.tabletop.dice.notation;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;

/**
 * A dice notation expression.
 * <p>
 * Dice notation expressions are meant to generate a value. Note that this value
 * may be generated at random, and as such it can be different each time it is
 * acquired.
 * <p>
 * It is also possible getting the string representation of the dice notation
 * expression it represents.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DiceNotationExpression {

    /**
     * Returns the expression as a string.
     * <p>
     * This will be the dice expression as it is written, for example "2+1d6".
     * 
     * @return the expression as a string
     */
    public String getExpression();

    /**
     * Returns a value from the expression
     * <p>
     * This allows acquiring custom data from the expression tree.
     * 
     * @param interpreter
     *            contains the logic to transform the expression
     * @return transformed result
     */
    public <V> V transform(final DiceNotationTransformer<V> interpreter);

}
