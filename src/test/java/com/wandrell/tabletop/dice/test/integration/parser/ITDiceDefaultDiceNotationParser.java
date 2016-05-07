/**
 * Copyright 2014-2016 the original author or authors
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

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operand.DiceOperand;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.test.util.config.factory.DiceParametersFactory;

/**
 * Integration tests for {@code DefaultDiceNotationParser}, checking that it
 * parses dice notation expressions for single dice groups.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Single dice expressions are parsed correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITDiceDefaultDiceNotationParser {

    /**
     * Marker for the single dice parameters.
     */
    protected static final String SINGLE_DICE = "single_dice";

    /**
     * Simple dice expressions parameters.
     * <p>
     * These are sets of a dice notation expression containing just a dice, and
     * the expected quantity and number of sides.
     * 
     * @return a dice expression, along the expected quantity and number of
     *         sides
     * @throws Exception
     *             if any error occurs while preparing the parameters
     */
    @DataProvider(name = SINGLE_DICE)
    public final static Iterator<Object[]> getSingleDiceParameters()
            throws Exception {
        return DiceParametersFactory.getDiceAndText();
    }

    /**
     * Default constructor.
     */
    public ITDiceDefaultDiceNotationParser() {
        super();
    }

    /**
     * Tests that single dice expressions are parsed correctly.
     * 
     * @param expression
     *            expression to parse
     * @param quantity
     *            expected quantity
     * @param sides
     *            expected number of sides
     */
    @Test(dataProvider = SINGLE_DICE)
    public final void testParse_Dice_Valid(final String expression,
            final Integer quantity, final Integer sides) {
        final DiceNotationParser parser; // Tested parser
        final DiceNotationExpression parsed;     // Parsed expression
        final Dice dice;                 // Resulting dice

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        parsed = parser.parse(expression);

        dice = ((DiceOperand) parsed).getDice();

        Assert.assertEquals(dice.getQuantity(), quantity);
        Assert.assertEquals(dice.getSides(), sides);
    }

}
