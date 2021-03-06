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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected total roll for dice")
public final class ITParseAndDiceRollerDiceTotalRoll {

    public ITParseAndDiceRollerDiceTotalRoll() {
        super();
    }

    @Test
    @Disabled
    @DisplayName("The largest possible dice returns the expected value")
    public final void testParse_Dice_Biggest() {
        final DiceNotationExpression parsed; // Parsed expression
        final String notation;               // Input to parse

        // TODO: Test performance

        notation = Integer.MAX_VALUE + "d" + Integer.MAX_VALUE;

        parsed = new DefaultDiceParser().parse(notation);

        new DiceRoller().transform(parsed);
    }

    @Test
    @DisplayName("A negative dice returns the expected value")
    public final void testParse_Dice_Negative_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "-1d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf((-1)), result);
    }

    @Test
    @DisplayName("A dice with no quantity returns the expected value")
    public final void testParse_Dice_NoQuantity_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(1), result);
    }

    @Test
    @DisplayName("A dice with zero sides returns the expected value")
    public final void testParse_Dice_NoSides_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1d0";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(0), result);
    }

    @Test
    @DisplayName("The smallest possible dice returns the expected value")
    public final void testParse_Dice_Smallest_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "1d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(1), result);
    }

    @Test
    @DisplayName("A dice with zero quantity returns the expected value")
    public final void testParse_Dice_ZeroQuantity_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "0d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(0), result);
    }

}
