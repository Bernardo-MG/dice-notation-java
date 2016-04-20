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

package com.wandrell.tabletop.dice.test.unit.notation.operation;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operand.Operand;
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
        Mockito.when(operandA.getStringRepresentation()).thenReturn("A");

        operandB = Mockito.mock(Operand.class);
        Mockito.when(operandB.getStringRepresentation()).thenReturn("B");

        operation = new SubstractionOperation(operandA, operandB);

        Assert.assertEquals(operation.getStringRepresentation(), "A-B");
    }

}
