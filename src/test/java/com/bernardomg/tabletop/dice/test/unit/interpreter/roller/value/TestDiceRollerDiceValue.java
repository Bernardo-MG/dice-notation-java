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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.value;

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
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceRoller handles dice operations")
public final class TestDiceRollerDiceValue {

    @Mock
    private Dice            dice;

    @Mock
    private NumberGenerator generator;

    /**
     * Default constructor.
     */
    public TestDiceRollerDiceValue() {
        super();
    }

    @Test
    @DisplayName("The expected value is returned when using a generator and multiple values")
    public final void testTotalRoll_CustomGenerator_MultipleValues() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks generator
        when(generator.generate((Dice) ArgumentMatchers.any())).thenReturn(Arrays.asList(1, 2, 3));

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("The expected value is returned when using a generator")
    public final void testTotalRoll_Generator() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks generator
        when(generator.generate((Dice) ArgumentMatchers.any())).thenReturn(Arrays.asList(5));

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("A dice with negative quantity returns the expected result")
    public final void testTotalRoll_NegativeQuantity() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(-1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("A dice with negative sides returns the expected result")
    public final void testTotalRoll_NegativeSides() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(-1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isZero();
    }

    @Test
    @DisplayName("A dice with no quantity returns the expected result")
    public final void testTotalRoll_NoQuantity() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isZero();
    }

    @Test
    @DisplayName("A dice with no sides returns the expected result")
    public final void testTotalRoll_NoSides() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(0);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isZero();
    }

    @Test
    @DisplayName("The smallest possible dice returns the expected result")
    public final void testTotalRoll_Smallest() {
        final DiceNotationExpression expression;
        final Integer                rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(1);
    }

}
