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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpressionRoot;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.google.common.collect.Iterables;

public final class DiceSetsTransformer
        implements DiceNotationTransformer<Iterable<Dice>> {

    public DiceSetsTransformer() {
        super();
    }

    @Override
    public final Iterable<Dice>
            transform(final DiceNotationExpression expression) {
        return transform(expression, Collections.emptyList());
    }

    private final Iterable<Dice> transform(final BinaryOperation operation,
            final Iterable<Dice> accumulated) {
        final Iterable<Dice> left;
        final Iterable<Dice> right;
        final Collection<Dice> result;

        left = transform(operation.getLeft(), accumulated);
        right = transform(operation.getRight(), accumulated);
        result = new ArrayList<>();
        Iterables.addAll(result, left);
        Iterables.addAll(result, right);

        return result;
    }

    private final Iterable<Dice> transform(
            final DiceNotationExpression expression,
            final Iterable<Dice> accumulated) {
        final Iterable<Dice> result;
        // TODO: Avoid casting

        if (expression instanceof DiceNotationExpressionRoot) {
            result = transform(
                    ((DiceNotationExpressionRoot) expression).getRoot());
        } else if (expression instanceof BinaryOperation) {
            result = transform((BinaryOperation) expression, accumulated);
        } else if (expression instanceof DiceOperand) {
            result = transform((DiceOperand) expression,
                    Collections.emptyList());
        } else {
            result = Collections.emptyList();
        }

        return result;
    }

    private final Iterable<Dice> transform(final DiceOperand operand,
            final Iterable<Dice> accumulated) {
        final Collection<Dice> result;

        result = new ArrayList<>();
        Iterables.addAll(result, accumulated);
        result.add(operand.getDice());

        return result;
    }

}
