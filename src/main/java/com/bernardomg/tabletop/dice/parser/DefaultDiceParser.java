/**
 * Copyright 2014-2020 the original author or authors
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

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.bernardomg.tabletop.dice.generated.DiceNotationLexer;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser;
import com.bernardomg.tabletop.dice.interpreter.DiceInterpreter;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.listener.DefaultDiceExpressionBuilder;
import com.bernardomg.tabletop.dice.parser.listener.DefaultErrorListener;
import com.bernardomg.tabletop.dice.parser.listener.DiceExpressionBuilder;

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
public final class DefaultDiceParser implements DiceParser {

    /**
     * Error listener for the parser and lexer.
     */
    private final ANTLRErrorListener    errorListener;

    /**
     * Visitor used to build the returned object.
     * <p>
     * It is a listener which will be called when the ANTLR parser goes through
     * each node on the generated grammar tree, creating from it a tree of dice
     * notation model objects.
     */
    private final DiceExpressionBuilder expressionBuilder;

    /**
     * Default constructor.
     * <p>
     * It makes use of a {@link DefaultDiceExpressionBuilder}.
     */
    public DefaultDiceParser() {
        super();

        errorListener = new DefaultErrorListener();
        expressionBuilder = new DefaultDiceExpressionBuilder();
    }

    /**
     * Constructs a parser with the error listener
     * 
     * @param listener
     *            error listener
     */
    public DefaultDiceParser(final ANTLRErrorListener listener) {
        super();

        errorListener = checkNotNull(listener,
                "Received a null pointer as listener");
        expressionBuilder = new DefaultDiceExpressionBuilder();
    }

    /**
     * Constructs a parser with the specified builder.
     * 
     * @param builder
     *            builder to generate the returned tree
     */
    public DefaultDiceParser(final DiceExpressionBuilder builder) {
        super();

        errorListener = new DefaultErrorListener();
        expressionBuilder = checkNotNull(builder,
                "Received a null pointer as expression builder");
    }

    /**
     * Constructs a parser with the specified builder and error listener.
     * 
     * @param builder
     *            builder to generate the returned tree
     * @param listener
     *            error listener
     */
    public DefaultDiceParser(final DiceExpressionBuilder builder,
            final ANTLRErrorListener listener) {
        super();

        errorListener = checkNotNull(listener,
                "Received a null pointer as listener");
        expressionBuilder = checkNotNull(builder,
                "Received a null pointer as expression builder");
    }

    @Override
    public final DiceNotationExpression parse(final String expression) {
        final DiceNotationParser parser;   // ANTLR parser
        final DiceNotationExpression root; // Root expression

        checkNotNull(expression, "Received a null pointer as string");

        // Creates the ANTLR parser
        parser = buildDiceNotationParser(expression);

        // Parses the root rule
        parser.notation();

        root = expressionBuilder.getDiceExpressionRoot();

        // Returns the tree root node
        return root;
    }

    @Override
    public final <V> V parse(final String expression,
            final DiceInterpreter<V> interpreter) {
        final DiceNotationExpression parsed;

        parsed = parse(expression);

        return interpreter.transform(parsed);
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
        final CharStream stream;
        final DiceNotationLexer lexer;
        final TokenStream tokens;
        final DiceNotationParser parser;

        stream = CharStreams.fromString(expression);

        lexer = new DiceNotationLexer(stream);
        lexer.addErrorListener(errorListener);

        tokens = new CommonTokenStream(lexer);

        parser = new DiceNotationParser(tokens);
        parser.addErrorListener(errorListener);
        parser.addParseListener(expressionBuilder);

        return parser;
    }

}
