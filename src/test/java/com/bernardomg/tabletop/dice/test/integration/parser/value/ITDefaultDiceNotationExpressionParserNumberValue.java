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
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses numbers.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserNumberValue {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserNumberValue() {
        super();
    }

    /**
     * Verifies that a number is parsed correctly.
     */
    @Test
    public final void testParse_Number() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "12";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 12, root.roll());
    }

    /**
     * Verifies that a negative number is parsed correctly.
     */
    @Test
    public final void testParse_Number_Negative() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "-12";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-12), root.roll());
    }

    /**
     * Verifies that a number padded with zeros is parsed correctly.
     */
    @Test
    public final void testParse_Number_ZeroPadding() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "001200";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 1200, root.roll());
    }

}
