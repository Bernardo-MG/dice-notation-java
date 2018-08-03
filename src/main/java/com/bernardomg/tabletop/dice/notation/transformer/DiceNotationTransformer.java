
package com.bernardomg.tabletop.dice.notation.transformer;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;

public interface DiceNotationTransformer<V> {

    public V transform(final DiceNotationExpression expression);

}
