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

package com.wandrell.tabletop.dice.test.unit.notation.formula;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DefaultDiceExpressionRoot;
import com.wandrell.tabletop.dice.notation.DiceExpressionRoot;
import com.wandrell.tabletop.dice.notation.operand.DefaultDiceExpression;
import com.wandrell.tabletop.dice.notation.operand.DiceNotationOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerExpression;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

public final class TestStringRepresentationDefaultDiceFormula {

    public TestStringRepresentationDefaultDiceFormula() {
        super();
        // TODO: Use mocks
    }

    @Test
    public final void testGetStringRepresentation_Addition() {
        final DiceExpressionRoot formula;
        final Dice dice;
        final DiceNotationOperand diceOperand;
        final DiceNotationOperand intOperand;
        final BinaryOperation operation;

        dice = new DefaultDice(2, 6);

        diceOperand = new DefaultDiceExpression(dice, new DefaultRoller());
        intOperand = new IntegerExpression(5);

        operation = new AdditionOperation(diceOperand, intOperand);

        formula = new DefaultDiceExpressionRoot();

        formula.addDiceNotationComponent(operation);

        Assert.assertEquals(formula.getStringRepresentation(), "2d6+5");
    }

    @Test
    public final void testGetStringRepresentation_Substraction() {
        final DiceExpressionRoot formula;
        final Dice dice;
        final DiceNotationOperand diceOperand;
        final DiceNotationOperand intOperand;
        final BinaryOperation operation;

        dice = new DefaultDice(2, 6);

        diceOperand = new DefaultDiceExpression(dice, new DefaultRoller());
        intOperand = new IntegerExpression(5);

        operation = new SubstractionOperation(diceOperand, intOperand);

        formula = new DefaultDiceExpressionRoot();

        formula.addDiceNotationComponent(operation);

        Assert.assertEquals(formula.getStringRepresentation(), "2d6-5");
    }

}
