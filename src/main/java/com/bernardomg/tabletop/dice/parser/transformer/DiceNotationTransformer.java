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

package com.bernardomg.tabletop.dice.parser.transformer;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Transforms a dice notation expression into another object. This is a parser,
 * but to avoid mistakes with the actual grammar parser another name was chosen.
 * <p>
 * This can be used to parse the dice notation tree into any value as needed,
 * for example to generate the value represented by said notation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 * @param <V>
 *            type of the generated object
 */
public interface DiceNotationTransformer<V> {

    /**
     * Transforms an expression into another object.
     * 
     * @param expression
     *            expression to transform
     * @return an object generated from the expression
     */
    public V transform(final DiceNotationExpression expression);

}
