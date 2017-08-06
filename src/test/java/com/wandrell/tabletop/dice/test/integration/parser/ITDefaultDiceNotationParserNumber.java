/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;

/**
 * Integration tests for {@code DefaultDiceNotationParser}, checking that it
 * parses numbers.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITDefaultDiceNotationParserNumber
        extends AbstractITDefaultDiceNotationParser {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationParserNumber() {
        super();
    }

    /**
     * Tests that parsing a positive number gives that number as value.
     */
    @Test
    public final void testParse_Positive_Value() {
        final IntegerOperand value;

        value = (IntegerOperand) parse("12");

        Assert.assertEquals(value.getValue(), (Integer) 12);
    }

    /**
     * Tests that parsing zero gives that number as value.
     */
    @Test
    public final void testParse_Zero() {
        final IntegerOperand value;

        value = (IntegerOperand) parse("0");

        Assert.assertEquals(value.getValue(), (Integer) 0);
    }

}
