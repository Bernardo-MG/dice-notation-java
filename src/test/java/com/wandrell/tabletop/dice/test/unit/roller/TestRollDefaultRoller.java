/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.test.unit.roller;

import java.util.Iterator;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.mapper.RollMapper;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceValuesTestParametersFactory;

public final class TestRollDefaultRoller {

    protected static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDice();
    }

    public TestRollDefaultRoller() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testRoll_ResultsSize_BaredRollValues(
            final Integer quantity, final Integer sides) {
        final Dice dice;
        final Roller roller;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(quantity);
        Mockito.when(dice.getSides()).thenReturn(sides);

        roller = new DefaultRoller();

        Assert.assertEquals(
                (Integer) roller.roll(dice).getBareRollResults().size(),
                quantity);
    }

    @Test(dataProvider = DATA)
    public final void testRoll_ResultsSize_MappedRollValues_Default(
            final Integer quantity, final Integer sides) {
        final Dice dice;
        final Roller roller;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(quantity);
        Mockito.when(dice.getSides()).thenReturn(sides);

        roller = new DefaultRoller();

        Assert.assertEquals(
                (Integer) roller.roll(dice).getMappedRollResults().size(),
                quantity);
    }

    @SuppressWarnings("unchecked")
    @Test(dataProvider = DATA)
    public final void testRoll_ResultsSize_MappedRollValues_Mapped(
            final Integer quantity, final Integer sides) {
        final Dice dice;
        final Roller roller;
        final RollMapper<String> mapper;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(quantity);
        Mockito.when(dice.getSides()).thenReturn(sides);

        mapper = Mockito.mock(RollMapper.class);

        Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
                .thenReturn("ABC");

        roller = new DefaultRoller();

        Assert.assertEquals((Integer) roller.roll(dice, mapper)
                .getMappedRollResults().size(), quantity);
    }

    @Test(dataProvider = DATA)
    public final void testRoll_ValuesInBounds(final Integer quantity,
            final Integer sides) {
        final Dice dice;
        final Integer times = 100;
        final Integer lowerLimit;
        final Integer upperLimit;
        final Roller roller;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(quantity);
        Mockito.when(dice.getSides()).thenReturn(sides);

        roller = new DefaultRoller();

        if (quantity == 0) {
            for (Integer i = 0; i < times; i++) {
                for (final Integer roll : roller.roll(dice)
                        .getBareRollResults()) {
                    Assert.assertTrue(roll == 0);
                }
            }
        } else {
            lowerLimit = 1;
            upperLimit = sides;

            for (Integer i = 0; i < times; i++) {
                for (final Integer roll : roller.roll(dice)
                        .getBareRollResults()) {
                    Assert.assertTrue(roll >= lowerLimit);
                    Assert.assertTrue(roll <= upperLimit);
                }
            }
        }
    }

}
