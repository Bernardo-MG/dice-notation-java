/**
 * Copyright 2014-2018 the original author or authors
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

package com.bernardomg.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.bernardomg.tabletop.dice.generated.DiceNotationLexer;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser;
import com.bernardomg.tabletop.dice.notation.DefaultTransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.listener.DefaultDiceExpressionBuilder;
import com.bernardomg.tabletop.dice.parser.listener.DefaultErrorListener;
import com.bernardomg.tabletop.dice.parser.listener.DiceExpressionBuilder;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;

/**
 * Dice notation parser. Can parse the full grammar.
 * <p>
 * Makes use of ANTLR4 generated classes. These classes are generated from an
 * ANTRL4 BNF grammar, including the actual parser, which this one wraps and
 * sets up, mostly by adding a {@link DiceExpressionBuilder} to it.
 * <p>
 * This {@code DiceExpressionBuilder} is a listener making use of the visitor
 * pattern to generate the returned tree of dice notation model objects.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultDiceNotationExpressionParser
        implements DiceNotationExpressionParser {

    /**
     * Visitor used to build the returned object.
     * <p>
     * It is a listener which will be called when the ANTLR parser goes through
     * each node on the generated grammar tree, creating from it a tree of dice
     * notation model objects.
     */
    private final DiceExpressionBuilder expressionBuilder;

    private final Roller                roller;

    /**
     * Default constructor.
     * <p>
     * It makes use of a {@link DefaultDiceExpressionBuilder}.
     */
    public DefaultDiceNotationExpressionParser() {
        super();

        expressionBuilder = new DefaultDiceExpressionBuilder();
        roller = new DefaultRoller();
    }

    /**
     * Constructs a parser with the specified builder.
     * 
     * @param builder
     *            builder to generate the returned tree
     */
    public DefaultDiceNotationExpressionParser(
            final DiceExpressionBuilder builder) {
        super();

        expressionBuilder = checkNotNull(builder,
                "Received a null pointer as listener");
        roller = new DefaultRoller();
    }

    /**
     * Constructs a parser with the specified builder and roller.
     * 
     * @param builder
     *            builder to generate the returned tree
     * @param rllr
     *            roller for the dice expressions
     */
    public DefaultDiceNotationExpressionParser(
            final DiceExpressionBuilder builder, final Roller rllr) {
        super();

        expressionBuilder = checkNotNull(builder,
                "Received a null pointer as listener");
        roller = checkNotNull(rllr, "Received a null pointer as roller");
    }

    /**
     * Constructs a parser with the specified roller.
     * <p>
     * It makes use of a {@link DefaultDiceExpressionBuilder}.
     * 
     * @param rllr
     *            roller for the dice expressions
     */
    public DefaultDiceNotationExpressionParser(final Roller rllr) {
        super();

        expressionBuilder = new DefaultDiceExpressionBuilder();
        roller = checkNotNull(rllr, "Received a null pointer as roller");
    }

    @Override
    public final TransformableDiceNotationExpression
            parse(final String expression) {
        final DiceNotationParser parser;   // ANTLR parser
        final DiceNotationExpression root; // Root expression

        checkNotNull(expression, "Received a null pointer as string");

        // Creates the ANTLR parser
        parser = buildDiceNotationParser(expression);

        // Listeners are added
        parser.addErrorListener(new DefaultErrorListener());
        parser.addParseListener(getDiceExpressionBuilder());

        // Parses the expression
        parser.parse();

        root = getDiceExpressionBuilder().getDiceExpressionRoot();

        // Returns the tree root node
        return new DefaultTransformableDiceNotationExpression(root, roller);
    }

    /**
     * Creates the ANTLR4 parser to be used for processing the dice expression.
     * <p>
     * This parser will be tailored to the received expression, but it will
     * still need a listener which, using the visitor pattern, will create the
     * final object.
     * 
     * @param expression
     *            expression used to generate the parser
     * @return an ANTLR4 parser tailored for the expression
     */
    private final DiceNotationParser
            buildDiceNotationParser(final String expression) {
        final CharStream stream;       // Input stream for the expression
        final DiceNotationLexer lexer; // Lexer for the expression tokens
        final TokenStream tokens;      // Expression tokens

        stream = CharStreams.fromString(expression);
        lexer = new DiceNotationLexer(stream);
        tokens = new CommonTokenStream(lexer);

        return new DiceNotationParser(tokens);
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
