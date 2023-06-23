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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;

@DisplayName("DiceRoller returns the expected text for constants")
public final class TestDiceRollerConstantText {

    public TestDiceRollerConstantText() {
        super();
    }

    @Test
    @DisplayName("A negative value returns the expected text")
    public final void testText_Negative_Text() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        expression = new IntegerOperand(-1);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("-1");
    }

    @Test
    @DisplayName("A positive value returns the expected text")
    public final void testText_Positive_Text() {
        final DiceNotationExpression expression;
        final RollHistory            result;

        expression = new IntegerOperand(1);

        result = new DiceRoller().transform(expression);

        Assertions.assertThat(result)
            .hasToString("1");
    }

}
