/**
 * Copyright 2014-2023 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.roll;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Iterator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.random.DiceToRollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceToRollResult generates the expected values")
public final class TestDiceToRollResult {

    @Mock
    private Dice            dice;

    @Mock
    private NumberGenerator generator;

    public TestDiceToRollResult() {
        super();
    }

    @Test
    @DisplayName("The total roll is enerated when there is a single value")
    public final void testApply_AddSingleValue() {
        final Integer rolled;

        // Mocks generator
        when(generator.generate(dice)).thenReturn(Arrays.asList(5));

        rolled = new DiceToRollResult(generator).apply(dice)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("The total roll is a sum of all the generated values")
    public final void testApply_AddsTotalRoll() {
        final Integer rolled;

        // Mocks generator
        when(generator.generate(dice)).thenReturn(Arrays.asList(1, 2, 3));

        rolled = new DiceToRollResult(generator).apply(dice)
            .getTotalRoll();

        Assertions.assertThat(rolled)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("All the rolls generated by the roller are returned")
    public final void testApply_ReturnsAllRolls() {
        final Iterator<Integer> rolled;

        // Mocks generator
        when(generator.generate(dice)).thenReturn(Arrays.asList(1, 2));

        rolled = new DiceToRollResult(generator).apply(dice)
            .getAllRolls()
            .iterator();

        Assertions.assertThat(rolled.next())
            .isEqualTo(1);
        Assertions.assertThat(rolled.next())
            .isEqualTo(2);
    }

    @Test
    @DisplayName("The correct dice are returned")
    public final void testApply_ReturnsDice() {
        final Dice returned;

        // Mocks dice
        when(dice.getQuantity()).thenReturn(1);
        when(dice.getSides()).thenReturn(2);

        // Mocks generator
        when(generator.generate(dice)).thenReturn(Arrays.asList(5));

        returned = new DiceToRollResult(generator).apply(dice)
            .getDice();

        Assertions.assertThat(returned.getQuantity())
            .isEqualTo(1);
        Assertions.assertThat(returned.getSides())
            .isEqualTo(2);
    }

}
