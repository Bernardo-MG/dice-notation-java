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

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
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

        // TODO: Maybe this should be an accumulator?

        diceRoller = new DefaultRoller();
    }

    public RollerTransformer(final Roller roller) {
        super();

        diceRoller = checkNotNull(roller, "Received a null pointer as roller");
    }

    @Override
    public final Integer getNeutralValue() {
        return 0;
    }

    @Override
    public final Integer transform(final BinaryOperation operation,
            final Integer accumulated) {
        final Integer left;
        final Integer right;

        left = transform(operation.getLeft(), accumulated);
        right = transform(operation.getRight(), accumulated);
        return accumulated + operation.getOperation().apply(left, right);
    }

    @Override
    public final Integer transform(final ConstantOperand operand,
            final Integer accumulated) {
        return operand.getValue();
    }

    @Override
    public final Integer transform(final DiceNotationExpression expression,
            final Integer accumulated) {
        final Integer result;
        // TODO: Avoid casting

        if (expression instanceof BinaryOperation) {
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

    @Override
    public final Integer transform(final DiceOperand operand,
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
