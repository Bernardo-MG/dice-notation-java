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

package com.bernardomg.tabletop.dice;

import java.util.Objects;

/**
 * Immutable group of dice.
 * <p>
 * Some basic constraints are applied to the dice values. The quantity should be equal or higher than zero, and the
 * number of sides equal or higher than one. If any other value is received then an exception will be thrown.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final record DefaultDice(Integer quantity, Integer sides) implements Dice {

    public DefaultDice(final Integer quantity, final Integer sides) {
        this.quantity = Objects.requireNonNull(quantity, "Received a null pointer as quantity");
        this.sides = Objects.requireNonNull(sides, "Received a null pointer as sides");
    }

    @Override
    public final Integer getQuantity() {
        return quantity;
    }

    @Override
    public final Integer getSides() {
        return sides;
    }

}
