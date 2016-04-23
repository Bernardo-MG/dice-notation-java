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
import com.wandrell.tabletop.dice.notation.operand.DiceNotationOperand;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;

public final class TestStringRepresentationSubstractionOperation {

    public TestStringRepresentationSubstractionOperation() {
        super();
    }

    @Test
    public final void testGetStringRepresentation() {
        final DiceExpressionComponent operation;
        final DiceNotationOperand operandA;
        final DiceNotationOperand operandB;

        operandA = Mockito.mock(DiceNotationOperand.class);
        Mockito.when(operandA.getStringRepresentation()).thenReturn("1");

        operandB = Mockito.mock(DiceNotationOperand.class);
        Mockito.when(operandB.getStringRepresentation()).thenReturn("2");

        operation = new SubstractionOperation(operandA, operandB);

        Assert.assertEquals(operation.getStringRepresentation(), "1-2");
    }

}
