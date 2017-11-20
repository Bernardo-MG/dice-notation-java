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

package com.bernardomg.tabletop.dice.test.integration.parser;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;
import com.bernardomg.tabletop.dice.parser.DiceNotationExpressionParser;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;

/**
 * Abstract base test for the {@code DefaultDiceNotationExpressionParser}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public abstract class AbstractITDefaultDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public AbstractITDefaultDiceNotationExpressionParser() {
        super();
    }

    /**
     * Parses the received notation and returns the parsed expression.
     * <p>
     * This encapsulates the parse operation, making the tests smaller.
     * 
     * @param expression
     *            expression to parse
     * @return the parsed object
     */
    protected final DiceNotationExpression parse(final String expression) {
        final DiceNotationExpressionParser parser; // Parser to test

        parser = new DefaultDiceNotationExpressionParser(new DefaultRoller());

        return parser.parse(expression);
    }

}
