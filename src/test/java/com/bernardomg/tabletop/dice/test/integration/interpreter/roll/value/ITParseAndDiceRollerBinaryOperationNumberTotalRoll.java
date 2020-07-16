/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected total roll for mixed operations using only numbers")
public final class ITParseAndDiceRollerBinaryOperationNumberTotalRoll {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerBinaryOperationNumberTotalRoll() {
        super();
    }

    @Test
    @DisplayName("An addition followed by a multiplication returns the expected value")
    public final void testParse_AddAndMult_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+2*3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(7), result);
    }

    @Test
    @DisplayName("An addition followed by a subtraction returns the expected value")
    public final void testParse_AddAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+2-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(0), result);
    }

    @Test
    @DisplayName("An addition with a negative followed by a subtraction returns the expected value")
    public final void testParse_AddNegAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1+-2-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(-4), result);
    }

    @Test
    @DisplayName("A division followed by an addition returns the expected value")
    public final void testParse_DivAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "6/2+1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    @Test
    @DisplayName("A division followed by a subtraction returns the expected value")
    public final void testParse_DivAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "6/3-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(-1), result);
    }

    @Test
    @DisplayName("A multiplication following by an addition returns the expected value")
    public final void testParse_MultAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*3+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(8), result);
    }

    @Test
    @DisplayName("A multiplication followed by a division returns the expected value")
    public final void testParse_MultAndDiv_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*4/2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    @Test
    @DisplayName("A multiplication followed by a subtraction returns the expected value")
    public final void testParse_MultAndSub_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2*3-3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(3), result);
    }

    @Test
    @DisplayName("A subtraction followed by an addition returns the expected value")
    public final void testParse_SubAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3-1+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(4), result);
    }

    @Test
    @DisplayName("An addition followed by a division returns the expected value")
    public final void testParse_SubAndDiv_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2-8/2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(-2), result);
    }

    @Test
    @DisplayName("A subtraction followed by a multiplication returns the expected value")
    public final void testParse_SubAndMult_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1-2*3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(-5), result);
    }

    @Test
    @DisplayName("A subtraction of a negative followed by an addition returns the expected value")
    public final void testParse_SubNegAndAdd_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3--1+2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(6), result);
    }

    @Test
    @DisplayName("A subtraction of a negative followed by an addition of a negative returns the expected value")
    public final void testParse_SubNegAndAddNeg_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3--1+-2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(2), result);
    }

}
