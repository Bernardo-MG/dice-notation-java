/**
 * Copyright 2014-2018 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.notation.transformer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;

/**
 * Unit tests for {@link SubtractionOperation}, checking that it works as
 * expected with its operands.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestRollerTransformerSubtractionOperation {

    /**
     * Default constructor.
     */
    public TestRollerTransformerSubtractionOperation() {
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

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        operation = new SubtractionOperation(left, right);

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

        // (1 - 2) - (3 - 4)
        operation = new SubtractionOperation(groupeda, groupedb);

        Assertions.assertEquals(new Integer(0),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that the value is generated correctly when the values are
     * grouped on the right side.
     */
    @Test
    public final void testValue_SubtractGrouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new AdditionOperation(left, right);

        // 1 - (2 + 3)
        operation = new SubtractionOperation(value, grouped);

        Assertions.assertEquals(new Integer(-4),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that subtractions of negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(-2);

        // 1 - -2
        operation = new SubtractionOperation(left, right);

        Assertions.assertEquals(new Integer(3),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that the value is generated correctly when the values are
     * grouped on the right side.
     */
    @Test
    public final void testValue_SubtractNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 - (2 - 3)
        operation = new SubtractionOperation(value, grouped);

        Assertions.assertEquals(new Integer(2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that subtractions of negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractNegatives() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-1);
        right = new IntegerOperand(-2);

        // -1 - -2
        operation = new SubtractionOperation(left, right);

        Assertions.assertEquals(new Integer(1),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that subtractions to negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractToNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 - 2
        operation = new SubtractionOperation(left, right);

        Assertions.assertEquals(new Integer(-3),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that the value is generated correctly when the values are
     * grouped on the left side.
     */
    @Test
    public final void testValue_SubtractToNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(3);

        // (1 - 2) - 3
        operation = new SubtractionOperation(grouped, value);

        Assertions.assertEquals(new Integer(-4),
                new RollerTransformer().transform(operation));
    }

}
