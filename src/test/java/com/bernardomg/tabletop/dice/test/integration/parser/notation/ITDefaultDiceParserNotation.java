/**
 * Copyright 2014-2023 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser.notation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.NotationArgumentsProvider;

@DisplayName("DefaultDiceParser returns back the parsed expression")
public final class ITDefaultDiceParserNotation {

    public ITDefaultDiceParserNotation() {
        super();
    }

    @Test
    @DisplayName("A dice expression with a big d returns the expression")
    public final void testParse_Dice_BigD() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1D6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertThat(operation.getExpression())
            .isEqualTo("1d6");
    }

    @Test
    @DisplayName("A dice expression with no quantity returns the expression")
    public final void testParse_NoQuantity() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertThat(operation.getExpression())
            .isEqualTo("1d6");
    }

    @ParameterizedTest(name = "{0}")
    @ArgumentsSource(NotationArgumentsProvider.class)
    @DisplayName("Can recover the parsed notation")
    public final void testParse_ReturnsNotation(final String notation) {
        final DiceNotationExpression operation; // Parsed operation

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertThat(operation.getExpression())
            .isEqualTo(notation);
    }

}
