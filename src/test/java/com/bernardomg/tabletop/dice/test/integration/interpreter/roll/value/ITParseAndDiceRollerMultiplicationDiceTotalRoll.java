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

@DisplayName("DiceRoller returns the expected total roll for multiplications")
public final class ITParseAndDiceRollerMultiplicationDiceTotalRoll {

    public ITParseAndDiceRollerMultiplicationDiceTotalRoll() {
        super();
    }

    @Test
    @DisplayName("A multiplication returns the expected value")
    public final void testParse_Multiply_Dice_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "3d1*2d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(6), result);
    }

    @Test
    @DisplayName("Multiplying a number by a dice returns the expected value")
    public final void testParse_Multiply_LeftNumber_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "5*2d1";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(10), result);
    }

    @Test
    @DisplayName("Multiplying a dice by a number returns the expected value")
    public final void testParse_Multiply_RightNumber_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "2d1*5";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(10), result);
    }

}
