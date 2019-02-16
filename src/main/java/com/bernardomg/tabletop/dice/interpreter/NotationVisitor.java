
package com.bernardomg.tabletop.dice.interpreter;

import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

public interface NotationVisitor<V> {

    public void onBinaryOperation(final BinaryOperation exp);

    public void onConstantOperand(final ConstantOperand exp);

    public void onDiceOperand(final DiceOperand exp);

    public V getValue();

}
