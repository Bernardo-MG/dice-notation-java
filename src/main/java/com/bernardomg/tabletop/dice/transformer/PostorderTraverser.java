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

package com.bernardomg.tabletop.dice.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

/**
 * Breaks down the received expression into a postorder list.
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code 1 2 + 3 -} with this
 * transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class PostorderTraverser
        implements DiceInterpreter<Iterable<DiceNotationExpression>> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PostorderTraverser.class);

    /**
     * Default constructor.
     */
    public PostorderTraverser() {
        super();
    }

    @Override
    public final Iterable<DiceNotationExpression>
            transform(final DiceNotationExpression expression) {
        final Stack<DiceNotationExpression> nodes;
        final Collection<DiceNotationExpression> exps;
        DiceNotationExpression current;

        checkNotNull(expression, "Received a null pointer as expression");

        nodes = new Stack<>();
        nodes.push(expression);

        exps = new ArrayList<>();
        while (!nodes.isEmpty()) {
            current = nodes.pop();
            LOGGER.debug("Transforming expression {}", current);
            if (current instanceof BinaryOperation) {
                // Binary operation
                // Prunes node and stores left and right nodes
                nodes.push(new ExpressionWrapper(current));
                nodes.push(((BinaryOperation) current).getRight());
                nodes.push(((BinaryOperation) current).getLeft());
            } else {
                // Leaf node
                exps.add(current);
            }
        }

        return exps.stream().map(this::unwrap).collect(Collectors.toList());
    }

    private final DiceNotationExpression
            unwrap(final DiceNotationExpression expression) {
        final DiceNotationExpression result;

        if (expression instanceof ExpressionWrapper) {
            result = ((ExpressionWrapper) expression).getWrappedExpression();
        } else {
            result = expression;
        }

        return result;
    }

}
