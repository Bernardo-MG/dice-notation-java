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

package com.wandrell.tabletop.dice.test.integration.generated.grammar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.generated.DiceNotationGrammarLexer;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser;
import com.wandrell.tabletop.dice.parser.listener.DefaultErrorListener;

/**
 * Integration tests for the generated grammar classes, testing that they can
 * process dice notation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDiceGrammarInvalid {

    /**
     * Default constructor.
     */
    public ITDiceGrammarInvalid() {
        super();
    }

    /**
     * Tests that a number with two negative markers can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_DoubleNegative_Exception() {
        getParser("--15").parse();
    }

    /**
     * Tests that a negative dice can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_NegativeQuantity_Exception() {
        getParser("-1d6").parse();
    }

    /**
     * Tests that a dice with a negative side can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_NegativeSides_Exception() {
        getParser("1d-6").parse();
    }

    /**
     * Tests that a dice without quantity can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_NoQuantity_Exception() {
        getParser("d6").parse();
    }

    /**
     * Tests that a dice with no sides can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_NoSides_Exception() {
        getParser("1d").parse();
    }

    /**
     * Tests that the dice separator can't be parsed.
     */
    @Test(expectedExceptions = { Exception.class })
    public final void testParse_OnlySeparator_Exception() {
        getParser("d").parse();
    }

    /**
     * Builds a grammar parser for the specified notation.
     * 
     * @param notation
     *            notation to parse
     * @return a parse tailored the the notation
     */
    private final DiceNotationGrammarParser getParser(final String notation) {
        final CharStream in;                    // Characters stream
        final DiceNotationGrammarLexer lexer;   // Lexer
        final TokenStream tokens;               // Lexical tokens
        final DiceNotationGrammarParser parser; // Parser

        in = new ANTLRInputStream(notation);
        lexer = new DiceNotationGrammarLexer(in);
        tokens = new CommonTokenStream(lexer);

        parser = new DiceNotationGrammarParser(tokens);

        parser.addErrorListener(new DefaultErrorListener());

        return parser;
    }

}
