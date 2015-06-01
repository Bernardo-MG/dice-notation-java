package com.wandrell.tabletop.testing.dice.test.unit.notation.formula;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DefaultDiceExpression;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.notation.operation.Operand;
import com.wandrell.tabletop.dice.notation.operation.Operation;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.notation.operation.constant.DiceConstant;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;

public final class TestPrintableTextDefaultDiceFormula {

    public TestPrintableTextDefaultDiceFormula() {
        super();
    }

    @Test
    public final void testGetPrintableText_Addition() {
        final DiceExpression formula;
        final Dice dice;
        final Operand diceOperand;
        final Operand intOperand;
        final Operation operation;

        dice = new DefaultDice(2, 6);

        diceOperand = new DiceOperand(new DiceConstant(dice));
        intOperand = new IntegerConstant(5);

        operation = new AdditionOperation(diceOperand, intOperand);

        formula = new DefaultDiceExpression();

        formula.addDiceNotationComponent(operation);

        Assert.assertEquals(formula.getPrintableText(), "2d6+5");
    }

    @Test
    public final void testGetPrintableText_Substraction() {
        final DiceExpression formula;
        final Dice dice;
        final Operand diceOperand;
        final Operand intOperand;
        final Operation operation;

        dice = new DefaultDice(2, 6);

        diceOperand = new DiceOperand(new DiceConstant(dice));
        intOperand = new IntegerConstant(5);

        operation = new SubstractionOperation(diceOperand, intOperand);

        formula = new DefaultDiceExpression();

        formula.addDiceNotationComponent(operation);

        Assert.assertEquals(formula.getPrintableText(), "2d6-5");
    }

}
