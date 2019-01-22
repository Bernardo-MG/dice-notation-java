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
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;

/**
 * Integration tests for {@link DiceRoller}, verifying that it transforms
 * numeric additions with signed numbers.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerAdditionSignedNumberValue {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerAdditionSignedNumberValue() {
        super();
    }

    /**
     * Verifies that an addition with a negative value is parsed correctly.
     */
    @Test
    public final void testParse_Number_AddNegative_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+-2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed);

        Assertions.assertEquals(new Integer((-1)), result);
    }

    /**
     * Verifies that an addition with a negative value is parsed correctly.
     */
    @Test
    public final void testParse_Number_AddToNegative_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "-1+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed);

        Assertions.assertEquals(new Integer(1), result);
    }

}
