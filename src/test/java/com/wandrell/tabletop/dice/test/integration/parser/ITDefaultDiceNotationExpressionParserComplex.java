/**
 * Copyright 2014-2017 the original author or authors
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

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.operand.DiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses complex operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDefaultDiceNotationExpressionParserComplex
        extends AbstractITDefaultDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserComplex() {
        super();
    }

    /**
     * Tests that a complex operation is parsed correctly.
     */
    @Test
    public final void testParse_Complex() {
        final SubtractionOperation operationFirst;
        final AdditionOperation operationSecond;
        final IntegerOperand integer;
        final DiceOperand leftDice;
        final DiceOperand rightDice;
        final String notation;

        notation = "1d20-5+2d6";

        operationFirst = (SubtractionOperation) parse(notation);

        leftDice = (DiceOperand) operationFirst.getLeft();
        operationSecond = (AdditionOperation) operationFirst.getRight();

        integer = (IntegerOperand) operationSecond.getLeft();
        rightDice = (DiceOperand) operationSecond.getRight();

        // Leftmost dice was parsed correctly
        Assert.assertEquals(leftDice.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(leftDice.getDice().getSides(), (Integer) 20);

        // Rightmost dice was parsed correctly
        Assert.assertEquals(rightDice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(rightDice.getDice().getSides(), (Integer) 6);

        // Integer value was parsed correctly
        Assert.assertEquals(integer.getValue(), (Integer) 5);
    }

}
