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

package com.bernardomg.tabletop.dice.test.integration.parser.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, verifying
 * that it parses numeric substractions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSubstractionNumberValue {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSubstractionNumberValue() {
        super();
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1-2-3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-4), root.roll());
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1-2-3-4-5";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-13), root.roll());
    }

    /**
     * Verifies that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1-2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-1), root.roll());
    }

}
