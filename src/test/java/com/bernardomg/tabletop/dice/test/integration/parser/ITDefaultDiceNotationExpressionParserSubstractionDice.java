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
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses substractions with dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSubstractionDice {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSubstractionDice() {
        super();
    }

    /**
     * Verifies that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final DiceOperand diceLeft;      // Left parsed dice
        final DiceOperand diceRight;     // Right parsed dice

        notation = "1d20-2d6";

        operation = (BinaryOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assertions.assertEquals((Integer) 1, diceLeft.getDice().getQuantity());
        Assertions.assertEquals((Integer) 20, diceLeft.getDice().getSides());

        Assertions.assertEquals((Integer) 2, diceRight.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, diceRight.getDice().getSides());
    }

    /**
     * Verifies that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final IntegerOperand integer;    // Integer operand
        final DiceOperand dice;          // Dice operand

        notation = "5-2d6";

        operation = (BinaryOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation);

        integer = (IntegerOperand) operation.getLeft();
        dice = (DiceOperand) operation.getRight();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

    /**
     * Verifies that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final IntegerOperand integer;    // Integer operand
        final DiceOperand dice;          // Dice operand

        notation = "2d6-5";

        operation = (BinaryOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

}
