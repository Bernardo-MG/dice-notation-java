/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice.random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.Dice;

/**
 * Abstract number generator for facilitating extensions.
 * <p>
 * Contains all the logic to generate random values from a dice, but is missing
 * the logic for actually generating a random value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public abstract class AbstractNumberGenerator implements NumberGenerator {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractNumberGenerator.class);

    /**
     * Default constructor.
     */
    public AbstractNumberGenerator() {
        super();
    }

    @Override
    public final Iterable<Integer> generate(final Dice dice) {
        final Collection<Integer> rolls; // Roll results
        final Integer quantity;
        final Supplier<Integer> rollSupplier;

        Objects.requireNonNull(dice, "Received a null pointer as dice");

        if (dice.getQuantity() < 0) {
            // Negative dice set (-1d6)
            LOGGER.trace("Negative dice set");
            quantity = 0 - dice.getQuantity();
            rollSupplier = () -> (0 - generate(dice.getSides()));
        } else {
            // Positive dice set (1d6)
            LOGGER.trace("Positive dice set");
            quantity = dice.getQuantity();
            rollSupplier = () -> (generate(dice.getSides()));
        }

        rolls = new ArrayList<>();
        for (Integer i = 0; i < quantity; i++) {
            rolls.add(rollSupplier.get());
        }

        return rolls;
    }

}
