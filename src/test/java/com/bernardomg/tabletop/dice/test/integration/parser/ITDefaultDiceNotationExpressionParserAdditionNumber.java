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

import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses numeric additions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserAdditionNumber {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserAdditionNumber() {
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
        final BinaryOperation right;     // Parsed right set

        notation = "1+2+3";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals(
                new RollerTransformer().transform(operation.getLeft()),
                (Integer) 1);

        right = (BinaryOperation) operation.getRight();
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(right.getLeft()));
        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(right.getRight()));
    }

    /**
     * Verifies that long additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Long_Value() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation

        notation = "1+2+3";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 6,
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that longer additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Longer_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        BinaryOperation value;

        notation = "1+2+3+4+5";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        value = (BinaryOperation) operation.getRight();
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(value.getLeft()));

        value = (BinaryOperation) value.getRight();
        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(value.getLeft()));

        value = (BinaryOperation) value.getRight();
        Assertions.assertEquals((Integer) 4,
                new RollerTransformer().transform(value.getLeft()));
        Assertions.assertEquals((Integer) 5,
                new RollerTransformer().transform(value.getRight()));
    }

    /**
     * Verifies that longer additions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Add_Longer_Value() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        BinaryOperation value;

        notation = "1+2+3+4+5";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 15,
                new RollerTransformer().transform(operation));

        value = (BinaryOperation) operation.getRight();
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(value.getLeft()));

        value = (BinaryOperation) value.getRight();
        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(value.getLeft()));

        value = (BinaryOperation) value.getRight();
        Assertions.assertEquals((Integer) 4,
                new RollerTransformer().transform(value.getLeft()));
        Assertions.assertEquals((Integer) 5,
                new RollerTransformer().transform(value.getRight()));
    }

    /**
     * Verifies that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add_Structure() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation

        notation = "1+2";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 1,
                new RollerTransformer().transform(operation.getLeft()));
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(operation.getRight()));
    }

    /**
     * Verifies that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add_Value() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation

        notation = "1+2";

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(operation));
    }

}
