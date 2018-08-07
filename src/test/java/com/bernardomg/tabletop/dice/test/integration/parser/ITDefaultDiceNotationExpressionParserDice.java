/**
 * Copyright 2014-2017 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses dice notation expressions for single dice groups.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserDice {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserDice() {
        super();
    }

    /**
     * Verifies that dice notation with the maximum integer values dice is
     * parsed.
     */
    @Test
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser()
                .parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE).getRoot();

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(new Integer(Integer.MAX_VALUE),
                dice.getQuantity());
        Assertions.assertEquals(new Integer(Integer.MAX_VALUE),
                dice.getSides());
    }

    /**
     * Verifies that dice notation with a single dice and a single side can be
     * parsed.
     */
    @Test
    public final void testParse_OnesDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d1")
                .getRoot();

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(1), dice.getSides());
    }

    /**
     * Verifies that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d6")
                .getRoot();

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple_UpperCaseSeparator() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1D6")
                .getRoot();

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that dice notation with zero dice is parsed.
     */
    @Test
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("0d6")
                .getRoot();

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(new Integer(0), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

}
