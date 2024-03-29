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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("DiceRoller returns the expected text for addition/subtraction")
public final class TestDiceRollerAdditionOperationRollText {

    public TestDiceRollerAdditionOperationRollText() {
        super();
    }

    @Test
    @DisplayName("An addition returns the expected text")
    public final void testText_Addition() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final RollHistory            result;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 + 2
        expression = new AdditionOperation(left, right);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("1 + 2");
    }

    @Test
    @DisplayName("An addition (left value negative) returns the expected text")
    public final void testText_Addition_AddToNeg() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final RollHistory            result;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 + 2
        expression = new AdditionOperation(left, right);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("-1 + 2");
    }

    @Test
    @DisplayName("A subtraction returns the expected text")
    public final void testText_Subtraction() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final RollHistory            result;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        expression = new SubtractionOperation(left, right);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("1 - 2");
    }

}
