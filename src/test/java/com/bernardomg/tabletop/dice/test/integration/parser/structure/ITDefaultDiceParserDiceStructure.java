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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.NotationQuantityAndSidesArgumentsProvider;

@DisplayName("DefaultDiceParser parses the expected structure for dice")
public final class ITDefaultDiceParserDiceStructure {

    public ITDefaultDiceParserDiceStructure() {
        super();
    }

    @ParameterizedTest(name = "{0} = {1} dice with {2} sides")
    @ArgumentsSource(NotationQuantityAndSidesArgumentsProvider.class)
    @DisplayName("A parsed dice returns the expected structure")
    public final void testParse_Max(final String notation, final Integer quantity, final Integer sides) {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse(notation);

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(quantity);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(sides);
    }

    @Test
    @DisplayName("A dice with the upper case D returns the expected structure")
    public final void testParse_Simple_BigD() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1D6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("A dice with no quantity returns the expected structure")
    public final void testParse_Simple_NoQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("d6");

        dice = ((DiceOperand) parsed).getDice();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);
    }

}
