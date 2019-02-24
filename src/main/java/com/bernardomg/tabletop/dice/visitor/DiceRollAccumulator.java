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
import com.bernardomg.tabletop.dice.roll.RollGenerator;
import com.bernardomg.tabletop.dice.transformer.EmptyRollTransformer;
import com.bernardomg.tabletop.dice.transformer.RollTransformer;
import com.google.common.collect.Iterables;

/**
 * Stores all the rolls generated from the expressions.
 * <p>
 * Integer values are handled as a roll, just with a constant value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceRollAccumulator
        implements NotationAccumulator<RollHistory> {

    /**
     * Logger.
     */
    private static final Logger     LOGGER  = LoggerFactory
            .getLogger(DiceRollAccumulator.class);

    /**
     * The last expression received.
     */
    private DiceNotationExpression  previous;

    /**
     * All the results generated so far.
     */
    private final Stack<RollResult> results = new Stack<>();

    /**
     * Generator for the rolls.
     */
    private final RollGenerator     rollGenerator;

    /**
     * The text values generated so far.
     * <p>
     * It always contain the text representation of all the nodes parsed so far,
     * along temporal texts to keep building the final result.
     */
    private final Stack<String>     texts   = new Stack<>();

    /**
     * Transformer to allow customizing roll results.
     */
    private final RollTransformer   transformer;

    /**
     * The expression values generated so far.
     * <p>
     * It always contain the sum of all the nodes parsed so far, along temporal
     * values to keep building the final result.
     */
    private final Stack<Integer>    values  = new Stack<>();

    /**
     * Constructs an accumulator with the specified arguments.
     * 
     * @param generator
     *            roll generator to use
     */
    public DiceRollAccumulator(final RollGenerator generator) {
        super();

        rollGenerator = checkNotNull(generator,
                "Received a null pointer as roll generator");

        transformer = new EmptyRollTransformer();
    }

    /**
     * Constructs an accumulator with the specified arguments.
     * 
     * @param generator
     *            roll generator to use
     * @param trans
     *            roll transformer to use
     */
    public DiceRollAccumulator(final RollGenerator generator,
            final RollTransformer trans) {
        super();

        rollGenerator = checkNotNull(generator,
                "Received a null pointer as roll generator");
        transformer = checkNotNull(trans,
                "Received a null pointer as transformer");
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

        // This would chain with grammar functions
        // t = (r, i) -> transformer.transform(trans.transform(r, i), i);

        rollResult = rollGenerator.roll(exp.getDice(), transformer);
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

    @Override
    public final void reset() {
        previous = null;
        results.clear();
        texts.clear();
        values.clear();
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
