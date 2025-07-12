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

package com.bernardomg.tabletop.dice.notation.operation;

import java.util.Objects;
import java.util.function.BinaryOperator;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Division operation.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final record DivisionOperation(DiceNotationExpression left, DiceNotationExpression right)
        implements BinaryOperation {

    /**
     * Constructs a division operation with the specified operands.
     *
     * @param left
     *            the left sided operand
     * @param right
     *            the right sided operand
     */
    public DivisionOperation(final DiceNotationExpression left, final DiceNotationExpression right) {
        this.left = Objects.requireNonNull(left, "Received a null pointer as left operand");
        this.right = Objects.requireNonNull(right, "Received a null pointer as right operand");
    }

    @Override
    public final String getExpression() {
        final String left;  // Left side operand as a string
        final String right; // Right side operand as a string

        left = getLeft().getExpression();
        right = getRight().getExpression();

        return String.format("%s/%s", left, right);
    }

    @Override
    public DiceNotationExpression getLeft() {
        return left;
    }

    @Override
    public BinaryOperator<Integer> getOperation() {
        return (a, b) -> a / b;
    }

    @Override
    public DiceNotationExpression getRight() {
        return right;
    }

}
