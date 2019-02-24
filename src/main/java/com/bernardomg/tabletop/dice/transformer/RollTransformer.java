
package com.bernardomg.tabletop.dice.transformer;

import com.bernardomg.tabletop.dice.history.RollResult;

@FunctionalInterface
public interface RollTransformer {

    public RollResult transform(final RollResult result, final Integer index);

}
