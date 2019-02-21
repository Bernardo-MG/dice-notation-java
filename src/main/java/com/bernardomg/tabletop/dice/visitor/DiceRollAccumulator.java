
package com.bernardomg.tabletop.dice.visitor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Stack;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.history.DefaultRollHistory;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.DivisionOperation;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.roller.Roller;
import com.google.common.collect.Iterables;

public final class DiceRollAccumulator
        implements NotationAccumulator<RollHistory> {

    /**
     * Logger.
     */
    private static final Logger     LOGGER  = LoggerFactory
            .getLogger(DiceRollAccumulator.class);

    private DiceNotationExpression  previous;

    private final Stack<RollResult> results = new Stack<>();

    private final Roller            roller;

    private final Stack<String>     texts   = new Stack<>();

    private final Stack<Integer>    values  = new Stack<>();

    public DiceRollAccumulator(final Roller rllr) {
        super();

        roller = checkNotNull(rllr, "Received a null pointer as roller");
    }

    @Override
    public final void binaryOperation(final BinaryOperation exp) {
        final Integer operandA;
        final Integer operandB;
        final BiFunction<Integer, Integer, Integer> operation;
        final String textA;
        final String textB;
        final String op;
        Integer value;
        RollResult rollResult;

        // Operation
        // Takes back the two latest values and applies
        operandB = values.pop();
        operandA = values.pop();
        operation = exp.getOperation();
        value = operation.apply(operandA, operandB);
        values.push(value);

        op = getOperationText(exp);
        textA = texts.pop();
        textB = texts.pop();
        texts.push(textB + op + textA);

        if ((exp instanceof SubtractionOperation)
                && (previous instanceof ConstantOperand)) {
            // This is a subtraction
            // The previous value was a constant
            // The sign is changed
            rollResult = results.pop();
            value = 0 - rollResult.getTotalRoll();
            rollResult = new DefaultRollResult(value);
            results.push(rollResult);
        }

        previous = exp;
    }

    @Override
    public final void constantOperand(final ConstantOperand exp) {
        final Integer value;
        final RollResult rollResult;

        // Constant
        // Stores the value
        value = exp.getValue();
        rollResult = new DefaultRollResult(value);
        results.add(rollResult);

        values.push(rollResult.getTotalRoll());

        texts.push(rollResult.getTotalRoll().toString());

        previous = exp;
    }

    @Override
    public final void diceOperand(final DiceOperand exp) {
        final RollResult rollResult;

        // Dice
        // Generates a random value
        rollResult = roller.roll(exp.getDice());
        results.add(rollResult);

        values.push(rollResult.getTotalRoll());

        if (Iterables.size(rollResult.getAllRolls()) > 1) {
            texts.push(rollResult.getAllRolls().toString());
        } else {
            texts.push(rollResult.getTotalRoll().toString());
        }

        previous = exp;
    }

    @Override
    public final RollHistory getValue() {
        final String text;
        final Integer result;

        if (values.isEmpty()) {
            // By default the returned value is 0
            result = 0;
        } else {
            // The value which is left is returned
            result = values.pop();
        }

        if (texts.isEmpty()) {
            text = "";
        } else {
            text = texts.pop();
        }

        return new DefaultRollHistory(results, text, result);
    }

    /**
     * Returns the text value of the received operation.
     * 
     * @param exp
     *            expression containing the operation
     * @return text value of the operation
     */
    private final String getOperationText(final BinaryOperation exp) {
        final String text;

        if (exp instanceof AdditionOperation) {
            text = " + ";
        } else if (exp instanceof SubtractionOperation) {
            text = " - ";
        } else if (exp instanceof MultiplicationOperation) {
            text = " * ";
        } else if (exp instanceof DivisionOperation) {
            text = " / ";
        } else {
            LOGGER.warn("Unsupported expression of type {}", exp.getClass());
            text = "";
        }

        return text;
    }

}
