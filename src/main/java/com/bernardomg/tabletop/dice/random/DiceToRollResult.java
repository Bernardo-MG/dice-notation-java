/**
 * Copyright 2014-2022 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.bernardomg.tabletop.dice.random;

import java.util.Objects;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollResult;

/**
 * Function for transforming a {@code Dice} to a {@code RollResult}, simulating rolls.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceToRollResult implements Function<Dice, RollResult> {

    /**
     * Logger.
     */
    private static final Logger   LOGGER = LoggerFactory.getLogger(DiceToRollResult.class);

    /**
     * The random numbers generator.
     * <p>
     * Combined with the data in the rolled this, this will generate a random value in an interval.
     */
    private final NumberGenerator numberGenerator;

    /**
     * Default constructor.
     */
    public DiceToRollResult() {
        super();

        numberGenerator = new RandomNumberGenerator();
    }

    /**
     * Constructs a function with the specified generator.
     * 
     * @param generator
     *            generator to use
     */
    public DiceToRollResult(final NumberGenerator generator) {
        super();

        numberGenerator = Objects.requireNonNull(generator, "Received a null pointer as generator");
    }

    @Override
    public final RollResult apply(final Dice dice) {
        final Iterable<Integer> rolls;
        Integer                 total;

        rolls = numberGenerator.generate(dice);

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        LOGGER.debug("Rolled {}", dice);
        LOGGER.debug("Generated rolls: {}", rolls);
        LOGGER.debug("Total roll: {}", total);

        return new DefaultRollResult(dice, rolls, total);
    }

}
