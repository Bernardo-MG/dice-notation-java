/**
 * Copyright 2014-2022 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for dice")
public final class ITDefaultDiceParserDiceStructure {

    public ITDefaultDiceParserDiceStructure() {
        super();
    }

    @Test
    @DisplayName("A dice with the max values returns the expected structure")
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE);

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(Integer.MAX_VALUE), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(Integer.MAX_VALUE), dice.getSides());
    }

    @Test
    @DisplayName("A negative dice returns the expected structure")
    public final void testParse_Negative() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("-1d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf((-1)), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("The smallest dice returns the expected structure")
    public final void testParse_OnesDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d1");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(1), dice.getSides());
    }

    @Test
    @DisplayName("A dice returns the expected structure")
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("A dice with the upper case D returns the expected structure")
    public final void testParse_Simple_BigD() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1D6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("A dice with no quantity returns the expected structure")
    public final void testParse_Simple_NoQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("A dice zero quantity returns the expected structure")
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("0d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(0), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("A dice zero sides returns the expected structure")
    public final void testParse_ZeroSides() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d0");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(0), dice.getSides());
    }

}
