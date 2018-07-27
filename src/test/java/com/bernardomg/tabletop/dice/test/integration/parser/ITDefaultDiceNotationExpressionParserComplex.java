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

package com.bernardomg.tabletop.dice.test.integration.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses complex operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
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
        Assertions.assertEquals(leftDice.getDice().getQuantity(), (Integer) 1);
        Assertions.assertEquals(leftDice.getDice().getSides(), (Integer) 20);

        // Rightmost dice was parsed correctly
        Assertions.assertEquals(rightDice.getDice().getQuantity(), (Integer) 2);
        Assertions.assertEquals(rightDice.getDice().getSides(), (Integer) 6);

        // Integer value was parsed correctly
        Assertions.assertEquals(integer.getValue(), (Integer) 5);
    }

}