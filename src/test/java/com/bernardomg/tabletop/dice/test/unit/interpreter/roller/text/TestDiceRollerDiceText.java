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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.text;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceRoller returns the expected text for dice")
public final class TestDiceRollerDiceText {

    @Mock
    private Dice            dice;

    @Mock
    private NumberGenerator generator;

    public TestDiceRollerDiceText() {
        super();
    }

    @Test
    @DisplayName("Returns the expected text when using a custom generator")
    public final void testText_CustomGenerator() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks generator
        when(generator.generate((Dice) ArgumentMatchers.any())).thenReturn(Arrays.asList(5));

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller(generator).transform(expression);

        Assertions.assertThat(result)
            .hasToString("5");
    }

    @Test
    @DisplayName("Returns the expected text when using a custom generator and multiple values")
    public final void testText_CustomGenerator_MultipleValues() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks generator
        when(generator.generate((Dice) ArgumentMatchers.any())).thenReturn(Arrays.asList(5, 7, 2));

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller(generator).transform(expression);

        Assertions.assertThat(result)
            .hasToString("[5, 7, 2]");
    }

    @Test
    @DisplayName("A single side dice returns the expected text")
    public final void testText_SingleSide_Text() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(3);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("[1, 1, 1]");
    }

    @Test
    @DisplayName("The smallest possible die returns the expected text")
    public final void testText_SmallestDice_Text() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("1");
    }

}
