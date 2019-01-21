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

package com.bernardomg.tabletop.dice.test.integration.transformer.roll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;
import com.bernardomg.tabletop.dice.parser.transformer.RollerTransformer;

/**
 * Integration tests for {@link DefaultDiceNotationExpressionParser}, verifying
 * that it parses numeric substractions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerSubstractionNumberValue {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerSubstractionNumberValue() {
        super();
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1-2-3";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(-4), result);
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1-2-3-4-5";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(-13), result);
    }

    /**
     * Verifies that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1-2";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(-1), result);
    }

}
