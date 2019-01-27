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
 * An operation for the dice notation.
 * <p>
 * It stores just the operation itself, with no operands. This is useful when
 * processing the notation tree, to transform a more complex operation into a
 * leaf node.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface Operation extends DiceNotationExpression {

    /**
     * Returns the operation to apply.
     * 
     * @return the operation
     */
    public BiFunction<Integer, Integer, Integer> getOperation();

}
