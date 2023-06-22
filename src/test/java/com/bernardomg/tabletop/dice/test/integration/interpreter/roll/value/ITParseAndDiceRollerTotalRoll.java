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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.RollAndResultArgumentsProvider;

@DisplayName("DiceRoller returns the expected total roll")
public final class ITParseAndDiceRollerTotalRoll {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerTotalRoll() {
        super();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @ArgumentsSource(RollAndResultArgumentsProvider.class)
    @DisplayName("The notation parses into the expected value")
    public final void testParse_Add_Dice_Value(final String notation, final Number expected) {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer                result; // Resulting value

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed)
            .getTotalRoll();

        Assertions.assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @Disabled
    @DisplayName("An inexact division returns a float value")
    public final void testParse_Division_FloatValue() {
        final DiceNotationExpression parsed;   // Parsed expression
        final Integer                result;   // Resulting value
        final String                 notation; // Input to parse

        notation = "3/2";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed)
            .getTotalRoll();

        Assertions.assertThat(result)
            .isEqualTo(1.5);
    }

}
