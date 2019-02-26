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

package com.bernardomg.tabletop.dice.parser;

import com.bernardomg.tabletop.dice.interpreter.DiceInterpreter;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Transforms a dice notation expression, received as a string, into the dice
 * notation model.
 * <p>
 * The returned object is expected to be the root node of a tree made up by dice
 * notation model objects.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DiceParser {

    /**
     * Transforms a dice notation expression into the dice notation model.
     * 
     * @param expression
     *            the expression to parse
     * @return a dice notation expression object
     */
    public DiceNotationExpression parse(final String expression);

    /**
     * Transforms a dice notation expression into the dice notation model and
     * applies the received interpreter.
     * 
     * @param expression
     *            the expression to parse
     * @param interpreter
     *            interpreter to apply
     * @return the expression transformed by the interpreter
     */
    public <V> V parse(final String expression,
            final DiceInterpreter<V> interpreter);

}
