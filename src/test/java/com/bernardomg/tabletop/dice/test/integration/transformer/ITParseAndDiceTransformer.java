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

package com.bernardomg.tabletop.dice.test.integration.transformer;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.transformer.DiceTransformer;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;
import com.google.common.collect.Iterables;

/**
 * Integration test for {@code DiceTransformer}, verifying that it transforms
 * parsed expressions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndDiceTransformer {

    /**
     * Default constructor.
     */
    public ITParseAndDiceTransformer() {
        super();
    }

    /**
     * Verifies that complex expressions are parsed, returning all the dice set.
     */
    @Test
    public final void testParse_Complex_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice> sets;           // Parsed dice sets
        final Iterator<Dice> itr;            // Parsed dice sets
        Dice dice;                           // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d20-5+2d6");

        sets = new DiceTransformer().transform(parsed);

        Assertions.assertEquals(2, Iterables.size(sets));

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(2), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that multiple dice are parsed, returning all.
     */
    @Test
    public final void testParse_Long_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice> sets;           // Parsed dice sets
        final Iterator<Dice> itr;            // Parsed dice sets
        Dice dice;                           // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser()
                .parse("1d20+2d6-1d12+1d6+2d8");

        sets = new DiceTransformer().transform(parsed);

        Assertions.assertEquals(5, Iterables.size(sets));

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(2), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(12), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(2), dice.getQuantity());
        Assertions.assertEquals(new Integer(8), dice.getSides());
    }

    /**
     * Verifies that dice notation with the maximum integer values dice is
     * parsed.
     */
    @Test
    public final void testParse_Max() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser()
                .parse(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE);

        dice = new DiceTransformer().transform(parsed).iterator().next();

        Assertions.assertEquals(new Integer(Integer.MAX_VALUE),
                dice.getQuantity());
        Assertions.assertEquals(new Integer(Integer.MAX_VALUE),
                dice.getSides());
    }

    /**
     * Verifies that a negative dice notation can be parsed.
     */
    @Test
    public final void testParse_Negative() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("-1d6");

        dice = new DiceTransformer().transform(parsed).iterator().next();

        // TODO: Maybe it should be -1?
        Assertions.assertEquals(new Integer(-1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_NoDice() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice> dice;           // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1");

        dice = new DiceTransformer().transform(parsed);

        Assert.assertEquals(0, Iterables.size(dice));
    }

    /**
     * Verifies that dice notation with a single dice and a single side can be
     * parsed.
     */
    @Test
    public final void testParse_OnesDice_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d1");

        dice = new DiceTransformer().transform(parsed).iterator().next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(1), dice.getSides());
    }

    /**
     * Verifies that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d6");

        dice = new DiceTransformer().transform(parsed).iterator().next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that a simple dice notation can be parsed.
     */
    @Test
    public final void testParse_Simple_UpperCaseSeparator() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1D6");

        dice = new DiceTransformer().transform(parsed).iterator().next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that multiple dice are parsed, returning all.
     */
    @Test
    public final void testParse_Two_ReturnsAll() {
        final DiceNotationExpression parsed; // Parsed expression
        final Iterable<Dice> sets;           // Parsed dice sets
        final Iterator<Dice> itr;            // Parsed dice sets
        Dice dice;                           // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("1d20+2d6");

        sets = new DiceTransformer().transform(parsed);

        Assertions.assertEquals(2, Iterables.size(sets));

        itr = sets.iterator();

        dice = itr.next();

        Assertions.assertEquals(new Integer(1), dice.getQuantity());
        Assertions.assertEquals(new Integer(20), dice.getSides());

        dice = itr.next();

        Assertions.assertEquals(new Integer(2), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

    /**
     * Verifies that dice notation with zero dice is parsed.
     */
    @Test
    public final void testParse_ZeroQuantity() {
        final DiceNotationExpression parsed; // Parsed expression
        final Dice dice;                     // Resulting dice

        parsed = new DefaultDiceNotationExpressionParser().parse("0d6");

        dice = new DiceTransformer().transform(parsed).iterator().next();

        Assertions.assertEquals(new Integer(0), dice.getQuantity());
        Assertions.assertEquals(new Integer(6), dice.getSides());
    }

}
