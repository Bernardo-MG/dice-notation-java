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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Unit tests for {@link DiceRoller}, verifying that handles subtraction
 * operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRollerSubtractionOperationValue {

    /**
     * Default constructor.
     */
    public TestDiceRollerSubtractionOperationValue() {
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
        final Integer rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-1), rolled);
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
        final Integer rolled;

        lefta = new IntegerOperand(1);
        righta = new IntegerOperand(2);

        groupeda = new SubtractionOperation(lefta, righta);

        leftb = new IntegerOperand(3);
        rightb = new IntegerOperand(4);

        groupedb = new SubtractionOperation(leftb, rightb);

        // (1 - 2) - (3 - 4)
        // = (-1) - (-1)
        // = -1 + 1
        // = 0
        operation = new SubtractionOperation(groupeda, groupedb);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(0), rolled);
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
        final Integer rolled;

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new AdditionOperation(left, right);

        // 1 - (2 + 3)
        // = 1 - 5
        // = -4
        operation = new SubtractionOperation(value, grouped);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-4), rolled);
    }

    /**
     * Verifies that subtractions of negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(-2);

        // 1 - -2
        // = 1 + 2
        // = 3
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(3), rolled);
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
        final Integer rolled;

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 - (2 - 3)
        // = 1 - -1
        // = 1 + 1
        // = 2
        operation = new SubtractionOperation(value, grouped);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(2), rolled);
    }

    /**
     * Verifies that subtractions of negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractNegatives() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(-2);

        // -1 - -2
        // = -1 + 2
        // = 1
        operation = new SubtractionOperation(left, right);
        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(1), rolled);
    }

    /**
     * Verifies that subtractions to negative values are handled correctly.
     */
    @Test
    public final void testValue_SubtractToNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 - 2
        // = -3
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-3), rolled);
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
        final Integer rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(3);

        // (1 - 2) - 3
        // = -1 - 3
        // = -4
        operation = new SubtractionOperation(grouped, value);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-4), rolled);
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testValue_Zeroes() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(0);
        right = new IntegerOperand(0);

        // 0 - 0
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(0), rolled);
    }

}
