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

import java.util.function.BiFunction;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

/**
 * A binary operation for the dice notation.
 * <p>
 * Binary operation work with pairs of operands. These operands are other
 * expressions, which allow chaining the values in the tree.
 * <p>
 * Depending on the operation, the order of the operands may be of importance or
 * not.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface BinaryOperation extends DiceNotationExpression {

    /**
     * Returns the left sided operand.
     * 
     * @return the left sided operand
     */
    public DiceNotationExpression getLeft();

    /**
     * Returns the operation to apply.
     * 
     * @return the operation
     */
    public BiFunction<Integer, Integer, Integer> getOperation();

    /**
     * Returns the right sided operand.
     * 
     * @return the right sided operand
     */
    public DiceNotationExpression getRight();

}
