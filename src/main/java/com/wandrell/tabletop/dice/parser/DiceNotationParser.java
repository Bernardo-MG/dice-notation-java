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

package com.wandrell.tabletop.dice.parser;

import com.wandrell.tabletop.dice.notation.DiceExpressionRoot;

/**
 * Transforms a dice notation expression, received as a string, into an object
 * representing it.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface DiceNotationParser {

    /**
     * Returns an object representing the received dice notation expression.
     * 
     * @param expression
     *            the expression to parse
     * @return an object representing the received expression
     */
    public DiceExpressionRoot parse(final String expression);

}
