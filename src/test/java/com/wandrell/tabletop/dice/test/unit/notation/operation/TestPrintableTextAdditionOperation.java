
package com.wandrell.tabletop.dice.test.unit.notation.operation;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public final class TestPrintableTextAdditionOperation {

    public TestPrintableTextAdditionOperation() {
        super();
    }

    @Test
    public final void testGetPrintableText() {
        final DiceExpressionComponent operation;
        final Operand operandA;
        final Operand operandB;

        operandA = Mockito.mock(Operand.class);
        Mockito.when(operandA.getStringRepresentation()).thenReturn("A");

        operandB = Mockito.mock(Operand.class);
        Mockito.when(operandB.getStringRepresentation()).thenReturn("B");

        operation = new AdditionOperation(operandA, operandB);

        Assert.assertEquals(operation.getStringRepresentation(), "A+B");
    }

}
