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
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it throws exceptions when required.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
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
    @Test
    public final void testParse_Empty() {
        final Executable closure;

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                parse("");
            }

        };

        Assertions.assertThrows(Exception.class, closure);
    }

    /**
     * Tests that an invalid text throws an exception.
     */
    @Test
    public final void testParse_Invalid() {
        final Executable closure;

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                parse("abc");
            }

        };

        Assertions.assertThrows(Exception.class, closure);
    }

    /**
     * Tests that a negative value throws an exception.
     */
    @Test
    public final void testParse_Negative() {
        final Executable closure;

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                parse("-1");
            }

        };

        Assertions.assertThrows(Exception.class, closure);
    }

    /**
     * Tests that dice notation with zero sides throws an exception.
     */
    @Test
    public final void testParse_ZeroSides() {
        final Executable closure;

        closure = new Executable() {

            @Override
            public void execute() throws Throwable {
                parse("1d0");
            }

        };

        Assertions.assertThrows(Exception.class, closure);
    }

}
