/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.visitor;

import java.util.ArrayList;
import java.util.Collection;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Stores all the dice set from the expressions received.
 * <p>
 * It handles negative dice sets. Any dice directly after a subtraction is a
 * negative dice set.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceAccumulator
        implements NotationAccumulator<Iterable<Dice>> {

    /**
     * All the dice collected so far.
     */
    private final Collection<Dice> dice     = new ArrayList<>();

    /**
     * Flag indicating if the next dice set is a negative value.
     */
    private Boolean                negative = false;

    /**
     * Default constructor.
     */
    public DiceAccumulator() {
        super();
    }

    @Override
    public final void binaryOperation(final BinaryOperation exp) {
        if (exp instanceof SubtractionOperation) {
            negative = true;
        } else {
            negative = false;
        }
    }

    @Override
    public final void constantOperand(final ConstantOperand exp) {
        negative = false;
    }

    @Override
    public final void diceOperand(final DiceOperand exp) {
        if (negative) {
            dice.add(reverse(exp.getDice()));
        } else {
            dice.add(exp.getDice());
        }
    }

    @Override
    public final Iterable<Dice> getValue() {
        return dice;
    }

    @Override
    public final void reset() {
        negative = false;
        dice.clear();
    }

    /**
     * Reverses the sign of a dice, changing positive values to negatives, and
     * viceversa.
     * 
     * @param dice
     *            dice to reverse
     * @return dice with the sign reversed
     */
    private final Dice reverse(final Dice dice) {
        return new DefaultDice(0 - dice.getQuantity(), dice.getSides());
    }

}
