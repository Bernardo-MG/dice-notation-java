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

package com.bernardomg.tabletop.dice.notation.operation;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Addition operation.
 * <p>
 * This adds together the values from two dice notation expressions.
 * <p>
 * As with any other addition, the order of the operands does not matter for the
 * result.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class AdditionOperation extends AbstractBinaryOperation {

    /**
     * Constructs an addition operation with the specified operands.
     * 
     * @param left
     *            the left sided operand
     * @param right
     *            the right sided operand
     */
    public AdditionOperation(final DiceNotationExpression left,
            final DiceNotationExpression right) {
        super(left, right, (a, b) -> a + b);
    }

    /**
     * Returns the values from the left and right operands added together.
     * 
     * @return the left and right values added together
     */
    @Override
    public final String getExpression() {
        final String left;
        final String right;

        left = getLeft().getExpression();
        right = getRight().getExpression();

        return String.format("%s+%s", left, right);
    }

}
