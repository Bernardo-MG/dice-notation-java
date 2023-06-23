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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.NotationAndTextRollHistoryArgumentsProvider;

@DisplayName("DiceRoller returns the expected history text representation")
public final class ITParseAndDiceRollerText {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerText() {
        super();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @ArgumentsSource(NotationAndTextRollHistoryArgumentsProvider.class)
    @DisplayName("The notation parses into the expected roll history")
    public final void testParse_Add_Dice_Value(final String notation, final String history) {
        final DiceNotationExpression expression;
        final RollHistory            result;

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString(history);
    }

}
