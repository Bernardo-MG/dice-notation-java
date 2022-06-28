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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected total roll for mixed operations")
public final class ITParseAndDiceRollerBinaryOperationTotalRoll {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerBinaryOperationTotalRoll() {
        super();
    }

    @Test
    @DisplayName("A long addition returns the expected value")
    public final void testParse_LongAddition_NoQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer                result; // Resulting value

        parsed = new DefaultDiceParser().parse("1d1+3+d1+12d1+d1");

        result = new DiceRoller().transform(parsed)
            .getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(18), result);
    }

    @Test
    @DisplayName("A long arithmetic operation returns the expected value")
    public final void testParse_LongArithmetic() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer                result; // Resulting value

        parsed = new DefaultDiceParser().parse("1d1+3*4/2");

        result = new DiceRoller().transform(parsed)
            .getTotalRoll();

        Assertions.assertEquals(Integer.valueOf(7), result);
    }

}
