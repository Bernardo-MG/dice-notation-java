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

package com.bernardomg.tabletop.dice.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.DefaultRollHistory;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.Operation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;

/**
 * Dice notation expression which simulates rolling the expression.
 * <p>
 * As some values, such as dice, represent random numbers the transformer may
 * not return the same result each time it is executed for the same expression.
 * <p>
 * The random value will be generated by a {@link NumberGenerator} contained in
 * the transformer, which can be set through the constructor. Otherwise the
 * default one, a {@link RandomNumberGenerator}, will be used.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceRoller implements DiceInterpreter<RollHistory> {

    /**
     * Logger.
     */
    private static final Logger                                     LOGGER    = LoggerFactory
            .getLogger(DiceRoller.class);

    /**
     * The random numbers generator.
     * <p>
     * Combined with the data in the rolled this, this will generate a random
     * value in an interval.
     */
    private final NumberGenerator                                   numberGenerator;

    /**
     * Transformer to generate a list from the received expression.
     */
    private final DiceInterpreter<Iterable<DiceNotationExpression>> traverser = new PostorderTraverser();

    /**
     * Default constructor.
     */
    public DiceRoller() {
        super();

        numberGenerator = new RandomNumberGenerator();
    }

    /**
     * Constructs a transformer using the received roller for simulating rolls.
     * 
     * @param generator
     *            the random number generator to use
     */
    public DiceRoller(final NumberGenerator generator) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");
    }

    @Override
    public final RollHistory
            transform(final DiceNotationExpression expression) {
        final Iterable<DiceNotationExpression> ordered;
        final RollHistory result;

        checkNotNull(expression, "Received a null pointer as expression");

        LOGGER.debug("Root expression {}", expression);

        ordered = traverser.transform(expression);

        result = getValue(ordered);

        return result;
    }

    /**
     * Returns the final value from the parsed expression. This expression is
     * received as a postorder tree list.
     * 
     * @param expressions
     *            expressions to get the values from
     * @return the value from the expressions
     */
    private final RollHistory
            getValue(final Iterable<DiceNotationExpression> expressions) {
        final Stack<Integer> values;
        final Collection<RollResult> results;
        final Integer result;
        RollResult rollResult;
        Integer value;
        Integer operandA;
        Integer operandB;
        BiFunction<Integer, Integer, Integer> operation;
        DiceNotationExpression previous;

        results = new ArrayList<>();
        values = new Stack<>();
        previous = null;
        for (final DiceNotationExpression current : expressions) {
            if (current instanceof Operation) {
                // Operation
                // Takes back the two latest values and applies
                operandB = values.pop();
                operandA = values.pop();
                operation = ((Operation) current).getOperation();
                value = operation.apply(operandA, operandB);
                values.push(value);
                if ((current instanceof SubtractionOperation)
                        && (previous instanceof ConstantOperand)) {
                    value = values.pop();
                    value = 0 - value;
                    values.push(value);
                }
            } else if (current instanceof ConstantOperand) {
                // Constant
                // Stores the value
                value = ((ConstantOperand) current).getValue();
                rollResult = new DefaultRollResult(current,
                        Arrays.asList(value), value);
                values.push(value);
                results.add(rollResult);
            } else if (current instanceof DiceOperand) {
                // Dice
                // Generates a random value
                rollResult = transform(((DiceOperand) current));
                value = rollResult.getTotalRoll();
                values.push(value);
                results.add(rollResult);
            } else {
                LOGGER.warn("Unsupported expression of type {}",
                        current.getClass());
            }
            previous = current;
        }

        if (values.isEmpty()) {
            // By default the returned value is 0
            result = 0;
        } else {
            // The value which is left is returned
            result = values.pop();
        }

        return new DefaultRollHistory(results, result);
    }

    /**
     * Generates a collection of random values from the received {@code Dice}.
     * <p>
     * These are returned in the same order they were generated.
     * 
     * @param dice
     *            the dice to roll
     * @return a collection of random values generated from the dice
     */
    private final Iterable<Integer> roll(final Dice dice) {
        final Collection<Integer> rolls; // Roll results
        final Integer quantity;
        final Boolean negative;

        checkNotNull(dice, "Received a null pointer as dice");

        if (dice.getQuantity() < 0) {
            quantity = 0 - dice.getQuantity();
            negative = true;
        } else {
            quantity = dice.getQuantity();
            negative = false;
        }

        rolls = new ArrayList<Integer>();
        for (Integer i = 0; i < quantity; i++) {
            if (negative) {
                rolls.add(0 - numberGenerator.generate(dice.getSides()));
            } else {
                rolls.add(numberGenerator.generate(dice.getSides()));
            }
        }

        return rolls;
    }

    /**
     * Returns the value from a dice operand.
     * <p>
     * This will generate a random value for each die in the dice set. The
     * actual random value will be generated by the dice roller.
     * 
     * @param operand
     *            operand to transform
     * @return result from rolling the dice
     */
    private final RollResult transform(final DiceOperand operand) {
        final Iterable<Integer> rolls;
        Integer total;

        rolls = roll(operand.getDice());

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        return new DefaultRollResult(operand, rolls, total);
    }

}
