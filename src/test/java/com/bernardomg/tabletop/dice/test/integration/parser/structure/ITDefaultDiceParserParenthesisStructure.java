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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for operations with parenthesis")
public final class ITDefaultDiceParserParenthesisStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceParserParenthesisStructure() {
        super();
    }

    @Test
    @DisplayName("An operation with parenthesis returns the expected structure")
    public final void testParse_Number_AddAndMult_Structure() {
        final String            notation;  // Input to parse
        final BinaryOperation   operation; // Parsed operation
        final AdditionOperation add;
        IntegerOperand          number;

        notation = "(1+2)*3";

        // ((1+2)*3)
        operation = (MultiplicationOperation) new DefaultDiceParser().parse(notation);

        add = (AdditionOperation) operation.getLeft();

        number = (IntegerOperand) add.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());
    }

}
