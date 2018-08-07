/**
 * Copyright 2014-2017 the original author or authors
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

package com.bernardomg.tabletop.dice.notation.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.BiFunction;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpressionRoot;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;

public final class RollerTransformer
        implements DiceNotationTransformer<Integer> {

    /**
     * Roller to generate the random value from the dice.
     */
    private final Roller diceRoller;

    public RollerTransformer() {
        super();

        diceRoller = new DefaultRoller();
    }

    public RollerTransformer(final Roller roller) {
        super();

        diceRoller = checkNotNull(roller, "Received a null pointer as roller");
    }

    @Override
    public final Integer transform(final DiceNotationExpression expression) {
        final Integer result;
        // TODO: Avoid casting

        if (expression instanceof DiceNotationExpressionRoot) {
            result = transform(
                    ((DiceNotationExpressionRoot) expression).getRoot());
        } else if (expression instanceof BinaryOperation) {
            result = transform((BinaryOperation) expression);
        } else if (expression instanceof ConstantOperand) {
            result = transform((ConstantOperand) expression);
        } else if (expression instanceof DiceOperand) {
            result = transform((DiceOperand) expression);
        } else {
            result = 0;
        }

        return result;
    }

    private final Integer
            processBinary(final DiceNotationExpression operation) {
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final Integer leftValue;
        final Integer rightValue;
        final Integer value;
        final BiFunction<Integer, Integer, Integer> func;

        // Operates in inorder
        // - Go through left nodes while they are binary
        // - Then go through right nodes
        // - Operate when both are not binary and backtrace

        if (operation instanceof BinaryOperation) {
            left = ((BinaryOperation) operation).getLeft();
            right = ((BinaryOperation) operation).getRight();

            func = ((BinaryOperation) operation).getOperation();

            if (left instanceof BinaryOperation) {
                leftValue = processBinary(left);
            } else {
                leftValue = transform(left);
            }

            if (right instanceof BinaryOperation) {
                rightValue = processBinary(right);
            } else {
                rightValue = transform(right);
            }

            value = func.apply(leftValue, rightValue);
        } else {
            value = transform(operation);
        }

        return value;
    }

    private final Integer transform(final BinaryOperation operation) {
        Integer result;

        result = processBinary(operation);

        return result;
    }

    private final Integer transform(final ConstantOperand operand) {
        return operand.getValue();
    }

    private final Integer transform(final DiceOperand operand) {
        final Iterable<Integer> rolls;
        Integer total;

        rolls = diceRoller.roll(operand.getDice());

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        return total;
    }

}
