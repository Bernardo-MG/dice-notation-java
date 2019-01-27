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

package com.bernardomg.tabletop.dice.test.integration.transformer.roll.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;

/**
 * Integration tests for {@link DiceRoller}, verifying that it transforms simple
 * binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerBinaryOperationValue {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerBinaryOperationValue() {
        super();
    }

    /**
     * Verifies that additions followed by multiplications can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_AddAndMult_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+2*3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(7), result);
    }

    /**
     * Verifies that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_AddAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+2-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(0), result);
    }

    /**
     * Verifies that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_AddNegAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+-2-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(-4), result);
    }

    /**
     * Verifies that divisions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_DivAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "6/2+1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    /**
     * Verifies that divisions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_DivAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "6/3-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(-1), result);
    }

    /**
     * Verifies that dice notation with a long addition operation can be parsed
     * and transformed.
     */
    @Test
    public final void testParse_LongAddition_NoQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value

        parsed = new DefaultDiceParser().parse("1d1+3+d1+12d1+d1");

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(18), result);
    }

    /**
     * Verifies that dice notation with a long arithmetic operation can be
     * parsed and transformed.
     */
    @Test
    public final void testParse_LongArithmetic() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value

        parsed = new DefaultDiceParser().parse("1d1+3*4/2");

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(7), result);
    }

    /**
     * Verifies that multiplications followed by additions can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_MultAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*3+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(8), result);
    }

    /**
     * Verifies that multiplications followed by divisions can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_MultAndDiv_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*4/2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    /**
     * Verifies that multiplications followed by subtractions can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_MultAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*3-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(3), result);
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3-1+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    /**
     * Verifies that subtractions followed by divisions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubAndDiv_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2-8/2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(-2), result);
    }

    /**
     * Verifies that subtractions followed by multiplications can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_SubAndMult_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1-2*3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(-5), result);
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubNegAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3--1+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(6), result);
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_SubNegAndAddNeg_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3--1+-2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getFinalRoll();

        Assertions.assertEquals(new Integer(2), result);
    }

}
