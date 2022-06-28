/**
 * Copyright 2014-2022 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.bernardomg.tabletop.dice.test.integration.interpreter.dice;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.interpreter.DiceGatherer;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceGatherer with a parsed expression")
public final class ITParseAndDiceGatherer {

    public ITParseAndDiceGatherer() {
        super();
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice addition")
    public final void testParse_Addition() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20+2d6");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(2, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a complex expression")
    public final void testParse_Complex_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20-5*1d8+2d6/3d12");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(4, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(8), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(3), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(12), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a long expression")
    public final void testParse_Long_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d20+2d6-1d12+1d6+2d8");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(5, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(-1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(12), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(8), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using the max integers")
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;                     // Resulting dice

        parsed = new DefaultDiceParser().parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE);

        dice = new DiceGatherer().transform(parsed)
            .iterator()
            .next();

        Assertions.assertEquals(Integer.valueOf(Integer.MAX_VALUE), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(Integer.MAX_VALUE), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using a negative dice")
    public final void testParse_Negative() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;                     // Resulting dice

        parsed = new DefaultDiceParser().parse("-1d6");

        dice = new DiceGatherer().transform(parsed)
            .iterator()
            .next();

        Assertions.assertEquals(Integer.valueOf(-1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("No dice are aquired from a constant")
    public final void testParse_NoDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         dice;           // Resulting dice

        parsed = new DefaultDiceParser().parse("1");

        dice = new DiceGatherer().transform(parsed);

        Assert.assertEquals(0, StreamSupport.stream(dice.spliterator(), false)
            .count());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using the minimal dice")
    public final void testParse_OnesDice_Minimal() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;                     // Resulting dice

        parsed = new DefaultDiceParser().parse("1d1");

        dice = new DiceGatherer().transform(parsed)
            .iterator()
            .next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(1), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using a simple dice")
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;                     // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6");

        dice = new DiceGatherer().transform(parsed)
            .iterator()
            .next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice subtraction")
    public final void testParse_Subtraction() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2d12");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(2, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(-2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(12), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using subtraction and addition")
    public final void testParse_SubtractionAddition() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2d8+3d10");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(3, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(-2), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(8), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(3), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(10), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using subtraction and addition when all the dice are equal")
    public final void testParse_SubtractionAddition_Dice_AllEqual() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-1d6+1d6");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(3, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(-1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using dice and constants")
    public final void testParse_WithConstants() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice>         sets;           // Parsed dice sets
        final Iterator<Dice>         itr;            // Parsed dice sets
        Dice                         dice;                           // Resulting dice

        parsed = new DefaultDiceParser().parse("1d6-2+3d10");

        sets = new DiceGatherer().transform(parsed);

        Assertions.assertEquals(2, StreamSupport.stream(sets.spliterator(), false)
            .count());

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(1), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(Integer.valueOf(3), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(10), dice.getSides());
    }

    @Test
    @DisplayName("Dice can be acquired from a expression using zero for quantity")
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice                   dice;                     // Resulting dice

        parsed = new DefaultDiceParser().parse("0d6");

        dice = new DiceGatherer().transform(parsed)
            .iterator()
            .next();

        Assertions.assertEquals(Integer.valueOf(0), dice.getQuantity());
        Assertions.assertEquals(Integer.valueOf(6), dice.getSides());
    }

}
