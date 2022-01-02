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

package com.bernardomg.tabletop.dice.visitor;

import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

/**
 * Visitor for dice notation expressions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface NotationVisitor {

    /**
     * Visits a binary operation.
     * 
     * @param exp
     *            expression to visit
     */
    public void binaryOperation(final BinaryOperation exp);

    /**
     * Visits a constant.
     * 
     * @param exp
     *            expression to visit
     */
    public void constantOperand(final ConstantOperand exp);

    /**
     * Visits a dice.
     * 
     * @param exp
     *            expression to visit
     */
    public void diceOperand(final DiceOperand exp);

}
