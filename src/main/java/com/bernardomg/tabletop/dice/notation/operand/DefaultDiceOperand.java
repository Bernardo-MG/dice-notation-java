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

package com.bernardomg.tabletop.dice.notation.operand;

import com.bernardomg.tabletop.dice.Dice;

/**
 * Default implementation of the dice operand.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final record DefaultDiceOperand(Dice dice) implements DiceOperand {

    @Override
    public final String getExpression() {
        return String.format("%dd%d", getDice().getQuantity(), getDice().getSides());
    }

    @Override
    public final Dice getDice() {
        return dice;
    }

}
