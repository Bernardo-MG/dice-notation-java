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

package com.bernardomg.tabletop.dice.test.integration.transformer.roll.results;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;
import com.google.common.collect.Iterables;

/**
 * Integration tests for {@link DiceRoller}, verifying that it returns the
 * expected roll results for addition operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerMultiplicationDiceRollResults {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerMultiplicationDiceRollResults() {
        super();
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_DiceAddition_Dice() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;

        notation = "1d1*2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();

        Assertions.assertEquals(new Integer(1), result.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), result.getDice().getSides());

        result = rolled.next();

        Assertions.assertEquals(new Integer(2), result.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), result.getDice().getSides());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_DiceAddition_FinalRoll() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;

        notation = "1d1*2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();

        Assertions.assertEquals(new Integer(1), result.getFinalRoll());

        result = rolled.next();

        Assertions.assertEquals(new Integer(2), result.getFinalRoll());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_DiceAddition_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;
        final String notation;

        notation = "1d1*2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults();

        Assertions.assertEquals(2, Iterables.size(rolled));
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_DiceAddition_Rolls() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;
        Iterator<Integer> rolls;

        notation = "1d1*2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();
        rolls = result.getAllRolls().iterator();

        Assertions.assertEquals(1, Iterables.size(result.getAllRolls()));
        Assertions.assertEquals(new Integer(1), rolls.next());

        result = rolled.next();
        rolls = result.getAllRolls().iterator();

        Assertions.assertEquals(2, Iterables.size(result.getAllRolls()));
        Assertions.assertEquals(new Integer(1), rolls.next());
        Assertions.assertEquals(new Integer(1), rolls.next());
    }

}
