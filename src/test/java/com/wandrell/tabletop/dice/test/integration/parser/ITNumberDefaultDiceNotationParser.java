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
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Integration tests for {@code DefaultDiceNotationParser}, checking that it
 * parses numbers.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>A lone number is parsed correctly.</li>
 * <li>The zero value is parsed correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITNumberDefaultDiceNotationParser {

    /**
     * Default constructor.
     */
    public ITNumberDefaultDiceNotationParser() {
        super();
    }

    /**
     * Tests that a lone number is parsed correctly.
     */
    @Test
    public final void testParse_Number() {
        final IntegerOperand value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "12";

        value = (IntegerOperand) parser.parse(notation);

        Assert.assertEquals(value.getValue(), (Integer) 12);

        Assert.assertEquals(value.getExpression(), notation);
    }

    /**
     * Tests that the zero value is parsed correctly.
     */
    @Test
    public final void testParse_Zero() {
        final IntegerOperand value;
        final String notation;
        final DiceNotationParser parser;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "0";

        value = (IntegerOperand) parser.parse(notation);

        Assert.assertEquals(value.getValue(), (Integer) 0);

        Assert.assertEquals(value.getExpression(), notation);
    }

}
