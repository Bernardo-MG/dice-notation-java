
package com.bernardomg.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;

public final class TransformedDiceNotationExpressionParser<R>
        implements DiceNotationExpressionParser<R> {

    private final DiceNotationExpressionParser<TransformableDiceNotationExpression> parser = new DefaultDiceNotationExpressionParser();

    private final DiceNotationTransformer<R>                                        transformer;

    public TransformedDiceNotationExpressionParser(
            final DiceNotationTransformer<R> transf) {
        super();

        transformer = checkNotNull(transf,
                "Received a null pointer as transformer");
    }

    @Override
    public final R parse(final String expression) {
        final TransformableDiceNotationExpression parsed;

        parsed = parser.parse(expression);

        return parsed.transform(transformer);
    }

}
