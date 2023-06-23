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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for additions")
public final class ITDefaultDiceParserAdditionDiceStructure {

    public ITDefaultDiceParserAdditionDiceStructure() {
        super();
    }

    @Test
    @DisplayName("An addition returns the expected structure")
    public final void testParse_Dice_Structure() {
        final String            notation;  // Input to parse
        final AdditionOperation operation; // Parsed operation
        final DiceOperand       diceLeft;  // Left parsed dice
        final DiceOperand       diceRight; // Right parsed dice

        notation = "1d20+2d6";

        operation = (AdditionOperation) new DefaultDiceParser().parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assertions.assertThat(diceLeft.getDice()
            .getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(diceLeft.getDice()
            .getSides())
            .isEqualTo(20);

        Assertions.assertThat(diceRight.getDice()
            .getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(diceRight.getDice()
            .getSides())
            .isEqualTo(6);
    }

    @Test
    @DisplayName("An addition with a number on the left returns the expected structure")
    public final void testParse_LeftNumber_Structure() {
        final String            notation;  // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand    integer;   // Parsed integer
        final DiceOperand       dice;      // Parsed dice

        notation = "5+2d6";

        operation = (AdditionOperation) new DefaultDiceParser().parse(notation);

        dice = (DiceOperand) operation.getRight();
        integer = (IntegerOperand) operation.getLeft();

        Assertions.assertThat(dice.getDice()
            .getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getDice()
            .getSides())
            .isEqualTo(6);

        Assertions.assertThat(integer.getValue())
            .isEqualTo(5);
    }

    @Test
    @DisplayName("An addition with a number on the right returns the expected structure")
    public final void testParse_RightNumber_Structure() {
        final String            notation;  // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand    integer;   // Parsed integer
        final DiceOperand       dice;      // Parsed dice

        notation = "2d6+5";

        operation = (AdditionOperation) new DefaultDiceParser().parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assertions.assertThat(dice.getDice()
            .getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(dice.getDice()
            .getSides())
            .isEqualTo(6);

        Assertions.assertThat(integer.getValue())
            .isEqualTo(5);
    }

}
