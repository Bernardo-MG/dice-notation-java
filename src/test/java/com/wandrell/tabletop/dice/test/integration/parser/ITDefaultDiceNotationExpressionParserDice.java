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

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operand.DiceOperand;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses dice notation expressions for single dice groups.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDefaultDiceNotationExpressionParserDice
        extends AbstractITDefaultDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserDice() {
        super();
    }

    /**
     * Tests that dice notation with the maximum integer values dice is parsed.
     */
    @Test
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE);

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), new Integer(Integer.MAX_VALUE));
        Assert.assertEquals(dice.getSides(), new Integer(Integer.MAX_VALUE));
    }

    /**
     * Tests that dice notation with a single dice and a single side can be
     * parsed.
     */
    @Test
    public final void testParse_OnesDice_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = parse("1d1");

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), new Integer(1));
        Assert.assertEquals(dice.getSides(), new Integer(1));
    }

    /**
     * Tests that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = parse("1d6");

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), new Integer(1));
        Assert.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple_UpperCaseSeparator() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = parse("1D6");

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), new Integer(1));
        Assert.assertEquals(dice.getSides(), new Integer(6));
    }

    /**
     * Tests that dice notation with zero dice is parsed.
     */
    @Test
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = parse("0d6");

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), new Integer(0));
        Assert.assertEquals(dice.getSides(), new Integer(6));
    }

}
