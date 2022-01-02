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

package com.bernardomg.tabletop.dice.notation;

/**
 * A dice notation expression.
 * <p>
 * This is the root interface for specifying a dice notation expression,
 * implementations will add methods as they need.
 * <p>
 * It is also possible getting the string representation of the dice notation
 * expression it represents.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface DiceNotationExpression {

    /**
     * Returns the expression as a string.
     * <p>
     * This will be the dice expression as it is written, for example "2+1d6".
     * 
     * @return the expression as a string
     */
    public String getExpression();

}
