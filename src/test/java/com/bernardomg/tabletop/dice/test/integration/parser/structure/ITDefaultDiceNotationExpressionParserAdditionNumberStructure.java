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
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DefaultDiceParser}, verifying
 * that it parses numeric additions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserAdditionNumberStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserAdditionNumberStructure() {
        super();
    }

    /**
     * Verifies that long additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Long_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        AdditionOperation add;
        IntegerOperand number;

        notation = "1+2+3";

        // ((1+2)+3)
        operation = (AdditionOperation) new DefaultDiceParser()
                .parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        add = (AdditionOperation) operation.getLeft();

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) add.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that longer additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Longer_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        AdditionOperation add;
        IntegerOperand number;

        notation = "1+2+3+4+5";

        // ((((1+2)+3)+4)+5)
        operation = (AdditionOperation) new DefaultDiceParser()
                .parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 5, number.getValue());

        add = (AdditionOperation) operation.getLeft();

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 4, number.getValue());

        add = (AdditionOperation) add.getLeft();

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        add = (AdditionOperation) add.getLeft();

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) add.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        IntegerOperand number;

        notation = "1+2";

        // (1+2)
        operation = (AdditionOperation) new DefaultDiceParser()
                .parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) operation.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

}
