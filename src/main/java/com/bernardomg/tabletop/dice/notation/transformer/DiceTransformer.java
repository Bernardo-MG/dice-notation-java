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

package com.bernardomg.tabletop.dice.notation.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.google.common.collect.Iterables;

/**
 * Dice notation expression which returns all the dice sets contained inside the
 * expression.
 * <p>
 * This will search for dice operands, and acquire the dice inside of them.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceTransformer
        implements DiceNotationTransformer<Iterable<Dice>> {

    /**
     * Default constructor.
     */
    public DiceTransformer() {
        super();
    }

    @Override
    public final Iterable<Dice>
            transform(final DiceNotationExpression expression) {
        final Iterable<Dice> result;
        // TODO: Avoid casting

        if (expression instanceof TransformableDiceNotationExpression) {
            result = transform(
                    ((TransformableDiceNotationExpression) expression)
                            .getRoot());
        } else if (expression instanceof BinaryOperation) {
            result = transform((BinaryOperation) expression);
        } else if (expression instanceof DiceOperand) {
            result = transform((DiceOperand) expression);
        } else {
            result = Collections.emptyList();
        }

        return result;
    }

    /**
     * Transforms a binary operation into an {@code Iterable}.
     * <p>
     * Both sides of the operation will be transformed, and then the results are
     * stored into the resulting {@code Iterable}.
     * 
     * @param operation
     *            operation to transform
     * @return an {@code Iterable} with the dice from the operation
     */
    private final Iterable<Dice> transform(final BinaryOperation operation) {
        final Iterable<Dice> left;     // Left operand transformed
        final Iterable<Dice> right;    // Right operand transformed
        final Collection<Dice> result; // All the dice from the operation

        left = transform(operation.getLeft());
        right = transform(operation.getRight());

        result = new ArrayList<>();
        Iterables.addAll(result, left);
        Iterables.addAll(result, right);

        return result;
    }

    /**
     * Transforms a dice operand into an {@code Iterable}, by storing the
     * contained dice into a list.
     * 
     * @param operand
     *            operand to transform
     * @return an {@code Iterable} with the dice from the operand
     */
    private final Iterable<Dice> transform(final DiceOperand operand) {
        return Arrays.asList(operand.getDice());
    }

}
