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

import java.util.Objects;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Wraps an expression to hide its type. Used for example when pruning a tree,
 * to create a node without children.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class ExpressionWrapper implements DiceNotationExpression {

    /**
     * Wrapped expression.
     */
    private final DiceNotationExpression wrappedExpression;

    /**
     * Constructs a wrapper for the received expression.
     * 
     * @param exp
     *            the expression to wrap
     */
    public ExpressionWrapper(final DiceNotationExpression exp) {
        super();

        wrappedExpression = Objects.requireNonNull(exp,
                "Received a null pointer as expression");
    }

    @Override
    public final String getExpression() {
        return wrappedExpression.getExpression();
    }

    /**
     * Returns the wrapped expression.
     * 
     * @return the wrapped expression
     */
    public final DiceNotationExpression getWrappedExpression() {
        return wrappedExpression;
    }

}
