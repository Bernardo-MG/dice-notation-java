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

package com.bernardomg.tabletop.dice.test.integration.transformer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration test for {@code RollerTransformer}, checking that it transforms
 * parsed expressions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformer {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformer() {
        super();
    }

    /**
     * Verifies that numeric operations can be parsed and transformed.
     */
    @Test
    public final void testParse_NumberOperation() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value

        parsed = new DefaultDiceNotationExpressionParser().parse("1-2+3");

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(2), result);
    }

    /**
     * Verifies that dice notation with a single dice and a single side can be
     * parsed and transformed.
     */
    @Test
    public final void testParse_OnesDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value

        parsed = new DefaultDiceNotationExpressionParser().parse("1d1");

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(1), result);
    }

    /**
     * Verifies that dice notation with a simple dice and an addition can be
     * parsed and transformed.
     */
    @Test
    public final void testParse_OnesDice_Addition() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value

        parsed = new DefaultDiceNotationExpressionParser().parse("1d1+2");

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(3), result);
    }

}
