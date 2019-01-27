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

package com.bernardomg.tabletop.dice.notation.operation;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.BiFunction;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Abstract class for operations, containing the operation, stored as a
 * {@link BiFunction}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultOperation implements Operation {

    /**
     * Operation to apply.
     */
    private final BiFunction<Integer, Integer, Integer> operation;

    /**
     * Constructs a subtraction operation with the specified operands.
     * 
     * @param func
     *            operation to apply
     */
    public DefaultOperation(final BiFunction<Integer, Integer, Integer> func) {
        super();

        operation = checkNotNull(func, "Received a null pointer as operation");
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DefaultOperation other;

        other = (DefaultOperation) obj;

        return Objects.equal(operation, other.operation);
    }

    @Override
    public final String getExpression() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final BiFunction<Integer, Integer, Integer> getOperation() {
        return operation;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(operation);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("operation", operation)
                .toString();
    }

}
