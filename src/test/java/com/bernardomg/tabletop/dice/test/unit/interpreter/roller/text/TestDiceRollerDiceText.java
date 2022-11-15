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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.text;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@DisplayName("DiceRoller returns the expected text for dice")
public final class TestDiceRollerDiceText {

    public TestDiceRollerDiceText() {
        super();
    }

    @Test
    @DisplayName("Returns the expected text when using a custom generator")
    public final void testText_CustomGenerator() {
        final Dice                   dice;
        final DiceNotationExpression expression;
        final NumberGenerator        generator;
        final RollHistory            result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity())
            .thenReturn(1);
        Mockito.when(dice.getSides())
            .thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
            .thenReturn(Arrays.asList(5));

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller(generator).transform(expression);

        Assertions.assertEquals("5", result.toString());
    }

    @Test
    @DisplayName("Returns the expected text when using a custom generator and multiple values")
    public final void testText_CustomGenerator_MultipleValues() {
        final Dice                   dice;
        final DiceNotationExpression expression;
        final NumberGenerator        generator;
        final RollHistory            result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity())
            .thenReturn(3);
        Mockito.when(dice.getSides())
            .thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
            .thenReturn(Arrays.asList(5, 7, 2));

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller(generator).transform(expression);

        Assertions.assertEquals("[5, 7, 2]", result.toString());
    }

    @Test
    @DisplayName("A single side dice returns the expected text")
    public final void testText_SingleSide_Text() {
        final Dice                   dice;
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity())
            .thenReturn(3);
        Mockito.when(dice.getSides())
            .thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("[1, 1, 1]", result.toString());
    }

    @Test
    @DisplayName("The smallest possible die returns the expected text")
    public final void testText_SmallestDice_Text() {
        final Dice                   dice;
        final DiceNotationExpression expression;
        final RollHistory            result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity())
            .thenReturn(1);
        Mockito.when(dice.getSides())
            .thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1", result.toString());
    }

}
