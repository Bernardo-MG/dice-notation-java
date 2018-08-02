
package com.bernardomg.tabletop.dice.notation;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;

public abstract class AbstractDiceNotationExpression
        implements DiceNotationExpression {

    public AbstractDiceNotationExpression() {
        super();
    }

    @Override
    public final <V> V transform(final DiceNotationTransformer<V> interpreter) {
        return interpreter.transform(this);
    }

}
