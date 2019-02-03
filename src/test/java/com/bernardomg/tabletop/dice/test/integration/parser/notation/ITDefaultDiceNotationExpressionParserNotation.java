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

package com.bernardomg.tabletop.dice.test.integration.parser.notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DefaultDiceParser}, verifying that it parses
 * simple binary operations and the parsed notation can be recovered.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserNotation {

    public ITDefaultDiceNotationExpressionParserNotation() {
        super();
    }

    /**
     * Verifies that an addition using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Add_Dice() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20+2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_LeftNumber() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "5+2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_RightNumber() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "2d6+5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that dice are parsed correctly.
     */
    @Test
    public final void testParse_Dice() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that dice are parsed correctly.
     */
    @Test
    public final void testParse_Dice_BigD() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1D6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals("1d6", operation.getExpression());
    }

    /**
     * Verifies that a mixed operation is parsed correctly.
     */
    @Test
    public final void testParse_Mixed() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20-5*1d8+2d6/3d12";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that dice are parsed correctly.
     */
    @Test
    public final void testParse_NoQuantity() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals("1d6", operation.getExpression());
    }

    /**
     * Verifies that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that long additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Long() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2+3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that longer additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Longer() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2+3+4+5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_AddAndSub() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2-3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2-3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2-3-4-5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_SubAndAdd() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "3-1+2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20-2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "5-2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    /**
     * Verifies that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "2d6-5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

}
