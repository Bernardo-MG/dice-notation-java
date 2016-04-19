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

package com.wandrell.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.wandrell.tabletop.dice.generated.DiceNotationLexer;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.parser.listener.DefaultDiceExpressionBuilder;
import com.wandrell.tabletop.dice.parser.listener.DiceExpressionBuilder;

public final class DefaultDiceNotationParser implements DiceNotationParser {

    final DiceExpressionBuilder diceNotationListener;

    public DefaultDiceNotationParser() {
        super();

        diceNotationListener = new DefaultDiceExpressionBuilder();
    }

    public DefaultDiceNotationParser(final DiceExpressionBuilder listener) {
        super();

        diceNotationListener = checkNotNull(listener,
                "Received a null pointer as listener");
    }

    @Override
    public final DiceExpression parse(final String string) {
        final com.wandrell.tabletop.dice.generated.DiceNotationParser parser;

        checkNotNull(string, "Received a null pointer as string");

        parser = buildDiceNotationParser(string);

        parser.addErrorListener(new DefaultErrorListener());
        parser.addParseListener(getDiceNotationListener());
        parser.parse();

        return getDiceNotationListener().getDiceExpression();
    }

    private final com.wandrell.tabletop.dice.generated.DiceNotationParser
            buildDiceNotationParser(final String string) {
        final ANTLRInputStream input;
        final DiceNotationLexer lexer;
        final TokenStream tokens;

        input = new ANTLRInputStream(string);
        lexer = new DiceNotationLexer(input);
        tokens = new CommonTokenStream(lexer);

        return new com.wandrell.tabletop.dice.generated.DiceNotationParser(
                tokens);
    }

    private final DiceExpressionBuilder getDiceNotationListener() {
        return diceNotationListener;
    }

}