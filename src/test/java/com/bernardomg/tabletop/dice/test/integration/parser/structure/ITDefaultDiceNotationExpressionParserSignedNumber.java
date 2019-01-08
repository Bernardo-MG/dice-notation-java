/**
 * Copyright 2014-2018 the original author or authors
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
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses signed numbers.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSignedNumber {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSignedNumber() {
        super();
    }

    /**
     * Verifies that parsing a signed positive number gives that number as
     * value.
     */
    @Test
    public final void testParse_Positive() {
        final AdditionOperation operation; // Parsed expression
        final IntegerOperand left;         // Left operand
        final IntegerOperand right;        // Right operand

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse("+12").getRoot();

        left = (IntegerOperand) operation.getLeft();
        right = (IntegerOperand) operation.getRight();

        // +12 = 0+12
        Assertions.assertEquals(new Integer(0), left.getValue());
        Assertions.assertEquals(new Integer(12), right.getValue());
    }

    /**
     * Verifies that parsing a signed negative number gives that number as
     * value.
     */
    @Test
    public final void testParse_Negative() {
        final SubtractionOperation operation; // Parsed expression
        final IntegerOperand left;            // Left operand
        final IntegerOperand right;           // Right operand

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse("-12").getRoot();

        left = (IntegerOperand) operation.getLeft();
        right = (IntegerOperand) operation.getRight();

        // -12 = 0-12
        Assertions.assertEquals(new Integer(0), left.getValue());
        Assertions.assertEquals(new Integer(12), right.getValue());
    }

}
