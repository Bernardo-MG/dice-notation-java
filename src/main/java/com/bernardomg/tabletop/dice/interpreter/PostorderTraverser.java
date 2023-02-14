/**
 * Copyright 2014-2022 the original author or authors
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

package com.bernardomg.tabletop.dice.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

import lombok.extern.slf4j.Slf4j;

/**
 * Breaks down the received expression into a postorder list.
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code 1 2 + 3 -} with this transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Slf4j
public final class PostorderTraverser implements DiceInterpreter<Iterable<DiceNotationExpression>> {

    /**
     * Default constructor.
     */
    public PostorderTraverser() {
        super();
    }

    @Override
    public final Iterable<DiceNotationExpression> transform(final DiceNotationExpression expression) {
        final Stack<DiceNotationExpression>      nodes;
        final Collection<DiceNotationExpression> exps;
        DiceNotationExpression                   current;

        Objects.requireNonNull(expression, "Received a null pointer as expression");

        nodes = new Stack<>();
        nodes.push(expression);

        exps = new ArrayList<>();
        while (!nodes.isEmpty()) {
            current = nodes.pop();
            log.debug("Transforming current node {}", current);
            if (current instanceof BinaryOperation) {
                // Binary operation
                // Temporally prunes node and stores left and right nodes
                log.trace("The current node is a binary node");
                log.trace("Pushing node and branches into stack");
                nodes.push(new ExpressionWrapper(current));
                nodes.push(((BinaryOperation) current).getRight());
                nodes.push(((BinaryOperation) current).getLeft());
            } else {
                // Leaf node
                log.trace("The current node is a leaf node");
                log.debug("Stored current node {} into return", current);
                exps.add(current);
            }
        }

        // Recovers pruned nodes
        return exps.stream()
            .map(this::unwrap)
            .collect(Collectors.toList());
    }

    /**
     * Removes the expression wrappers used to temporally prune the nodes.
     *
     * @param expression
     *            node to unwrap
     * @return unwrapped node
     */
    private final DiceNotationExpression unwrap(final DiceNotationExpression expression) {
        final DiceNotationExpression result;

        if (expression instanceof ExpressionWrapper) {
            result = ((ExpressionWrapper) expression).getWrappedExpression();
        } else {
            result = expression;
        }

        return result;
    }

}
