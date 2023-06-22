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

package com.bernardomg.tabletop.dice.test.integration.interpreter.dice;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.interpreter.DiceGatherer;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.NotationAndValuesArgumentsProvider;

@DisplayName("DiceGatherer with a parsed expression")
public final class ITParseAndDiceGatherer {

    public ITParseAndDiceGatherer() {
        super();
    }

    @ParameterizedTest(name = "{0} = {1} dice with {2} sides")
    @ArgumentsSource(NotationAndValuesArgumentsProvider.class)
    @DisplayName("Dice can be acquired from a expression")
    public final void testParse(final String notation, final Integer quantity, final Integer sides) {
        final DiceNotationExpression parsed;
        final Dice                   dice;
        final Iterable<Dice>         gathered;

        parsed = new DefaultDiceParser().parse(notation);

        gathered = new DiceGatherer().transform(parsed);
        Assertions.assertThat(StreamSupport.stream(gathered.spliterator(), false)
            .count())
            .isEqualTo(1);

        dice = gathered.iterator()
            .next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(quantity);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(sides);
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice addition")
    public final void testParse_Addition() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20+2d6");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(2);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(20);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Dice can be acquired from a complex expression")
    public final void testParse_Complex_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20-5*1d8+2d6/3d12");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(4);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(20);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(8);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(3);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(12);
    }

    @Test
    @DisplayName("Dice can be acquired from a long expression")
    public final void testParse_Long_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20+2d6-1d12+1d6+2d8");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(5);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(20);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(-1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(12);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(8);
    }

    @Test
    @DisplayName("No dice are aquired from a constant")
    public final void testParse_NoDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1");

        dice = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(dice.spliterator(), false)
            .count())
            .isZero();
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice subtraction")
    public final void testParse_Subtraction() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2d12");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(2);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(-2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(12);
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using subtraction and addition")
    public final void testParse_SubtractionAddition() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2d8+3d10");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(3);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(-2);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(8);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(3);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(10);
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using subtraction and addition when all the dice are equal")
    public final void testParse_SubtractionAddition_Dice_AllEqual() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-1d6+1d6");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(3);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(-1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice and constants")
    public final void testParse_WithConstants() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;   // Parsed dice sets
        final Iterator<Dice>         itr;    // Parsed dice sets
        Dice                         dice;   // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2+3d10");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertThat(StreamSupport.stream(sets.spliterator(), false)
            .count())
            .isEqualTo(2);

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(6);

        dice = itr.next();

        Assertions.assertThat(dice.getQuantity())
            .isEqualTo(3);
        Assertions.assertThat(dice.getSides())
            .isEqualTo(10);
    }

}
