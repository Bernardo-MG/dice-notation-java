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

package com.bernardomg.tabletop.dice.test.unit.history;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.history.DefaultRollHistory;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;

/**
 * Unit tests for {@link DiceRoller}, verifying that handles dice correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRoller {

    /**
     * Default constructor.
     */
    public TestDiceRoller() {
        super();
    }

    /**
     * Verifies that the roller returns the values generated by its number
     * generator.
     */
    @Test
    public final void testText_NoResults() {
        final RollHistory history;
        final Collection<RollResult> results;

        results = new ArrayList<>();

        history = new DefaultRollHistory(results, 0);

        Assertions.assertEquals("", history.getHistoryText());
    }

    /**
     * Verifies that the roller returns the values generated by its number
     * generator.
     */
    @Test
    public final void testText_NoRolls() {
        final RollHistory history;
        final Collection<RollResult> results;
        final RollResult result;
        final DiceNotationExpression exp;

        exp = new IntegerOperand(0);

        result = new DefaultRollResult(exp, Collections.emptyList(), 0);

        results = new ArrayList<>();
        results.add(result);

        history = new DefaultRollHistory(results, 0);

        Assertions.assertEquals("", history.getHistoryText());
    }

}
