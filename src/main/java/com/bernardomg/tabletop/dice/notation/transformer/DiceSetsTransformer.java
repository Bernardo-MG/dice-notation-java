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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.google.common.collect.Iterables;

public class DiceSetsTransformer
        implements DiceNotationTransformer<Iterable<Dice>> {

    public DiceSetsTransformer() {
        super();
    }

    @Override
    public final Iterable<Dice> transform(final BinaryOperation operation) {
        final Collection<Dice> result;
        final Iterable<Dice> left;
        final Iterable<Dice> right;

        left = transform(operation.getLeft());
        right = transform(operation.getRight());

        result = new ArrayList<>();
        Iterables.addAll(result, left);
        Iterables.addAll(result, right);

        return result;
    }

    @Override
    public final Iterable<Dice> transform(final ConstantOperand operand) {
        return Collections.emptyList();
    }

    @Override
    public final Iterable<Dice>
            transform(final DiceNotationExpression expression) {
        final Iterable<Dice> result;
        // TODO: Avoid casting

        if (expression instanceof DiceOperand) {
            result = transform((DiceOperand) expression);
        } else {
            result = Collections.emptyList();
        }

        return result;
    }

    @Override
    public final Iterable<Dice> transform(final DiceOperand operand) {
        return Arrays.asList(operand.getDice());
    }

}
