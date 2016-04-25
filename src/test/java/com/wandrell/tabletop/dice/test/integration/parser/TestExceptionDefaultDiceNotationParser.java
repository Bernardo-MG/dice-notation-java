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

import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.parser.AntlrDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Units tests for {@code DefaultDiceNotationParser}, checking that it throws
 * exceptions when required.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An empty text throws an exception.</li>
 * <li>An invalid text throws an exception.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionDefaultDiceNotationParser {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultDiceNotationParser() {
        super();
    }

    /**
     * Tests that an empty text throws an exception.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testParse_Empty() {
        final DiceNotationParser parser; // Tested parser

        parser = new AntlrDiceNotationParser(new DefaultRoller());

        parser.parse("");
    }

    /**
     * Tests that an invalid text throws an exception.
     */
    @Test(expectedExceptions = Exception.class)
    public final void testParseDice_Invalid() {
        final DiceNotationParser parser; // Tested parser

        parser = new AntlrDiceNotationParser(new DefaultRoller());

        parser.parse("abc");
    }

}