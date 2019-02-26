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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;

/**
 * Unit tests for {@link DiceRoller}, verifying that it returns the expected
 * text results for dice.
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
     * Verifies that an addition generates the expected text result.
     */
    @Test
    public final void testRolls_SingleSide_Text() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollHistory result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("[1, 1, 1]", result.toString());
    }

    /**
     * Verifies that an addition generates the expected text result.
     */
    @Test
    public final void testRolls_SmallestDice_Text() {
        final Dice dice;
        final DiceNotationExpression expression;
        final RollHistory result;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1", result.toString());
    }

}
