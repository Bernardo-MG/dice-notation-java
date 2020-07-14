/**
 * Copyright 2014-2020 the original author or authors
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

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.google.common.collect.Iterables;

@DisplayName("DiceRoller returns the expected roll results for dice")
public final class TestDiceRollerDiceRollResult {

    public TestDiceRollerDiceRollResult() {
        super();
    }

    @Test
    @DisplayName("The expected rolls are returned when using a generator")
    public final void testRoll_generator() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;
        final RollResult rolledValues;
        final NumberGenerator generator;
        final Iterator<Integer> rolls;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2));

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression)
                .getRollResults();
        rolledValues = rolled.iterator().next();

        // Single dice
        Assertions.assertEquals(1, Iterables.size(rolled));

        // Two values
        Assertions.assertEquals(2, Iterables.size(rolledValues.getAllRolls()));

        rolls = rolledValues.getAllRolls().iterator();

        Assertions.assertEquals(new Integer(1), rolls.next());
        Assertions.assertEquals(new Integer(2), rolls.next());
    }

    @Test
    @DisplayName("Single side dice generate the expected dice")
    public final void testRoll_SingleSide_Dice() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;
        final Dice diceResult;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        diceResult = result.getDice();
        Assertions.assertEquals(new Integer(3), diceResult.getQuantity());
        Assertions.assertEquals(new Integer(1), diceResult.getSides());
    }

    @Test
    @DisplayName("Single side dice generate the expected total roll")
    public final void testRoll_SingleSide_FinalRoll() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        Assertions.assertEquals(new Integer(3), result.getTotalRoll());
    }

    @Test
    @DisplayName("Single side dice generate the expected total number of rolls")
    public final void testRoll_SingleSide_Quantity() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getRollResults();

        Assertions.assertEquals(1, Iterables.size(rolled));
    }

    @Test
    @DisplayName("Single side dice generate the expected rolls")
    public final void testRoll_SingleSide_Rolls() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> results;
        final RollResult result;
        final Iterable<Integer> rolls;
        final Iterator<Integer> rollValues;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        results = new DiceRoller().transform(expression).getRollResults();
        result = results.iterator().next();
        rolls = result.getAllRolls();

        Assertions.assertEquals(1, Iterables.size(results));
        Assertions.assertEquals(3, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(1), rollValues.next());
        Assertions.assertEquals(new Integer(1), rollValues.next());
        Assertions.assertEquals(new Integer(1), rollValues.next());
    }

    @Test
    @DisplayName("The smallest possible die generate the expected dice")
    public final void testRoll_SmallestDice_Dice() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;
        final Dice diceResult;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        diceResult = result.getDice();
        Assertions.assertEquals(new Integer(1), diceResult.getQuantity());
        Assertions.assertEquals(new Integer(1), diceResult.getSides());
    }

    @Test
    @DisplayName("The smallest possible die generate the expected total roll")
    public final void testRoll_SmallestDice_FinalRoll() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        Assertions.assertEquals(new Integer(1), result.getTotalRoll());
    }

    @Test
    @DisplayName("The smallest possible die generate the expected total number of rolls")
    public final void testRoll_SmallestDice_Quantity() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getRollResults();

        Assertions.assertEquals(1, Iterables.size(rolled));
    }

    @Test
    @DisplayName("The smallest possible die generate the expected rolls")
    public final void testRoll_SmallestDice_Rolls() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> results;
        final RollResult result;
        final Iterable<Integer> rolls;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        results = new DiceRoller().transform(expression).getRollResults();
        result = results.iterator().next();
        rolls = result.getAllRolls();

        Assertions.assertEquals(1, Iterables.size(results));
        Assertions.assertEquals(1, Iterables.size(rolls));
        Assertions.assertEquals(new Integer(1), rolls.iterator().next());
    }

}
