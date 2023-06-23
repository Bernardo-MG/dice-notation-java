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

import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for subtractions using only numbers")
public final class ITDefaultDiceParserSubstractionNumberStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceParserSubstractionNumberStructure() {
        super();
    }

    @Test
    @DisplayName("A long subtraction returns the expected structure")
    public final void testParse_Number_Sub_Long_Structure() {
        final String               notation;  // Input to parse
        final SubtractionOperation operation; // Parsed operation
        SubtractionOperation       sub;
        IntegerOperand             number;

        notation = "1-2-3";

        // ((1-2)-3)
        operation = (SubtractionOperation) new DefaultDiceParser().parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(3);

        sub = (SubtractionOperation) operation.getLeft();

        number = (IntegerOperand) sub.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(2);

        number = (IntegerOperand) sub.getLeft();
        Assertions.assertThat(number.getValue())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("A longer subtraction returns the expected structure")
    public final void testParse_Number_Sub_Longer_Structure() {
        final String               notation;  // Input to parse
        final SubtractionOperation operation; // Parsed operation
        SubtractionOperation       sub;
        IntegerOperand             number;

        notation = "1-2-3-4-5";

        // ((((1-2)-3)-4)-5)
        operation = (SubtractionOperation) new DefaultDiceParser().parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(5);

        sub = (SubtractionOperation) operation.getLeft();

        number = (IntegerOperand) sub.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(4);

        sub = (SubtractionOperation) sub.getLeft();

        number = (IntegerOperand) sub.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(3);

        sub = (SubtractionOperation) sub.getLeft();

        number = (IntegerOperand) sub.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(2);

        number = (IntegerOperand) sub.getLeft();
        Assertions.assertThat(number.getValue())
            .isEqualTo(1);
    }

    @Test
    @DisplayName("A subtraction returns the expected structure")
    public final void testParse_Number_Sub_Structure() {
        final String               notation;  // Input to parse
        final SubtractionOperation operation; // Parsed operation
        IntegerOperand             number;

        notation = "1-2";

        operation = (SubtractionOperation) new DefaultDiceParser().parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertThat(number.getValue())
            .isEqualTo(2);

        number = (IntegerOperand) operation.getLeft();
        Assertions.assertThat(number.getValue())
            .isEqualTo(1);
    }

}
