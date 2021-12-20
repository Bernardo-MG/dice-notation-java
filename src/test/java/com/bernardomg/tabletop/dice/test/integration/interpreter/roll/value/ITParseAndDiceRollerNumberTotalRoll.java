/**
 * Copyright 2014-2021 the original author or authors
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

@DisplayName("DiceRoller returns the expected total roll for constants")
public final class ITParseAndDiceRollerNumberTotalRoll {

    public ITParseAndDiceRollerNumberTotalRoll() {
        super();
    }

    @Test
    @DisplayName("A constant returns the expected value")
    public final void testParse_Number() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "12";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(12), result);
    }

    @Test
    @DisplayName("A negative returns the expected value")
    public final void testParse_Number_Negative() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "-12";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(-12), result);
    }

    @Test
    @DisplayName("A constant padded by zeros returns the expected value")
    public final void testParse_Number_ZeroPadding() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "001200";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(1200), result);
    }

}
