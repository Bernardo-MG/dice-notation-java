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
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.parser.listener.DefaultDiceExpressionBuilder;
import com.wandrell.tabletop.dice.parser.listener.DefaultErrorListener;
import com.wandrell.tabletop.dice.parser.listener.DiceExpressionBuilder;
import com.wandrell.tabletop.dice.roller.Roller;

/**
 * Dice notation parser making use of ANTLR4 generated classes.
 * <p>
 * These classes are generated from an ANTRL4 BNF grammar, including the actual
 * parser, which this one wraps and sets up, mostly by setting a {@link DiceExpressionBuilder}
 * into it.
 * <p>
 * The {@code DiceExpressionBuilder} is a listener making use of the visitor pattern to 
 * generate the returned tree of dice notation model objects.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultDiceNotationParser implements DiceNotationParser {

    /**
     * Visitor used to build the returned object.
     * <p>
     * It is a listener which will be called when the ANTLR parser goes through each node
     * on the generated grammar tree, creating from it a tree of dice notation model objects.
     */
    final DiceExpressionBuilder expressionBuilder;

    /**
     * Constructs a parser with the specified builder.
     * 
     * @param builder
     *            builder to generate the returned tree
     */
    public DefaultDiceNotationParser(final DiceExpressionBuilder builder) {
        super();

        expressionBuilder = checkNotNull(builder,
                "Received a null pointer as listener");
    }

    /**
     * Default constructor.
     * <p>
     * It makes use of a {@link DefaultDiceExpressionBuilder}.
     * 
     * @param roller
     *            roller for the dice expressions
     */
    public DefaultDiceNotationParser(final Roller roller) {
        super();

        expressionBuilder = new DefaultDiceExpressionBuilder(roller);
    }

    @Override
    public final DiceExpressionComponent parse(final String expression) {
        final com.wandrell.tabletop.dice.generated.DiceNotationParser parser;

        checkNotNull(expression, "Received a null pointer as string");

        parser = buildDiceNotationParser(expression);

        parser.addErrorListener(new DefaultErrorListener());
        parser.addParseListener(getDiceExpressionBuilder());
        parser.parse();

        return getDiceExpressionBuilder().getDiceExpression();
    }

    /**
     * Created the ANTLR4 parser which will be used to process the received
     * expression.
     * <p>
     * Combining this with the builder, which is actually a listener used for
     * the visitor pattern, it is possible creating the expected result.
     * <p>
     * The received expression will be processed in a few steps, which end in
     * the creation of the ANTLR4 parser.
     * 
     * @param expression
     *            expression used to generate the parser
     * @return an ANTLR4 parser tailored for the expression
     */
    private final com.wandrell.tabletop.dice.generated.DiceNotationParser
            buildDiceNotationParser(final String expression) {
        final ANTLRInputStream input;
        final DiceNotationLexer lexer;
        final TokenStream tokens;

        input = new ANTLRInputStream(expression);
        lexer = new DiceNotationLexer(input);
        tokens = new CommonTokenStream(lexer);

        return new com.wandrell.tabletop.dice.generated.DiceNotationParser(
                tokens);
    }

    /**
     * Listener used for the visitor pattern in the ANTLR4 parser.
     * <p>
     * It takes care of creating the returned object.
     * 
     * @return the ANTLR4 parser listener
     */
    private final DiceExpressionBuilder getDiceExpressionBuilder() {
        return expressionBuilder;
    }

}
