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

package com.wandrell.tabletop.dice.test.unit.grammar;

import java.util.Iterator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.TokenStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.generated.extended.DiceNotationExtendedLexer;
import com.wandrell.tabletop.dice.generated.extended.DiceNotationExtendedParser;
import com.wandrell.tabletop.dice.generated.extended.DiceNotationExtendedParser.NotationContext;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceValuesTestParametersFactory;

public final class TestDiceGrammar {

    protected static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceText();
    }

    public TestDiceGrammar() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testParse_Valid(final String text) {
        final NotationContext context;

        context = getParser(text).notation();

        Assert.assertNull(context.exception);
    }

    private final DiceNotationExtendedParser getParser(final String text) {
        final CharStream in;
        final DiceNotationExtendedLexer lexer;
        final TokenStream tokens;
        final DiceNotationExtendedParser parser;

        in = new ANTLRInputStream(text);
        lexer = new DiceNotationExtendedLexer(in);
        tokens = new CommonTokenStream(lexer);

        parser = new DiceNotationExtendedParser(tokens);

        parser.addErrorListener(new BaseErrorListener() {

            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                    Object offendingSymbol, int line, int charPositionInLine,
                    String msg, RecognitionException e) {
                final String message;

                message = String.format(
                        "failed to parse at line %d on char %d due to %s", line,
                        charPositionInLine + 1, msg);

                throw new IllegalStateException(message, e);
            }
        });

        return parser;
    }

}
