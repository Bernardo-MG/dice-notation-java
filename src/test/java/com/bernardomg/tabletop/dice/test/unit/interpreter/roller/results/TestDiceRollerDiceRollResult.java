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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.results;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceRoller returns the expected roll results for dice")
public final class TestDiceRollerDiceRollResult {

    @Mock
    private Dice            dice;

    @Mock
    private NumberGenerator generator;

    @Mock
    private RollResult      rollResult;

    public TestDiceRollerDiceRollResult() {
        super();
    }

    @Test
    @DisplayName("The expected rolls are returned when using a generator")
    public final void testRoll_generator() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   rolled;
        final RollResult             rolledValues;
        final Iterator<Integer>      rolls;

        // Mocks generator
        when(generator.generate((Dice) ArgumentMatchers.any())).thenReturn(Arrays.asList(1, 2));

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression)
            .getRollResults();
        rolledValues = rolled.iterator()
            .next();

        // Single dice
        Assertions.assertThat(StreamSupport.stream(rolled.spliterator(), false)
            .count())
            .isEqualTo(1);

        // Two values
        Assertions.assertThat(StreamSupport.stream(rolledValues.getAllRolls()
            .spliterator(), false)
            .count())
            .isEqualTo(2);

        rolls = rolledValues.getAllRolls()
            .iterator();

        Assertions.assertThat(rolls.next())
            .isEqualTo(1);
        Assertions.assertThat(rolls.next())
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Single side dice generate the expected dice")
    public final void testRoll_SingleSide_Dice() {
        final DiceNotationExpression expression;
        final RollResult             result;
        final Dice                   diceResult;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(3);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        diceResult = result.getDice();
        Assertions.assertThat(diceResult.getQuantity())
            .isEqualTo(3);
        Assertions.assertThat(diceResult.getSides())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Single side dice generate the expected total roll")
    public final void testRoll_SingleSide_FinalRoll() {
        final DiceNotationExpression expression;
        final RollResult             result;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(3);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        Assertions.assertThat(result.getTotalRoll())
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Single side dice generate the expected total number of rolls")
    public final void testRoll_SingleSide_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(3);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getRollResults();

        Assertions.assertThat(StreamSupport.stream(rolled.spliterator(), false)
            .count())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Single side dice generate the expected rolls")
    public final void testRoll_SingleSide_Rolls() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Iterable<Integer>      rolls;
        final Iterator<Integer>      rollValues;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(3);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();
        rolls = result.getAllRolls();

        Assertions.assertThat(StreamSupport.stream(results.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(StreamSupport.stream(rolls.spliterator(), false)
            .count())
            .isEqualTo(3);

        rollValues = rolls.iterator();
        Assertions.assertThat(rollValues.next())
            .isEqualTo(1);
        Assertions.assertThat(rollValues.next())
            .isEqualTo(1);
        Assertions.assertThat(rollValues.next())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("The smallest possible die generate the expected dice")
    public final void testRoll_SmallestDice_Dice() {
        final DiceNotationExpression expression;
        final RollResult             result;
        final Dice                   diceResult;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        diceResult = result.getDice();
        Assertions.assertThat(diceResult.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(diceResult.getSides())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("The smallest possible die generate the expected total roll")
    public final void testRoll_SmallestDice_FinalRoll() {
        final DiceNotationExpression expression;
        final RollResult             result;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        Assertions.assertThat(result.getTotalRoll())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("The smallest possible die generate the expected total number of rolls")
    public final void testRoll_SmallestDice_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   rolled;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression)
            .getRollResults();

        Assertions.assertThat(StreamSupport.stream(rolled.spliterator(), false)
            .count())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("The smallest possible die generate the expected rolls")
    public final void testRoll_SmallestDice_Rolls() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Iterable<Integer>      rolls;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();
        rolls = result.getAllRolls();

        Assertions.assertThat(StreamSupport.stream(results.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(StreamSupport.stream(rolls.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(rolls.iterator()
            .next())
            .isEqualTo(1);
    }

}
