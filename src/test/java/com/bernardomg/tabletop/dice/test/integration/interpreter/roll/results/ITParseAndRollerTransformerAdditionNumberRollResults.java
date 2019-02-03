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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.results;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link DiceRoller}, verifying that it returns the
 * expected roll results for addition operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerAdditionNumberRollResults {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerAdditionNumberRollResults() {
        super();
    }

    /**
     * Verifies that long additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Long_Value() {
        final DiceNotationExpression operation;
        final String notation;
        final Iterable<RollResult> results;
        final Iterator<RollResult> resultsItr;
        RollResult result;
        Iterable<Integer> rolls;
        Iterator<Integer> rollValues;

        notation = "1+2+3";

        operation = new DefaultDiceParser().parse(notation);

        results = new DiceRoller().transform(operation).getRollResults();
        resultsItr = results.iterator();

        Assertions.assertEquals(3, Iterables.size(results));

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(1), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(2), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(3), rollValues.next());
    }

    /**
     * Verifies that a mix of subtraction and addition can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_SubAndAdd() {
        final DiceNotationExpression operation;
        final String notation;
        final Iterable<RollResult> results;
        final Iterator<RollResult> resultsItr;
        RollResult result;
        Iterable<Integer> rolls;
        Iterator<Integer> rollValues;

        notation = "1-2+3";

        operation = new DefaultDiceParser().parse(notation);

        results = new DiceRoller().transform(operation).getRollResults();
        resultsItr = results.iterator();

        Assertions.assertEquals(3, Iterables.size(results));

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(1), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(-2), rollValues.next());

        result = resultsItr.next();
        rolls = result.getAllRolls();
        Assertions.assertEquals(1, Iterables.size(rolls));

        rollValues = rolls.iterator();
        Assertions.assertEquals(new Integer(3), rollValues.next());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testParse_Number_SubAndAdd_TotalRoll() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory history;

        notation = "1-2+3";

        expression = new DefaultDiceParser().parse(notation);

        history = new DiceRoller().transform(expression);

        Assertions.assertEquals(new Integer(2), history.getTotalRoll());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testParse_Number_SubAndAdd_TotalRolls() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;

        notation = "1-2+3";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();

        Assertions.assertEquals(new Integer(1), result.getTotalRoll());

        result = rolled.next();

        Assertions.assertEquals(new Integer(-2), result.getTotalRoll());

        result = rolled.next();

        Assertions.assertEquals(new Integer(3), result.getTotalRoll());
    }

}
