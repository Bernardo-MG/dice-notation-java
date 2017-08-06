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

package com.wandrell.tabletop.dice.test.integration.generated.grammar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.generated.DiceNotationGrammarLexer;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser.ParseContext;
import com.wandrell.tabletop.dice.parser.listener.DefaultErrorListener;

/**
 * Integration tests for the generated grammar classes, testing that they can
 * process dice notation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDiceGrammar {

    /**
     * Default constructor.
     */
    public ITDiceGrammar() {
        super();
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_LongAdd() {
        final ParseContext context; // Parsed context

        context = getParser("1+2+3+4+5+6+7+8+9+10").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_LongMixedAdd() {
        final ParseContext context; // Parsed context

        context = getParser("1d6+1+2+3+4+5+6+7+8+9+10").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_LongMixedSub() {
        final ParseContext context; // Parsed context

        context = getParser("1d6-1-2-3-4-5-6-7-8-9-10").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_LongSub() {
        final ParseContext context; // Parsed context

        context = getParser("1-2-3-4-5-6-7-8-9-10").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_MaxDice() {
        final ParseContext context; // Parsed context

        context = getParser(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE)
                .parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_MinimalDice() {
        final ParseContext context; // Parsed context

        context = getParser("1d1").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_NoQuantity() {
        final ParseContext context; // Parsed context

        context = getParser("0d6").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_NoSides() {
        final ParseContext context; // Parsed context

        context = getParser("1d0").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_PositiveNumber() {
        final ParseContext context; // Parsed context

        context = getParser("1").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_Zero() {
        final ParseContext context; // Parsed context

        context = getParser("0").parse();

        Assert.assertNull(context.exception);
    }

    /**
     * Tests that strings with valid dice notation expressions do not generate
     * exceptions.
     */
    @Test
    public final void testParse_ZerosDice() {
        final ParseContext context; // Parsed context

        context = getParser("0d0").parse();

        Assert.assertNull(context.exception);
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
