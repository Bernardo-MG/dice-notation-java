package com.wandrell.tabletop.testing.dice.test.unit.notation.operation;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operation.Operand;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;

public final class TestPrintableTextSubstractionOperation {

    public TestPrintableTextSubstractionOperation() {
        super();
    }

    @Test
    public final void testGetPrintableText() {
        final DiceExpressionComponent operation;
        final Operand operandA;
        final Operand operandB;

        operandA = Mockito.mock(Operand.class);
        Mockito.when(operandA.getPrintableText()).thenReturn("A");

        operandB = Mockito.mock(Operand.class);
        Mockito.when(operandB.getPrintableText()).thenReturn("B");

        operation = new SubstractionOperation(operandA, operandB);

        Assert.assertEquals(operation.getPrintableText(), "A - B");
    }

}
