/**
 * Copyright 2014-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
        // Operand operandTop;
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
                    itrOperands.next();
                    operandCurrent = operation.operate();
                } else {
                    // TODO
                    throw new RuntimeException();
                }
            }
        }

        return operandCurrent.getValue();
    }

}
