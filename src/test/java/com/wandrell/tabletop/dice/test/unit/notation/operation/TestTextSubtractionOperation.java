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

import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Unit tests for {@link SubtractionOperation}, checking that it works as
 * expected with its operands.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The text expression is generated correctly.</li>
 * <li>The value is generated correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestTextSubtractionOperation {

    /**
     * Default constructor.
     */
    public TestTextSubtractionOperation() {
        super();
    }

    /**
     * Tests that the value is generated correctly.
     */
    @Test
    public final void testgetValue() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(left.getValue()).thenReturn(1);

        right = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(right.getValue()).thenReturn(2);

        operation = new SubtractionOperation(left, right);

        Assert.assertEquals(operation.getValue(), new Integer(-1));
    }

    /**
     * Tests that the text expression is generated correctly.
     */
    @Test
    public final void testTextExpression() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(left.getExpression()).thenReturn("1");

        right = Mockito.mock(DiceNotationExpression.class);
        Mockito.when(right.getExpression()).thenReturn("2");

        operation = new SubtractionOperation(left, right);

        Assert.assertEquals(operation.getExpression(), "1-2");
    }

}