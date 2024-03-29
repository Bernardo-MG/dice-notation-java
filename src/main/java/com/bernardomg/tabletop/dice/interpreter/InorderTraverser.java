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

package com.bernardomg.tabletop.dice.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Stack;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

import lombok.extern.slf4j.Slf4j;

/**
 * Breaks down the received expression into an inorder list.
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code 1 + 2 - 3} with this transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Slf4j
public final class InorderTraverser implements DiceInterpreter<Iterable<DiceNotationExpression>> {

    /**
     * Default constructor.
     */
    public InorderTraverser() {
        super();
    }

    @Override
    public final Iterable<DiceNotationExpression> transform(final DiceNotationExpression expression) {
        final Stack<DiceNotationExpression>      nodes;
        final Collection<DiceNotationExpression> exps;
        DiceNotationExpression                   current;

        Objects.requireNonNull(expression, "Received a null pointer as expression");

        current = expression;

        nodes = new Stack<>();
        exps = new ArrayList<>();
        while ((!nodes.isEmpty()) || (current != null)) {
            log.debug("Transforming current node {}", current);
            if (current == null) {
                // Left nodes exhausted
                // Moves to the previous right node
                current = nodes.pop();
                log.debug("No current node. Recovered {} from stack", current);

                // This is the next node for inorder traverse
                log.debug("Stored current node {} into return", current);
                exps.add(current);

                if (current instanceof BinaryOperation) {
                    // Moves to a right node
                    current = ((BinaryOperation) current).getRight();
                    log.trace("Moved to right node {}", current);
                } else {
                    // Not binary node
                    // There is no right node
                    current = null;
                }
            } else {
                // Store and keep moving
                nodes.push(current);
                log.trace("Pushed node into stack");
                if (current instanceof BinaryOperation) {
                    // Next left node
                    current = ((BinaryOperation) current).getLeft();
                    log.trace("Moved to left node {}", current);
                } else {
                    // Not binary node
                    // There is no left node
                    current = null;
                }
            }
        }

        return exps;
    }

}
