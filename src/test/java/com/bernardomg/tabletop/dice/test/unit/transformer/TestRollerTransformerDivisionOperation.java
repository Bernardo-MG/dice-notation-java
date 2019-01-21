/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.transformer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.DivisionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.transformer.RollerTransformer;

/**
 * Unit tests for {@link RollerTransformer}, verifying that handles division
 * operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestRollerTransformerDivisionOperation {

    /**
     * Default constructor.
     */
    public TestRollerTransformerDivisionOperation() {
        super();
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testValue() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(2);
        right = new IntegerOperand(1);

        // 2 / 1
        operation = new DivisionOperation(left, right);

        Assertions.assertEquals(new Integer(2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    public final void testValue_DivideNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-2);
        right = new IntegerOperand(1);

        // -2 / 1
        operation = new DivisionOperation(left, right);

        Assertions.assertEquals(new Integer(-2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications to negative values are handled correctly.
     */
    @Test
    public final void testValue_DivideNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(5);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(2);

        // (1 - 5) / 2
        // = -4 / 2
        // = -2
        operation = new DivisionOperation(grouped, value);

        Assertions.assertEquals(new Integer(-2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that additions of negative values are handled correctly.
     */
    @Test
    public final void testValue_DivideNegatives() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-2);
        right = new IntegerOperand(-1);

        // -2 / -1
        operation = new DivisionOperation(left, right);

        Assertions.assertEquals(new Integer(2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    public final void testValue_DivideToNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(2);
        right = new IntegerOperand(-1);

        // 2 / -1
        operation = new DivisionOperation(left, right);

        Assertions.assertEquals(new Integer(-2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that additions of negative values are handled correctly.
     */
    @Test
    public final void testValue_DivideToNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 / (2 - 3)
        // = 1 / -1
        // = -1
        operation = new DivisionOperation(value, grouped);

        Assertions.assertEquals(new Integer(-1),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that the value is generated correctly when the values are
     * grouped negative results.
     */
    @Test
    public final void testValue_GroupedNegatives() {
        final BinaryOperation operation;     // Tested operation
        final BinaryOperation groupeda;      // Tested operation
        final BinaryOperation groupedb;      // Tested operation
        final DiceNotationExpression lefta;  // Left operand
        final DiceNotationExpression righta; // Right operand
        final DiceNotationExpression leftb;  // Left operand
        final DiceNotationExpression rightb; // Right operand

        lefta = new IntegerOperand(1);
        righta = new IntegerOperand(2);

        groupeda = new SubtractionOperation(lefta, righta);

        leftb = new IntegerOperand(3);
        rightb = new IntegerOperand(4);

        groupedb = new SubtractionOperation(leftb, rightb);

        // (1 - 2) / (3 - 4)
        // = (-1) / (-1)
        // = -1 / -1
        // = 1
        operation = new DivisionOperation(groupeda, groupedb);

        Assertions.assertEquals(new Integer(1),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testValue_Zeroes() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Executable closure;

        left = new IntegerOperand(0);
        right = new IntegerOperand(0);

        // 0 / 0
        operation = new DivisionOperation(left, right);

        closure = () -> new RollerTransformer().transform(operation);

        Assertions.assertThrows(Exception.class, closure);
    }

}
