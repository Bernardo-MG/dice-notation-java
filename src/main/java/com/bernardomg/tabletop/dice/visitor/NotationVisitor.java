
package com.bernardomg.tabletop.dice.visitor;

import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;

public interface NotationVisitor<V> {

    public void binaryOperation(final BinaryOperation exp);

    public void constantOperand(final ConstantOperand exp);

    public void diceOperand(final DiceOperand exp);

}
