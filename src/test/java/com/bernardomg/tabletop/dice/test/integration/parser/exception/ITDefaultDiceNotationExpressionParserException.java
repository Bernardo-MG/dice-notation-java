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

package com.bernardomg.tabletop.dice.test.integration.parser.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@link DefaultDiceNotationExpressionParser}, verifying
 * that it throws exceptions when required.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserException {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserException() {
        super();
    }

    /**
     * Verifies that an empty text causes an exception.
     */
    @Test
    public final void testParse_Empty() {
        final Executable closure;

        closure = () -> new DefaultDiceNotationExpressionParser().parse("");

        Assertions.assertThrows(Exception.class, closure);
    }

    /**
     * Verifies that an invalid text causes an exception.
     */
    @Test
    public final void testParse_Invalid() {
        final Executable closure;

        closure = () -> new DefaultDiceNotationExpressionParser().parse("abc");

        Assertions.assertThrows(Exception.class, closure);
    }

    /**
     * Verifies that a partially valid text causes an exception.
     */
    @Test
    public final void testParse_PartiallyValid() {
        final Executable closure;

        closure = () -> new DefaultDiceNotationExpressionParser().parse("6d6y");

        Assertions.assertThrows(Exception.class, closure);
    }

}
