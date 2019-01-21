/**
 * Copyright 2014-2018 the original author or authors
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
 * Integration tests for {@link RollerTransformer}, verifying that it transforms
 * additions with dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerMultiplicationDiceValue {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerMultiplicationDiceValue() {
        super();
    }

    /**
     * Verifies that an addition using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Add_Dice_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3d1*2d1";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(6), result);
    }

    /**
     * Verifies that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_LeftNumber_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "5*2d1";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(10), result);
    }

    /**
     * Verifies that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_RightNumber_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2d1*5";

        parsed = new DefaultDiceNotationExpressionParser().parse(notation);

        result = new RollerTransformer().transform(parsed);

        Assertions.assertEquals(new Integer(10), result);
    }

}
