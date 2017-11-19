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

package com.bernardomg.bernardomg.dice.test.integration.parser;

import org.testng.annotations.Test;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it throws exceptions when required.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDefaultDiceNotationExpressionParserException
        extends AbstractITDefaultDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserException() {
        super();
    }

    /**
     * Tests that an empty text throws an exception.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testParse_Empty() {
        parse("");
    }

    /**
     * Tests that an invalid text throws an exception.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testParse_Invalid() {
        parse("abc");
    }

    /**
     * Tests that a negative value throws an exception.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_Negative() {
        parse("-1");
    }

    /**
     * Tests that dice notation with zero sides throws an exception.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_ZeroSides() {
        parse("1d0");
    }

}
