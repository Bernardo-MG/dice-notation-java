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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link DiceRoller}, verifying that it returns the expected
 * roll results for constants.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerConstantRollResult {

    /**
     * Default constructor.
     */
    public TestDiceRollerConstantRollResult() {
        super();
    }

    /**
     * Verifies that the constants don't generate roll results.
     */
    @Test
    public final void testRollResults() {
        final DiceNotationExpression operation;
        final Iterable<RollResult> rolled;

        operation = new IntegerOperand(1);

        rolled = new DiceRoller().transform(operation).getRollResults();

        Assertions.assertEquals(0, Iterables.size(rolled));
    }

}
