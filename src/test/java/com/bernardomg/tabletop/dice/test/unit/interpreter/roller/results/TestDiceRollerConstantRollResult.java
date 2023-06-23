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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.results;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;

@DisplayName("DiceRoller returns the expected roll results for constants")
public final class TestDiceRollerConstantRollResult {

    public TestDiceRollerConstantRollResult() {
        super();
    }

    @Test
    @DisplayName("A negative value generates the expected rolls")
    public final void testRolls_Negative() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Iterable<Integer>      rolls;
        final Iterator<Integer>      rollValues;

        expression = new IntegerOperand(-4);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();
        rolls = result.getAllRolls();

        Assertions.assertThat(StreamSupport.stream(results.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(StreamSupport.stream(rolls.spliterator(), false)
            .count())
            .isEqualTo(1);

        rollValues = rolls.iterator();
        Assertions.assertThat(rollValues.next())
            .isEqualTo(-4);
    }

    @Test
    @DisplayName("The default dice is generated for negative values")
    public final void testRolls_Negative_Dice() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Dice                   dice;

        expression = new IntegerOperand(-4);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();

        dice = result.getDice();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(-4);
    }

    @Test
    @DisplayName("A positive value generates the expected rolls")
    public final void testRolls_Positive() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Iterable<Integer>      rolls;
        final Iterator<Integer>      rollValues;

        expression = new IntegerOperand(4);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();
        rolls = result.getAllRolls();

        Assertions.assertThat(StreamSupport.stream(results.spliterator(), false)
            .count())
            .isEqualTo(1);
        Assertions.assertThat(StreamSupport.stream(rolls.spliterator(), false)
            .count())
            .isEqualTo(1);

        rollValues = rolls.iterator();
        Assertions.assertThat(rollValues.next())
            .isEqualTo(4);
    }

    @Test
    @DisplayName("The default dice is generated for positive values")
    public final void testRolls_Positive_Dice() {
        final DiceNotationExpression expression;
        final Iterable<RollResult>   results;
        final RollResult             result;
        final Dice                   dice;

        expression = new IntegerOperand(4);

        results = new DiceRoller().transform(expression)
            .getRollResults();
        result = results.iterator()
            .next();

        dice = result.getDice();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(4);
    }

}
