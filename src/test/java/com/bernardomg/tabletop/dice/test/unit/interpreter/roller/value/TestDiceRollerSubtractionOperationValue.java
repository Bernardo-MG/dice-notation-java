/**
 * Copyright 2014-2023 the original author or authors
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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("DiceRoller handles subtraction operations")
public final class TestDiceRollerSubtractionOperationValue {

    public TestDiceRollerSubtractionOperationValue() {
        super();
    }

    @Test
    @DisplayName("A subtraction returns the expected result")
    public final void testTotalRoll() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 - 2
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("A subtraction (grouped negatives) returns the expected result")
    public final void testTotalRoll_GroupedNegatives() {
        final BinaryOperation        operation; // Tested operation
        final BinaryOperation        groupeda;  // Tested operation
        final BinaryOperation        groupedb;  // Tested operation
        final DiceNotationExpression lefta;     // Left operand
        final DiceNotationExpression righta;    // Right operand
        final DiceNotationExpression leftb;     // Left operand
        final DiceNotationExpression rightb;    // Right operand
        final Integer                rolled;

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

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isZero();
    }

    @Test
    @DisplayName("A subtraction (grouped on the right) returns the expected result")
    public final void testTotalRoll_SubtractGrouped() {
        final BinaryOperation        grouped;   // Tested operation
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final DiceNotationExpression value;     // Right operand
        final Integer                rolled;

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new AdditionOperation(left, right);

        // 1 - (2 + 3)
        // = 1 - 5
        // = -4
        operation = new SubtractionOperation(value, grouped);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(-4);
    }

    @Test
    @DisplayName("A subtraction (negative on the right) returns the expected result")
    public final void testTotalRoll_SubtractNegative() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(-2);

        // 1 - -2
        // = 1 + 2
        // = 3
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("A subtraction (grouped values with a negative on the right) returns the expected result")
    public final void testTotalRoll_SubtractNegative_Grouped() {
        final BinaryOperation        grouped;   // Tested operation
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final DiceNotationExpression value;     // Right operand
        final Integer                rolled;

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 - (2 - 3)
        // = 1 - -1
        // = 1 + 1
        // = 2
        operation = new SubtractionOperation(value, grouped);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("A subtraction (negatives) returns the expected result")
    public final void testTotalRoll_SubtractNegatives() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(-2);

        // -1 - -2
        // = -1 + 2
        // = 1
        operation = new SubtractionOperation(left, right);
        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("A subtraction (left value negative) returns the expected result")
    public final void testTotalRoll_SubtractToNegative() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 - 2
        // = -3
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(-3);
    }

    @Test
    @DisplayName("A subtraction (grouped values with a negative on the left) returns the expected result")
    public final void testTotalRoll_SubtractToNegative_Grouped() {
        final BinaryOperation        grouped;   // Tested operation
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final DiceNotationExpression value;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(3);

        // (1 - 2) - 3
        // = -1 - 3
        // = -4
        operation = new SubtractionOperation(grouped, value);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(-4);
    }

    @Test
    @DisplayName("A subtraction (zeroes) returns the expected result")
    public final void testTotalRoll_Zeroes() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand
        final Integer                rolled;

        left = new IntegerOperand(0);
        right = new IntegerOperand(0);

        // 0 - 0
        operation = new SubtractionOperation(left, right);

        rolled = new DiceRoller().transform(operation)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isZero();
    }

}
