
package com.bernardomg.tabletop.dice.notation;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.roller.Roller;

public final class DefaultDiceNotationExpressionRoot
        implements DiceNotationExpressionRoot {

    /**
     * TODO: This should exist only in the root node.
     */
    private final DiceNotationTransformer<Integer> rollerTransformer;

    private final DiceNotationExpression           root;

    public DefaultDiceNotationExpressionRoot(
            final DiceNotationExpression expression) {
        super();

        root = checkNotNull(expression,
                "Received a null pointer as root expression");
        rollerTransformer = new RollerTransformer();
    }

    public DefaultDiceNotationExpressionRoot(
            final DiceNotationExpression expression, final Roller roller) {
        super();

        root = checkNotNull(expression,
                "Received a null pointer as root expression");
        rollerTransformer = new RollerTransformer(roller);
    }

    @Override
    public final String getExpression() {
        return getRoot().getExpression();
    }

    @Override
    public final DiceNotationExpression getRoot() {
        return root;
    }

    @Override
    public final Integer roll() {
        return transform(rollerTransformer);
    }

    @Override
    public final <V> V transform(final DiceNotationTransformer<V> interpreter) {
        return interpreter.transform(getRoot());
    }

}
