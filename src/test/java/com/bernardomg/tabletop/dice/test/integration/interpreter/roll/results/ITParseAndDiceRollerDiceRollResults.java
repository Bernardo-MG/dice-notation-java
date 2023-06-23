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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.results;

import java.util.stream.StreamSupport;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected roll results for dice")
public final class ITParseAndDiceRollerDiceRollResults {

    public ITParseAndDiceRollerDiceRollResults() {
        super();
    }

    @Test
    @DisplayName("Returns the expected result for the smallest dice")
    public final void testParse_SmallestDice_Dice() {
        final DiceNotationExpression expression;
        final RollResult             result;
        final String                 notation;
        Dice                         dice;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        dice = result.getDice();
        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Returns the expected number of results for the smallest dice")
    public final void testParse_SmallestDice_Quantity() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   rolled;
        final String                 notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        rolled = new DiceRoller().transform(expression)
            .getRollResults();

        Assertions.assertThat(StreamSupport.stream(rolled.spliterator(), false)
            .count())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Returns the expected rolls for the smallest dice")
    public final void testParse_SmallestDice_Rolls() {
        final DiceNotationExpression expression;
        final RollResult             result;
        final Iterable<Integer>      rolls;
        final String                 notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();
        rolls = result.getAllRolls();

        Assertions.assertThat(StreamSupport.stream(rolls.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(rolls.iterator()
            .next())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Returns the expected total rolls for the smallest dice")
    public final void testParse_SmallestDice_TotalRolls() {
        final DiceNotationExpression expression;
        final RollResult             result;
        final String                 notation;

        notation = "1d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression)
            .getRollResults()
            .iterator()
            .next();

        Assertions.assertThat(result.getTotalRoll())
            .isEqualTo(1);
    }

}
