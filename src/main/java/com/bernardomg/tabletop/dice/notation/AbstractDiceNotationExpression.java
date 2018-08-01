
package com.bernardomg.tabletop.dice.notation;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import com.bernardomg.tabletop.dice.roller.Roller;

public abstract class AbstractDiceNotationExpression
        implements DiceNotationExpression {

    /**
     * TODO: This should exist only in the root node.
     */
    private final DiceNotationTransformer<Integer> rollerTransformer;

    public AbstractDiceNotationExpression() {
        super();

        rollerTransformer = new RollerTransformer();
    }

    public AbstractDiceNotationExpression(final Roller roller) {
        super();

        rollerTransformer = new RollerTransformer(roller);
    }

    @Override
    public final Integer roll() {
        return transform(rollerTransformer);
    }

    @Override
    public final <V> V transform(final DiceNotationTransformer<V> interpreter) {
        return interpreter.transform(this);
    }

}
