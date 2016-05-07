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

package com.wandrell.tabletop.dice.test.integration.notation.operand;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Integration tests for {@link AdditionOperation}, checking that it works as
 * expected with its operands.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The text expression is generated correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITTextExpressionAdditionOperation {

    /**
     * Default constructor.
     */
    public ITTextExpressionAdditionOperation() {
        super();
    }

    /**
     * Tests that the text expression is generated correctly.
     */
    @Test
    public final void testTextExpression() {
        final BinaryOperation operation;          // Tested operation
        final DiceNotationExpression diceOperand; // Dice operand
        final DiceNotationExpression intOperand;  // Integer operand
        final Dice dice;                          // Dice for the operand

        dice = new DefaultDice(2, 6);

        diceOperand = new DefaultDiceOperand(dice, new DefaultRoller());
        intOperand = new IntegerOperand(5);

        operation = new AdditionOperation(diceOperand, intOperand);

        Assert.assertEquals(operation.getExpression(), "2d6+5");
    }

}
