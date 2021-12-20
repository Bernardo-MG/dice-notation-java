/**
 * Copyright 2014-2021 the original author or authors
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
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected roll results for addition operations including constants")
public final class ITParseAndDiceRollerAdditionMixedRollResults {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerAdditionMixedRollResults() {
        super();
    }

    @Test
    @DisplayName("Returns the expected dice")
    public final void testParse_Dice() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;
        Dice dice;

        notation = "1d1+3+2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();

        dice = result.getDice();
        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(1), dice.getSides());

        result = rolled.next();

        dice = result.getDice();
        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(3), dice.getSides());

        result = rolled.next();

        dice = result.getDice();
        Assertions.assertEquals(Integer.valueOf(2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(1), dice.getSides());
    }

    @Test
    @DisplayName("Returns the expected number of results")
    public final void testParse_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;
        final String notation;

        notation = "1d1+3+2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults();

        Assertions.assertEquals(3,
                StreamSupport.stream(rolled.spliterator(), false).count());
    }

    @Test
    @DisplayName("Returns the expected rolls")
    public final void testParse_Rolls() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;
        Iterator<Integer> rolls;

        notation = "1d1+3+2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();
        rolls = result.getAllRolls().iterator();

        Assertions.assertEquals(1, StreamSupport
                .stream(result.getAllRolls().spliterator(), false).count());
        Assertions.assertEquals(Integer.valueOf(1), rolls.next());

        result = rolled.next();
        rolls = result.getAllRolls().iterator();

        Assertions.assertEquals(1, StreamSupport
                .stream(result.getAllRolls().spliterator(), false).count());
        Assertions.assertEquals(Integer.valueOf(3), rolls.next());

        result = rolled.next();
        rolls = result.getAllRolls().iterator();

        Assertions.assertEquals(2, StreamSupport
                .stream(result.getAllRolls().spliterator(), false).count());
        Assertions.assertEquals(Integer.valueOf(1), rolls.next());
        Assertions.assertEquals(Integer.valueOf(1), rolls.next());
    }

    @Test
    @DisplayName("Returns the expected total roll")
    public final void testParse_TotalRoll() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory history;

        notation = "1d1+3+2d1";

        expression = new DefaultDiceParser().parse(notation);

        history = new DiceRoller().transform(expression);

        Assertions.assertEquals(Integer.valueOf(6), history.getTotalRoll());
    }

    @Test
    @DisplayName("Returns the expected total rolls")
    public final void testParse_TotalRolls() {
        final DiceNotationExpression expression;
        final Iterator<RollResult> rolled;
        final String notation;
        RollResult result;

        notation = "1d1+3+2d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression).getRollResults()
                .iterator();

        result = rolled.next();

        Assertions.assertEquals(Integer.valueOf(1), result.getTotalRoll());

        result = rolled.next();

        Assertions.assertEquals(Integer.valueOf(3), result.getTotalRoll());

        result = rolled.next();

        Assertions.assertEquals(Integer.valueOf(2), result.getTotalRoll());
    }

}
