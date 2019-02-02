/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.transformer.roller.results;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link DiceRoller}, verifying that it returns the expected
 * roll results for dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerDiceRollResult {

    /**
     * Default constructor.
     */
    public TestDiceRollerDiceRollResult() {
        super();
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SingleSide_Dice() {
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

        Assertions.assertEquals(new Integer(3), result.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), result.getDice().getSides());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
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

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
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

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SingleSide_Rolls() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;
        final Iterable<Integer> rolls;
        final Iterator<Integer> rollValues;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();
        rolls = result.getAllRolls();

        Assertions.assertEquals(3, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(1), rollValues.next());
        Assertions.assertEquals(new Integer(1), rollValues.next());
        Assertions.assertEquals(new Integer(1), rollValues.next());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_Dice() {
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

        Assertions.assertEquals(new Integer(1), result.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), result.getDice().getSides());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
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

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
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

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_Rolls() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollResult result;
        final Iterable<Integer> rolls;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();
        rolls = result.getAllRolls();

        Assertions.assertEquals(1, Iterables.size(rolls));
        Assertions.assertEquals(new Integer(1), rolls.iterator().next());
    }

}
