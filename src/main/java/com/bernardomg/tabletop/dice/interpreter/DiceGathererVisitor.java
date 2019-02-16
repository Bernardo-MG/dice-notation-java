
package com.bernardomg.tabletop.dice.interpreter;

import java.util.ArrayList;
import java.util.Collection;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

public final class DiceGathererVisitor implements NotationVisitor {

    private final Collection<Dice> dice     = new ArrayList<>();

    private Boolean                negative = false;

    public DiceGathererVisitor() {
        super();
    }

    public final Iterable<Dice> getDice() {
        return dice;
    }

    @Override
    public final void onBinaryOperation(final BinaryOperation exp) {
        if (exp instanceof SubtractionOperation) {
            negative = true;
        } else {
            negative = false;
        }
    }

    @Override
    public final void onConstantOperand(final ConstantOperand exp) {
        negative = false;
    }

    @Override
    public final void onDiceOperand(final DiceOperand exp) {
        if (negative) {
            dice.add(reverse(exp.getDice()));
        } else {
            dice.add(exp.getDice());
        }
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
