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

package com.bernardomg.tabletop.dice.test.unit.notation.operand;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.test.argument.NotationAndValuesArgumentsProvider;

@DisplayName("Tests for DefaultDiceOperand")
public class TestDefaultDiceOperand {

    public TestDefaultDiceOperand() {
        super();
    }

    @ParameterizedTest(name = "{1} dice with {2} sides = {0}")
    @ArgumentsSource(NotationAndValuesArgumentsProvider.class)
    @DisplayName("The text expression is generated correctly")
    public final void testTextExpression(final String notation, final Integer quantity, final Integer sides) {
        final DiceNotationExpression diceOperand; // Tested operand
        final Dice                   dice;        // Dice for the operand

        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity())
            .thenReturn(quantity);
        Mockito.when(dice.getSides())
            .thenReturn(sides);

        diceOperand = new DefaultDiceOperand(dice);

        Assertions.assertThat(diceOperand.getExpression())
            .isEqualTo(notation);
    }

}
