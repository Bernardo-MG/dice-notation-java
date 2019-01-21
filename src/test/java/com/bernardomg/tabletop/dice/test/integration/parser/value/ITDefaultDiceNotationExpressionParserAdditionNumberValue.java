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
 * that it parses numeric additions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserAdditionNumberValue {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserAdditionNumberValue() {
        super();
    }

    /**
     * Verifies that long additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Long_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1+2+3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 6, root.roll());
    }

    /**
     * Verifies that longer additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Longer_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1+2+3+4+5";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 15, root.roll());
    }

    /**
     * Verifies that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1+2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 3, root.roll());
    }

}
