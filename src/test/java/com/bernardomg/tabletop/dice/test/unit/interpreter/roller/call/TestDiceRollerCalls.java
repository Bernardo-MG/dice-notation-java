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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.call;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Unit tests for {@link DiceRoller}, verifying that handles dice correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerCalls {

    /**
     * Default constructor.
     */
    public TestDiceRollerCalls() {
        super();
    }

    /**
     * Verifies that a subtraction generates the expected results.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testTransforms_Dice() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Function<RollResult, RollResult> trans;

        // Mocks generator
        trans = Mockito.mock(Function.class);
        Mockito.when(trans.apply(ArgumentMatchers.any()))
                .thenReturn(Mockito.mock(RollResult.class));

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        new DiceRoller(trans).transform(expression);

        Mockito.verify(trans, Mockito.times(1)).apply(ArgumentMatchers.any());
    }

    /**
     * Verifies that a subtraction generates the expected results.
     */
    @SuppressWarnings("unchecked")
    @Test
    public final void testTransforms_Subtraction() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Function<RollResult, RollResult> trans;

        // Mocks generator
        trans = Mockito.mock(Function.class);

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        expression = new SubtractionOperation(left, right);

        new DiceRoller(trans).transform(expression);

        Mockito.verify(trans, Mockito.times(0)).apply(ArgumentMatchers.any());
    }

}
