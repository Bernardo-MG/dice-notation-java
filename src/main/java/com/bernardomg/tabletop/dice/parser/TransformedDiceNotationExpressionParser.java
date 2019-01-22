
package com.bernardomg.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.transformer.DiceNotationTransformer;

/**
 * Transformed dice notation parsed. Allows returning custom objects through the
 * use of a {@link DiceNotationTransformer}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 * @param <R>
 *            return type
 */
public final class TransformedDiceNotationExpressionParser<R>
        implements DiceNotationExpressionParser<R> {

    /**
     * Wrapped parser. This will take care of the actual parsing.
     */
    private final DiceNotationExpressionParser<DiceNotationExpression> parser = new DefaultDiceNotationExpressionParser();

    /**
     * Transformer to change the parsed model into the return type.
     */
    private final DiceNotationTransformer<R>                           transformer;

    /**
     * Constructs a parser with the specified transformer.
     * 
     * @param transf
     *            transformer to generate the returned type
     */
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
