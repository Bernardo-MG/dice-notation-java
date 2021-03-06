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

package com.bernardomg.tabletop.dice.test.unit.roll;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.random.DiceToRollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@DisplayName("DiceToRollResult calls its dependencies")
public final class TestDiceToRollResultCalls {

    public TestDiceToRollResultCalls() {
        super();
    }

    @Test
    @DisplayName("The generator is called a single time for several dice")
    public final void testApply_GeneratesOnce() {
        final Dice dice;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate((Dice) ArgumentMatchers.any()))
                .thenReturn(Arrays.asList(1, 2, 3));

        new DiceToRollResult(generator).apply(dice);

        Mockito.verify(generator, Mockito.times(1))
                .generate((Dice) ArgumentMatchers.any());
    }

}
