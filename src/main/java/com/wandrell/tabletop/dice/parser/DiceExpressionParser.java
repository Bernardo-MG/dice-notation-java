package com.wandrell.tabletop.dice.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.TokenStream;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.grammar.DiceNotationLexer;
import com.wandrell.tabletop.dice.grammar.DiceNotationParser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.parser.listener.DiceFormulaBuilder;

public final class DiceExpressionParser
        implements Parser<String, DiceExpression> {

    public DiceExpressionParser() {
        super();
    }

    @Override
    public final DiceExpression parse(final String string) {
        final ANTLRInputStream input;
        final DiceNotationLexer lexer;
        final TokenStream tokens;
        final DiceNotationParser parser;
        final DiceFormulaBuilder diceNotationListener;

        input = new ANTLRInputStream(string);
        lexer = new DiceNotationLexer(input);
        tokens = new CommonTokenStream(lexer);

        parser = new DiceNotationParser(tokens);

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

        diceNotationListener = new DiceFormulaBuilder();

        parser.addParseListener(diceNotationListener);

        parser.formula();

        return diceNotationListener.getDiceFormula();
    }

}
