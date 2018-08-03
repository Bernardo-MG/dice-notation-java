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

import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses numeric substractions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSubstractionNumber {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSubstractionNumber() {
        super();
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation
        final SubtractionOperation value;     // Parsed right operation

        notation = "1-2-3";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 1,
                new RollerTransformer().transform(operation.getLeft()));

        value = (SubtractionOperation) operation.getRight();
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(value.getLeft()));
        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(value.getRight()));
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long_Value() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation

        notation = "1-2-3";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) (-4),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation
        SubtractionOperation value;           // Parsed sub operations

        notation = "1-2-3-4-5";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        value = (SubtractionOperation) operation.getRight();
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(value.getLeft()));

        value = (SubtractionOperation) value.getRight();
        Assertions.assertEquals((Integer) 3,
                new RollerTransformer().transform(value.getLeft()));

        value = (SubtractionOperation) value.getRight();
        Assertions.assertEquals((Integer) 4,
                new RollerTransformer().transform(value.getLeft()));
        Assertions.assertEquals((Integer) 5,
                new RollerTransformer().transform(value.getRight()));
    }

    /**
     * Verifies that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer_Value() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation

        notation = "1-2-3-4-5";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) (-11),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation

        notation = "1-2";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) 1,
                new RollerTransformer().transform(operation.getLeft()));
        Assertions.assertEquals((Integer) 2,
                new RollerTransformer().transform(operation.getRight()));
    }

    /**
     * Verifies that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub_Value() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation

        notation = "1-2";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        Assertions.assertEquals((Integer) (-1),
                new RollerTransformer().transform(operation));
    }

}
