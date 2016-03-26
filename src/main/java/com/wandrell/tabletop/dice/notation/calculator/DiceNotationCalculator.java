
package com.wandrell.tabletop.dice.notation.calculator;

import java.util.Collection;

import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public interface DiceNotationCalculator {

    public Integer execute(final Collection<Operand> operands,
            final Collection<BinaryOperation> operations);

}
