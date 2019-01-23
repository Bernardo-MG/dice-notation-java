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
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DefaultDiceParser}, verifying
 * that it parses numbers.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserNumberStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserNumberStructure() {
        super();
    }

    /**
     * Verifies that parsing a positive number gives that number as value.
     */
    @Test
    public final void testParse() {
        final IntegerOperand value;

        value = (IntegerOperand) new DefaultDiceParser()
                .parse("12");

        Assertions.assertEquals((Integer) 12, value.getValue());
    }

    /**
     * Verifies that parsing zero gives that number as value.
     */
    @Test
    public final void testParse_Zero() {
        final IntegerOperand value;

        value = (IntegerOperand) new DefaultDiceParser()
                .parse("0");

        Assertions.assertEquals((Integer) 0, value.getValue());
    }

}
