
package com.bernardomg.tabletop.dice.notation;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;

public interface DiceNotationExpressionRoot extends DiceNotationExpression {

    public DiceNotationExpression getRoot();

    public Integer roll();

    /**
     * Returns a value from the expression
     * <p>
     * This allows acquiring custom data from the expression tree.
     * 
     * @param interpreter
     *            contains the logic to transform the expression
     * @return transformed result
     */
    public <V> V transform(final DiceNotationTransformer<V> interpreter);

}
