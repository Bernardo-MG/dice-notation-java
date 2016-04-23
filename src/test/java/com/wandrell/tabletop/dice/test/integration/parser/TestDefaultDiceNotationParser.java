/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpressionRoot;
import com.wandrell.tabletop.dice.notation.operand.DiceExpression;
import com.wandrell.tabletop.dice.notation.operand.IntegerExpression;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Units tests for {@code DefaultDiceNotationParser}, checking that it parses
 * concrete notation cases.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An addition with the number to left is parsed correctly.</li>
 * <li>An addition with the number to right is parsed correctly.</li>
 * <li>A subtraction with the number to left is parsed correctly.</li>
 * <li>A subtraction with the number to right is parsed correctly.</li>
 * <li>A lone number is parsed correctly.</li>
 * <li>An addition with only numbers is parsed correctly.</li>
 * <li>A subtraction with only numbers is parsed correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestDefaultDiceNotationParser {

    /**
     * Default constructor.
     */
    public TestDefaultDiceNotationParser() {
        super();
    }

    /**
     * Tests that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_Left() {
        final DiceNotationParser parser;
        final DiceExpressionRoot formula;
        final AdditionOperation operation;
        final IntegerExpression integer;
        final DiceExpression dice;
        final String notation;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "5+2d6";

        formula = parser.parse(notation);

        operation = (AdditionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceExpression) operation.getRight();
        integer = (IntegerExpression) operation.getLeft();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_Right() {
        final DiceExpressionRoot formula;
        final AdditionOperation operation;
        final IntegerExpression integer;
        final DiceExpression dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "2d6+5";

        formula = parser.parse(notation);

        operation = (AdditionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceExpression) operation.getLeft();
        integer = (IntegerExpression) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that a lone number is parsed correctly.
     */
    @Test
    public final void testParse_Number() {
        final DiceExpressionRoot formula;
        final IntegerExpression value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "12";

        formula = parser.parse(notation);

        value = (IntegerExpression) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 12);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add() {
        final DiceExpressionRoot formula;
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "12+1";

        formula = parser.parse(notation);

        value = (AdditionOperation) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getLeft().getValue(), (Integer) 12);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 1);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub() {
        final DiceExpressionRoot formula;
        final SubstractionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "12-1";

        formula = parser.parse(notation);

        value = (SubstractionOperation) formula.getComponents().iterator()
                .next();

        Assert.assertEquals(value.getLeft().getValue(), (Integer) 12);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 1);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Left() {
        final DiceExpressionRoot formula;
        final SubstractionOperation operation;
        final IntegerExpression integer;
        final DiceExpression dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "5-2d6";

        formula = parser.parse(notation);

        operation = (SubstractionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceExpression) operation.getRight();
        integer = (IntegerExpression) operation.getLeft();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    /**
     * Tests that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Right() {
        final DiceExpressionRoot formula;
        final SubstractionOperation operation;
        final IntegerExpression integer;
        final DiceExpression dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "2d6-5";

        formula = parser.parse(notation);

        operation = (SubstractionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceExpression) operation.getLeft();
        integer = (IntegerExpression) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    @Test
    public final void testParse_Zero() {
        final DiceExpressionRoot formula;
        final IntegerExpression value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "0";

        formula = parser.parse(notation);

        value = (IntegerExpression) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 0);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

}
