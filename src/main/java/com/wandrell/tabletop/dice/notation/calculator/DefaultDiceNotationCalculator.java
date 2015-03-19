package com.wandrell.tabletop.dice.notation.calculator;

import java.util.Collection;
import java.util.Iterator;

import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public final class DefaultDiceNotationCalculator implements
        DiceNotationCalculator {

    public DefaultDiceNotationCalculator() {
        super();
    }

    @Override
    public final Integer execute(final Collection<Operand> operands,
            final Collection<BinaryOperation> operations) {
        final Iterator<BinaryOperation> itrOperations;
        final Iterator<Operand> itrOperands;
        Operand operandCurrent;
        Operand operandTop;
        BinaryOperation operation;

        itrOperands = operands.iterator();
        itrOperations = operations.iterator();
        operandCurrent = null;
        if (itrOperands.hasNext()) {
            if (operandCurrent == null) {
                operandCurrent = itrOperands.next();
            }
            while (itrOperations.hasNext()) {
                operation = itrOperations.next();

                if (itrOperands.hasNext()) {
                    operandTop = itrOperands.next();
                    operandCurrent = operation.operate(operandCurrent,
                            operandTop);
                } else {
                    // TODO
                    throw new RuntimeException();
                }
            }
        }

        return operandCurrent.getValue();
    }

}
