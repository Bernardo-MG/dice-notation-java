
package com.bernardomg.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.transformer.DiceNotationTransformer;

public final class TransformedDiceNotationExpressionParser<R>
        implements DiceNotationExpressionParser<R> {

    private final DiceNotationExpressionParser<DiceNotationExpression> parser = new DefaultDiceNotationExpressionParser();

    private final DiceNotationTransformer<R>                           transformer;

    public TransformedDiceNotationExpressionParser(
            final DiceNotationTransformer<R> transf) {
        super();

        transformer = checkNotNull(transf,
                "Received a null pointer as transformer");
    }

    @Override
    public final R parse(final String expression) {
        final DiceNotationExpression parsed;

        parsed = parser.parse(expression);

        return transformer.transform(parsed);
    }

}
