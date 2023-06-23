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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.random.DiceToRollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;

@ExtendWith(MockitoExtension.class)
@DisplayName("DiceToRollResult calls its dependencies")
public final class TestDiceToRollResultCalls {

    @Mock
    private Dice            dice;

    @Mock
    private NumberGenerator generator;

    public TestDiceToRollResultCalls() {
        super();
    }

    @Test
    @DisplayName("The generator is called a single time for several dice")
    public final void testApply_GeneratesOnce() {

        // Mocks generator
       when(generator.generate((Dice) ArgumentMatchers.any()))
            .thenReturn(Arrays.asList(1, 2, 3));

        new DiceToRollResult(generator).apply(dice);

       verify(generator,times(1))
            .generate((Dice) ArgumentMatchers.any());
    }

}
