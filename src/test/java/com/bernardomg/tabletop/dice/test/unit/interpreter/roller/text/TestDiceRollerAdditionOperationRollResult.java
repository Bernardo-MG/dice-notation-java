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

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;

/**
 * Unit tests for {@link DiceRoller}, verifying that it returns the expected
 * roll results for addition operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerAdditionOperationRollResult {

    /**
     * Default constructor.
     */
    public TestDiceRollerAdditionOperationRollResult() {
        super();
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_Text() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final RollHistory result;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 + 2
        expression = new AdditionOperation(left, right);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + 2", result.toString());
    }

}
