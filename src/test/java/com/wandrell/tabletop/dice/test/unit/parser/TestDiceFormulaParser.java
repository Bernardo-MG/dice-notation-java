
package com.wandrell.tabletop.dice.test.unit.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;
import com.wandrell.tabletop.dice.parser.DiceExpressionParser;

public final class TestDiceFormulaParser {

    private final Parser<String, DiceExpression> parser;

    {
        parser = new DiceExpressionParser();
    }

    public TestDiceFormulaParser() {
        super();
    }

    @Test
    public final void testParseDice_Add() {
        final DiceExpression formula;
        final AdditionOperation operation;
        final IntegerConstant integer;
        final DiceOperand dice;
        final String notation;

        notation = "2d6+5";

        formula = parser.parse(notation);

        operation = (AdditionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerConstant) operation.getRight();

        Assert.assertEquals(dice.getDice().getDice().getQuantity(),
                (Integer) 2);
        Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    @Test
    public final void testParseDice_Number() {
        final DiceExpression formula;
        final IntegerConstant value;
        final String notation;

        notation = "12";

        formula = parser.parse(notation);

        value = (IntegerConstant) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 12);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    @Test
    public final void testParseDice_Sub() {
        final DiceExpression formula;
        final SubstractionOperation operation;
        final IntegerConstant integer;
        final DiceOperand dice;
        final String notation;

        notation = "2d6-5";

        formula = parser.parse(notation);

        operation = (SubstractionOperation) formula.getComponents().iterator()
                .next();

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerConstant) operation.getRight();

        Assert.assertEquals(dice.getDice().getDice().getQuantity(),
                (Integer) 2);
        Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

    @Test
    public final void testParseDice_Zero() {
        final DiceExpression formula;
        final IntegerConstant value;
        final String notation;

        notation = "0";

        formula = parser.parse(notation);

        value = (IntegerConstant) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 0);

        Assert.assertEquals(formula.getStringRepresentation(), notation);
    }

}
