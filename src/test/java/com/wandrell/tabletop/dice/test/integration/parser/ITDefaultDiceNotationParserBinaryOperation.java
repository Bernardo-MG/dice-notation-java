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

import com.wandrell.tabletop.dice.notation.operand.DiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.SubtractionOperation;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Integration tests for {@code DefaultDiceNotationParser}, checking that it
 * parses simple binary operations.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An addition with the number to left is parsed correctly.</li>
 * <li>An addition with the number to right is parsed correctly.</li>
 * <li>A subtraction with the number to left is parsed correctly.</li>
 * <li>A subtraction with the number to right is parsed correctly.</li>
 * <li>An addition with only numbers is parsed correctly.</li>
 * <li>An addition using only dice is parsed correctly.</li>
 * <li>A subtraction with only numbers is parsed correctly.</li>
 * <li>A subtraction using only dice is parsed correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITDefaultDiceNotationParserBinaryOperation {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationParserBinaryOperation() {
        super();
    }

    /**
     * Tests that an addition using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Add_Dice() {
        final DiceNotationParser parser;
        final AdditionOperation operation;
        final DiceOperand diceLeft;
        final DiceOperand diceRight;
        final String notation;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1d20+2d6";

        operation = (AdditionOperation) parser.parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assert.assertEquals(diceLeft.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(diceLeft.getDice().getSides(), (Integer) 20);

        Assert.assertEquals(diceRight.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(diceRight.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_LeftNumber() {
        final DiceNotationParser parser;
        final AdditionOperation operation;
        final IntegerOperand integer;
        final DiceOperand dice;
        final String notation;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "5+2d6";

        operation = (AdditionOperation) parser.parse(notation);

        dice = (DiceOperand) operation.getRight();
        integer = (IntegerOperand) operation.getLeft();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_RightNumber() {
        final AdditionOperation operation;
        final IntegerOperand integer;
        final DiceOperand dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "2d6+5";

        operation = (AdditionOperation) parser.parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add() {
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1+2";

        value = (AdditionOperation) parser.parse(notation);

        Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that long additions can be parsed, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_Add_Long() {
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1+2+3";

        // TODO
        value = (AdditionOperation) parser.parse(notation);

        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that longer additions can be parsed, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_Add_Longer() {
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1+2+3+4+5";

        // TODO
        value = (AdditionOperation) parser.parse(notation);

        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_AddAndSub() {
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1+2-3";

        // TODO
        value = (AdditionOperation) parser.parse(notation);

        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub() {
        final SubtractionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1-2";

        value = (SubtractionOperation) parser.parse(notation);

        Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long() {
        final SubtractionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1-2-3";

        value = (SubtractionOperation) parser.parse(notation);

        // TODO
        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 12);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 1);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer() {
        final SubtractionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1-2-3-4-5";

        value = (SubtractionOperation) parser.parse(notation);

        // TODO
        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 12);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 1);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_SubAndAdd() {
        final AdditionOperation value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "3-1+2";

        // TODO
        value = (AdditionOperation) parser.parse(notation);

        // Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        // Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        // Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice() {
        final DiceNotationParser parser;
        final SubtractionOperation operation;
        final DiceOperand diceLeft;
        final DiceOperand diceRight;
        final String notation;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1d20-2d6";

        operation = (SubtractionOperation) parser.parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assert.assertEquals(diceLeft.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(diceLeft.getDice().getSides(), (Integer) 20);

        Assert.assertEquals(diceRight.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(diceRight.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber() {
        final SubtractionOperation operation;
        final IntegerOperand integer;
        final DiceOperand dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "5-2d6";

        operation = (SubtractionOperation) parser.parse(notation);

        dice = (DiceOperand) operation.getRight();
        integer = (IntegerOperand) operation.getLeft();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber() {
        final SubtractionOperation operation;
        final IntegerOperand integer;
        final DiceOperand dice;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "2d6-5";

        operation = (SubtractionOperation) parser.parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

}
