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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;

/**
 * Unit tests for {@link DiceRoller}, verifying that handles dice correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerDiceValue {

    /**
     * Default constructor.
     */
    public TestDiceRollerDiceValue() {
        super();
    }

    /**
     * Verifies that a negative quantity is handled correctly.
     */
    @Test
    public final void testTransform_NegativeQuantity() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(-1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getTotalRoll();

        Assertions.assertEquals(new Integer(-1), rolled);
    }

    /**
     * Verifies that negative sides are handled correctly.
     */
    @Test
    public final void testTransform_NegativeSides() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(-1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getTotalRoll();

        Assertions.assertEquals(new Integer(0), rolled);
    }

    /**
     * Verifies that a zero quantity is handled correctly.
     */
    @Test
    public final void testTransform_NoQuantity() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(0);
        Mockito.when(dice.getSides()).thenReturn(6);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getTotalRoll();

        Assertions.assertEquals(new Integer(0), rolled);
    }

    /**
     * Verifies that zero sides are handled correctly.
     */
    @Test
    public final void testTransform_NoSides() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(0);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getTotalRoll();

        Assertions.assertEquals(new Integer(0), rolled);
    }

    /**
     * Verifies that the smallest dice is handled correctly.
     */
    @Test
    public final void testTransform_Smallest() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller().transform(expression).getTotalRoll();

        Assertions.assertEquals(new Integer(1), rolled);
    }

}
