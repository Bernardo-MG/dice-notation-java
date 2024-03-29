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

package com.bernardomg.tabletop.dice.test.unit.notation.operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("Tests for SubtractionOperation")
public final class TestSubtractionOperation {

    public TestSubtractionOperation() {
        super();
    }

    @Test
    @DisplayName("The text expression is generated correctly for negatives")
    public final void testTextExpression_Negatives() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand

        left = new IntegerOperand(-1);
        right = new IntegerOperand(-2);

        operation = new SubtractionOperation(left, right);

        Assertions.assertThat(operation.getExpression())
            .isEqualTo("-1--2");
    }

    @Test
    @DisplayName("The text expression is generated correctly")
    public final void testTextExpression_Positives() {
        final BinaryOperation        operation; // Tested operation
        final DiceNotationExpression left;      // Left operand
        final DiceNotationExpression right;     // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        operation = new SubtractionOperation(left, right);

        Assertions.assertThat(operation.getExpression())
            .isEqualTo("1-2");
    }

}
