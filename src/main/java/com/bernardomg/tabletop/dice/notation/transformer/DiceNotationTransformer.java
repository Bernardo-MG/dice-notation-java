
package com.bernardomg.tabletop.dice.notation.transformer;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

public interface DiceNotationTransformer<V> {

    public V transform(final BinaryOperation operation);

    public V transform(final ConstantOperand operand);

    public V transform(final DiceNotationExpression expression);

    public V transform(final DiceOperand operand);

}
