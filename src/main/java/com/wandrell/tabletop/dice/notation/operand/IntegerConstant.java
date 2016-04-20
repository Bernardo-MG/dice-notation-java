/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.notation.operand;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;

public final class IntegerConstant implements DiceExpressionComponent, Operand {

    private final Integer value;

    public IntegerConstant(final Integer value) {
        super();

        this.value = value;
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

        final IntegerConstant other;

        other = (IntegerConstant) obj;

        return Objects.equal(value, other.value);
    }

    @Override
    public final String getStringRepresentation() {
        return getValue().toString();
    }

    @Override
    public final Integer getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("value", value).toString();
    }

}
