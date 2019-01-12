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

package com.bernardomg.tabletop.dice.test.integration.parser.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses simple binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserBinaryOperationValue {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserBinaryOperationValue() {
        super();
    }

    /**
     * Verifies that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_AddAndSub_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1+2-3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 0, root.roll());
    }

    /**
     * Verifies that divisions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_DivAndAdd_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "6/2+1";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 4, root.roll());
    }

    /**
     * Verifies that divisions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_DivAndSub_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "6/3-3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals(new Integer(-1), root.roll());
    }

    /**
     * Verifies that multiplications followed by additions can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_MultAndAdd_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "2*3+2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 8, root.roll());
    }

    /**
     * Verifies that multiplications followed by subtractions can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_MultAndSub_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "2*3-3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 3, root.roll());
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubAndAdd_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "3-1+2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 4, root.roll());
    }

    /**
     * Verifies that subtractions followed by divisions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubAndDiv_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "2-8/2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals(new Integer(-2), root.roll());
    }

    /**
     * Verifies that subtractions followed by multiplications can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_SubAndMult_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1-2*3";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals(new Integer(-5), root.roll());
    }

}
