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
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses signed numbers.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSignedNumberStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSignedNumberStructure() {
        super();
    }

    /**
     * Verifies that parsing a signed negative number gives that number as
     * value.
     */
    @Test
    public final void testParse_Negative() {
        final IntegerOperand operation; // Parsed expression

        operation = (IntegerOperand) new DefaultDiceNotationExpressionParser()
                .parse("-12").getRoot();

        Assertions.assertEquals(new Integer(0 - 12), operation.getValue());
    }

    /**
     * Verifies that parsing a signed positive number gives that number as
     * value.
     */
    @Test
    public final void testParse_Positive() {
        final IntegerOperand operation; // Parsed expression

        operation = (IntegerOperand) new DefaultDiceNotationExpressionParser()
                .parse("+12").getRoot();

        Assertions.assertEquals(new Integer(12), operation.getValue());
    }

}
