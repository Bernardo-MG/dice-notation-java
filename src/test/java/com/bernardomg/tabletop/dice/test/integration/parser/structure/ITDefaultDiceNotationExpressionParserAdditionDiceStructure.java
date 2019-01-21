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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@link DefaultDiceNotationExpressionParser}, verifying
 * that it parses additions with dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserAdditionDiceStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserAdditionDiceStructure() {
        super();
    }

    /**
     * Verifies that an addition using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Add_Dice_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final DiceOperand diceLeft;        // Left parsed dice
        final DiceOperand diceRight;       // Right parsed dice

        notation = "1d20+2d6";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assertions.assertEquals((Integer) 1, diceLeft.getDice().getQuantity());
        Assertions.assertEquals((Integer) 20, diceLeft.getDice().getSides());

        Assertions.assertEquals((Integer) 2, diceRight.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, diceRight.getDice().getSides());
    }

    /**
     * Verifies that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_LeftNumber_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand integer;      // Parsed integer
        final DiceOperand dice;            // Parsed dice

        notation = "5+2d6";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        dice = (DiceOperand) operation.getRight();
        integer = (IntegerOperand) operation.getLeft();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

    /**
     * Verifies that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_RightNumber_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand integer;      // Parsed integer
        final DiceOperand dice;            // Parsed dice

        notation = "2d6+5";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

}
