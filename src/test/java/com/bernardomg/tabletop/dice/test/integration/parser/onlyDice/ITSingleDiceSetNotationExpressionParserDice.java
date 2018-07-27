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

package com.bernardomg.tabletop.dice.test.integration.parser.onlyDice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.parser.SingleDiceSetNotationExpressionParser;

/**
 * Integration tests for {@code SingleDiceSetNotationExpressionParser}, checking
 * that it parses dice notation expressions for single dice groups.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITSingleDiceSetNotationExpressionParserDice {

    /**
     * Default constructor.
     */
    public ITSingleDiceSetNotationExpressionParserDice() {
        super();
    }

    /**
     * Tests that complex expressions are parsed, returning the last dice set.
     */
    @Test
    public final void testParse_Complex_ReturnsLast() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser()
                .parse("1d20-5+2d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(2));
        Assertions.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that dice notation with the maximum integer values dice is parsed.
     */
    @Test
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser()
                .parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE);

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(),
                new Integer(Integer.MAX_VALUE));
        Assertions.assertEquals(dice.getSides(),
                new Integer(Integer.MAX_VALUE));
    }

    /**
     * Tests that multiple dice are parsed, returning the last one.
     */
    @Test
    public final void testParse_Multiple_ReturnsLast() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser().parse("1d20+2d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(2));
        Assertions.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that dice notation with a single dice and a single side can be
     * parsed.
     */
    @Test
    public final void testParse_OnesDice_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser().parse("1d1");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(1));
        Assertions.assertEquals(dice.getSides(), new Integer(1));
    }

    /**
     * Tests that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser().parse("1d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(1));
        Assertions.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple_UpperCaseSeparator() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser().parse("1D6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(1));
        Assertions.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that dice notation with zero dice is parsed.
     */
    @Test
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new SingleDiceSetNotationExpressionParser().parse("0d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(dice.getQuantity(), new Integer(0));
        Assertions.assertEquals(dice.getSides(), new Integer(6));
    }

}
