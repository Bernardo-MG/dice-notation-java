
package com.bernardomg.tabletop.dice.visitor;

import com.bernardomg.tabletop.dice.history.RollResult;

public final class EmptyRollTransformer implements RollTransformer {

    public EmptyRollTransformer() {
        super();
    }

    @Override
    public final RollResult transform(final RollResult result,
            final Integer index) {
        return result;
    }

}
