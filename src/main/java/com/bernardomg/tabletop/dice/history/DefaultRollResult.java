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

package com.bernardomg.tabletop.dice.history;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.google.common.collect.Iterables;

/**
 * Immutable roll result.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DefaultRollResult implements RollResult {

    /**
     * All the generated values.
     */
    private final Iterable<Integer>      allRolls;

    /**
     * Rolled dice.
     */
    private final DiceNotationExpression expression;

    /**
     * Sum of all the generated values.
     */
    private final Integer                totalRoll;

    /**
     * Constructs a roll result with the specified data.
     * 
     * @param exp
     *            expression which generated the result
     * @param rolls
     *            generated values
     * @param total
     *            sum of all the values
     */
    public DefaultRollResult(final DiceNotationExpression exp,
            final Iterable<Integer> rolls, final Integer total) {
        super();

        expression = checkNotNull(exp, "Received a null pointer as expression");
        allRolls = checkNotNull(rolls, "Received a null pointer as rolls");
        totalRoll = checkNotNull(total,
                "Received a null pointer as total roll");
    }

    @Override
    public final Iterable<Integer> getAllRolls() {
        return allRolls;
    }

    @Override
    public final DiceNotationExpression getExpression() {
        return expression;
    }

    @Override
    public final String getText() {
        final StringBuilder text;

        text = new StringBuilder();
        if (Iterables.size(allRolls) == 1) {
            text.append(String.valueOf(totalRoll));
        } else if (!Iterables.isEmpty(allRolls)) {
            text.append("[");
            text.append(StreamSupport.stream(allRolls.spliterator(), false)
                    .map(Object::toString).collect(Collectors.joining(", ")));
            text.append("]");
        }

        return text.toString();
    }

    @Override
    public final Integer getTotalRoll() {
        return totalRoll;
    }

}
