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

package com.bernardomg.tabletop.dice.notation.operand;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * Operand for using {@link Dice} as value.
 * <p>
 * Due to the nature of dice this will represent a random value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DiceOperand extends DiceNotationExpression {

    /**
     * Returns the operand dice.
     * 
     * @return the operand dice
     */
    public Dice getDice();

}
