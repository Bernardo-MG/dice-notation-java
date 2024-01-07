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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.call;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceRoller calls its dependencies")
public final class TestDiceRollerCalls {

    @Mock
    private Dice                       dice;

    @Mock
    private Function<Dice, RollResult> roller;

    @Mock
    private RollResult                 rollResult;

    public TestDiceRollerCalls() {
        super();
    }

    @Test
    @DisplayName("The roller function is called when parsing dice")
    public final void testCallsFunction_Dice() {
        final DiceNotationExpression expression;

        // Mocks generator
        when(roller.apply(dice)).thenReturn(rollResult);

        expression = new DefaultDiceOperand(dice);

        new DiceRoller(roller).transform(expression);

        verify(roller, times(1)).apply(dice);
    }

    @Test
    @DisplayName("The roller function is not called when parsing a subtraction")
    public final void testCallsFunction_Subtraction_NotCalled() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;

        // 1 - 2
        left = new IntegerOperand(1);
        right = new IntegerOperand(2);
        expression = new SubtractionOperation(left, right);

        new DiceRoller(roller).transform(expression);

        verify(roller, never()).apply(any());
    }

}
