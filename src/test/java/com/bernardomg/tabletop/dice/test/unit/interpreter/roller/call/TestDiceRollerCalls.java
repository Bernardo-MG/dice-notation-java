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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.call;

import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("DiceRoller calls its dependencies")
public final class TestDiceRollerCalls {

    public TestDiceRollerCalls() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("The roller function is called when parsing dice")
    public final void testCallsFunction_Dice() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Function<Dice, RollResult> roller;

        // Mocks generator
        roller = Mockito.mock(Function.class);
        Mockito.when(roller.apply(ArgumentMatchers.any()))
                .thenReturn(Mockito.mock(RollResult.class));

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        expression = new DefaultDiceOperand(dice);

        new DiceRoller(roller).transform(expression);

        Mockito.verify(roller, Mockito.times(1)).apply(ArgumentMatchers.any());
    }

    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("The roller function is not called when parsing a subtraction")
    public final void testCallsFunction_Subtraction_NotCalled() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Function<Dice, RollResult> roller;

        // Mocks generator
        roller = Mockito.mock(Function.class);

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        expression = new SubtractionOperation(left, right);

        new DiceRoller(roller).transform(expression);

        Mockito.verify(roller, Mockito.times(0)).apply(ArgumentMatchers.any());
    }

}
