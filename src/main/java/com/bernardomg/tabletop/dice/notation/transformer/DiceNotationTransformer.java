
package com.bernardomg.tabletop.dice.notation.transformer;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

public interface DiceNotationTransformer<V> {

    public V getNeutralValue();

    public V transform(final BinaryOperation operation, final V accumulated);

    public V transform(final ConstantOperand operand, final V accumulated);

    public V transform(final DiceNotationExpression expression,
            final V accumulated);

    public V transform(final DiceOperand operand, final V accumulated);

}
