/**
 * Copyright 2014-2023 the original author or authors
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
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for complex operations")
public final class ITDefaultDiceParserComplexStructure {

    public ITDefaultDiceParserComplexStructure() {
        super();
    }

    @Test
    @DisplayName("A complex operation returns the expected structure")
    public final void testParse_Complex_Structure() {
        final AdditionOperation    operationFirst;
        final SubtractionOperation operationSecond;
        final IntegerOperand       integer;
        final DiceOperand          leftDice;
        final DiceOperand          rightDice;
        final String               notation;

        notation = "1d20-5+2d6";

        // ((1d20-5)+2d6)
        operationFirst = (AdditionOperation) new DefaultDiceParser().parse(notation);

        operationSecond = (SubtractionOperation) operationFirst.getLeft();
        rightDice = (DiceOperand) operationFirst.getRight();

        leftDice = (DiceOperand) operationSecond.getLeft();
        integer = (IntegerOperand) operationSecond.getRight();

        // Leftmost dice was parsed correctly
        Assertions.assertThat(rightDice.getDice()
            .getQuantity())
            .isEqualTo(2);
        Assertions.assertThat(rightDice.getDice()
            .getSides())
            .isEqualTo(6);

        // Rightmost dice was parsed correctly
        Assertions.assertThat(leftDice.getDice()
            .getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(leftDice.getDice()
            .getSides())
            .isEqualTo(20);

        // Integer value was parsed correctly
        Assertions.assertThat(integer.getValue())
            .isEqualTo(5);
    }

}
