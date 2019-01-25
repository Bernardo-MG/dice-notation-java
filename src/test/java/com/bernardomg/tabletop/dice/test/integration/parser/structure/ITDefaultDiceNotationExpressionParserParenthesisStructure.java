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

import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DefaultDiceParser}, verifying that it parses
 * simple binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserParenthesisStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserParenthesisStructure() {
        super();
    }

    /**
     * Verifies that parenthesis are applied, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_AddAndMult_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final AdditionOperation add;
        IntegerOperand number;

        notation = "(1+2)*3";

        // ((1+2)*3)
        operation = (MultiplicationOperation) new DefaultDiceParser()
                .parse(notation);

        add = (AdditionOperation) operation.getLeft();

        number = (IntegerOperand) add.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());
    }

}