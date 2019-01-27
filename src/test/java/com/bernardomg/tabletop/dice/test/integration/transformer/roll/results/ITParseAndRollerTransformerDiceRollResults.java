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
 * Integration tests for {@link DiceRoller}, verifying that it transforms dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerDiceRollResults {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerDiceRollResults() {
        super();
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_Dice() {
        final DiceNotationExpression expression;
        final RollResult result;
        final String notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        Assertions.assertEquals(new Integer(1), result.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), result.getDice().getSides());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_FinalRoll() {
        final DiceNotationExpression expression;
        final RollResult result;
        final String notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();

        Assertions.assertEquals(new Integer(1), result.getFinalRoll());
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;
        final String notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults();

        Assertions.assertEquals(1, Iterables.size(rolled));
    }

    /**
     * Verifies that the smallest possible dice generates the expected results.
     */
    @Test
    public final void testRoll_SmallestDice_Rolls() {
        final DiceNotationExpression expression;
        final RollResult result;
        final Iterable<Integer> rolls;
        final String notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression).getRollResults()
                .iterator().next();
        rolls = result.getAllRolls();

        Assertions.assertEquals(1, Iterables.size(rolls));
        Assertions.assertEquals(new Integer(1), rolls.iterator().next());
    }

}
