package com.wandrell.tabletop.testing.dice.test.integration.operation;

import java.util.Collection;
import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.calculator.DefaultDiceNotationCalculator;
import com.wandrell.tabletop.dice.notation.calculator.DiceNotationCalculator;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public final class ITAdditionDiceNotationCalculator {

    public ITAdditionDiceNotationCalculator() {
        super();
    }

    @Test
    public void test_both_negative() {
        final BinaryOperation operation1;
        final Operand value1;
        final Operand value2;
        final Integer result;
        final DiceNotationCalculator calculator;
        final Collection<Operand> operands;
        final Collection<BinaryOperation> operations;

        value1 = new IntegerOperand(-10);
        value2 = new IntegerOperand(-5);

        operation1 = new AdditionOperation();

        calculator = new DefaultDiceNotationCalculator();

        operands = new LinkedList<>();
        operations = new LinkedList<>();

        operands.add(value1);
        operands.add(value2);

        operations.add(operation1);

        result = calculator.execute(operands, operations);

        Assert.assertEquals(result, (Integer) (0 - 15));
    }

    @Test
    public void test_both_positive() {
        final BinaryOperation operation1;
        final Operand value1;
        final Operand value2;
        final Integer result;
        final DiceNotationCalculator calculator;
        final Collection<Operand> operands;
        final Collection<BinaryOperation> operations;

        value1 = new IntegerOperand(10);
        value2 = new IntegerOperand(5);

        operation1 = new AdditionOperation();

        calculator = new DefaultDiceNotationCalculator();

        operands = new LinkedList<>();
        operations = new LinkedList<>();

        operands.add(value1);
        operands.add(value2);

        operations.add(operation1);

        result = calculator.execute(operands, operations);

        Assert.assertEquals(result, (Integer) 15);
    }

    @Test
    public void test_long() {
        final BinaryOperation operation1;
        final Operand value1;
        final Operand value2;
        final Operand value3;
        final Operand value4;
        final Operand value5;
        final Operand value6;
        final Integer result;
        final DiceNotationCalculator calculator;
        final Collection<Operand> operands;
        final Collection<BinaryOperation> operations;

        value1 = new IntegerOperand(10);
        value2 = new IntegerOperand(-5);
        value3 = new IntegerOperand(5);
        value4 = new IntegerOperand(1);
        value5 = new IntegerOperand(5);
        value6 = new IntegerOperand(1);

        operation1 = new AdditionOperation();

        calculator = new DefaultDiceNotationCalculator();

        operands = new LinkedList<>();
        operations = new LinkedList<>();

        operands.add(value1);
        operands.add(value2);
        operands.add(value3);
        operands.add(value4);
        operands.add(value5);
        operands.add(value6);

        operations.add(operation1);
        operations.add(operation1);
        operations.add(operation1);
        operations.add(operation1);
        operations.add(operation1);

        result = calculator.execute(operands, operations);

        Assert.assertEquals(result, (Integer) 17);
    }

    @Test
    public void test_one_negative() {
        final BinaryOperation operation1;
        final Operand value1;
        final Operand value2;
        final Integer result;
        final DiceNotationCalculator calculator;
        final Collection<Operand> operands;
        final Collection<BinaryOperation> operations;

        value1 = new IntegerOperand(10);
        value2 = new IntegerOperand(-5);

        operation1 = new AdditionOperation();

        calculator = new DefaultDiceNotationCalculator();

        operands = new LinkedList<>();
        operations = new LinkedList<>();

        operands.add(value1);
        operands.add(value2);

        operations.add(operation1);

        result = calculator.execute(operands, operations);

        Assert.assertEquals(result, (Integer) 5);
    }

    @Test
    public void test_same_positive() {
        final BinaryOperation operation1;
        final Operand value1;
        final Integer result;
        final DiceNotationCalculator calculator;
        final Collection<Operand> operands;
        final Collection<BinaryOperation> operations;

        value1 = new IntegerOperand(10);

        operation1 = new AdditionOperation();

        calculator = new DefaultDiceNotationCalculator();

        operands = new LinkedList<>();
        operations = new LinkedList<>();

        operands.add(value1);
        operands.add(value1);

        operations.add(operation1);

        result = calculator.execute(operands, operations);

        Assert.assertEquals(result, (Integer) 20);
    }

}
