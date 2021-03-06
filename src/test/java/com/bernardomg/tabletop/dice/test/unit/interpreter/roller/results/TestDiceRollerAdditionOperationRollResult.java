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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.results;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.google.common.collect.Iterables;

@DisplayName("DiceRoller returns the expected roll results for additions/subtractions")
public final class TestDiceRollerAdditionOperationRollResult {

    public TestDiceRollerAdditionOperationRollResult() {
        super();
    }

    @Test
    @DisplayName("An addition generates the expected results")
    public final void testRolls_Addition() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Iterable<RollResult> results;
        final Iterator<RollResult> resultsItr;
        RollResult result;
        Iterable<Integer> rolls;
        Iterator<Integer> rollValues;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 + 2
        expression = new AdditionOperation(left, right);

        results = new DiceRoller().transform(expression).getRollResults();
        resultsItr = results.iterator();

        Assertions.assertEquals(2, Iterables.size(results));

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(1), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(2), rollValues.next());
    }

    @Test
    @DisplayName("An addition (left value negative) generates the expected results")
    public final void testRolls_Addition_AddToNeg() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Iterable<RollResult> results;
        final Iterator<RollResult> resultsItr;
        RollResult result;
        Iterable<Integer> rolls;
        Iterator<Integer> rollValues;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 + 2
        expression = new AdditionOperation(left, right);

        results = new DiceRoller().transform(expression).getRollResults();
        resultsItr = results.iterator();

        Assertions.assertEquals(2, Iterables.size(results));

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(-1), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(2), rollValues.next());
    }

    @Test
    @DisplayName("A subtraction generates the expected results")
    public final void testRolls_Subtraction() {
        final DiceNotationExpression expression;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Iterable<RollResult> results;
        final Iterator<RollResult> resultsItr;
        RollResult result;
        Iterable<Integer> rolls;
        Iterator<Integer> rollValues;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        expression = new SubtractionOperation(left, right);

        results = new DiceRoller().transform(expression).getRollResults();
        resultsItr = results.iterator();

        Assertions.assertEquals(2, Iterables.size(results));

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(1), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(Integer.valueOf(-2), rollValues.next());
    }

}
