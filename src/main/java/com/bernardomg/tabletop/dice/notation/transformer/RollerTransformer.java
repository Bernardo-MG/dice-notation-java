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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

        // TODO: Is it using the accumulator?

        diceRoller = new DefaultRoller();
    }

    public RollerTransformer(final Roller roller) {
        super();

        diceRoller = checkNotNull(roller, "Received a null pointer as roller");
    }

    @Override
    public final Integer transform(final DiceNotationExpression expression) {
        return transform(expression, 0);
    }

    private final void stack(final DiceNotationExpression operation,
            final Collection<Integer> values,
            final Collection<BiFunction<Integer, Integer, Integer>> operations,
            final Integer accumulated) {
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        BiFunction<Integer, Integer, Integer> func;

        if (operation instanceof BinaryOperation) {
            left = ((BinaryOperation) operation).getLeft();
            right = ((BinaryOperation) operation).getRight();

            // TODO: Verify if this operation makes sense at all
            if ((right instanceof BinaryOperation)
                    && !(left instanceof BinaryOperation)) {
                // Gives precedence to the right operand
                stack(right, values, operations, accumulated);
                stack(left, values, operations, accumulated);
                func = (a, b) -> ((BinaryOperation) operation).getOperation()
                        .apply(b, a);
            } else {
                stack(left, values, operations, accumulated);
                stack(right, values, operations, accumulated);
                func = ((BinaryOperation) operation).getOperation();
            }

            operations.add(func);
        } else {
            values.add(transform(operation, accumulated));
        }

    }

    private final Integer transform(final BinaryOperation operation,
            final Integer accumulated) {
        final Collection<Integer> values;
        final Iterator<Integer> valuesItr;
        final Collection<BiFunction<Integer, Integer, Integer>> operations;
        Integer left;
        Integer right;
        Integer result;

        values = new ArrayList<>();
        operations = new ArrayList<>();

        stack(operation, values, operations, accumulated);

        valuesItr = values.iterator();
        if (!values.isEmpty()) {
            left = valuesItr.next();
            right = valuesItr.next();
            result = 0;
        } else {
            left = 0;
            right = 0;
            result = 0;
        }
        for (final BiFunction<Integer, Integer, Integer> op : operations) {
            left = op.apply(left, right);
            if (valuesItr.hasNext()) {
                right = valuesItr.next();
            }
            result = left;
        }

        return accumulated + result;
    }

    private final Integer transform(final ConstantOperand operand,
            final Integer accumulated) {
        return operand.getValue();
    }

    private final Integer transform(final DiceNotationExpression expression,
            final Integer accumulated) {
        final Integer result;
        // TODO: Avoid casting

        if (expression instanceof DiceNotationExpressionRoot) {
            result = transform(
                    ((DiceNotationExpressionRoot) expression).getRoot());
        } else if (expression instanceof BinaryOperation) {
            result = transform((BinaryOperation) expression, accumulated);
        } else if (expression instanceof ConstantOperand) {
            result = transform((ConstantOperand) expression, accumulated);
        } else if (expression instanceof DiceOperand) {
            result = transform((DiceOperand) expression, accumulated);
        } else {
            result = accumulated;
        }

        return accumulated + result;
    }

    private final Integer transform(final DiceOperand operand,
            final Integer accumulated) {
        final Iterable<Integer> rolls;
        Integer total;

        rolls = diceRoller.roll(operand.getDice());

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        return accumulated + total;
    }

}
