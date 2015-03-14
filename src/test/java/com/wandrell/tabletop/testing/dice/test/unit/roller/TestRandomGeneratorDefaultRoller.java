package com.wandrell.tabletop.testing.dice.test.unit.roller;

import java.util.Iterator;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.DefaultRoller.RandomGenerator;
import com.wandrell.tabletop.dice.roller.Roller;
import com.wandrell.tabletop.dice.roller.Roller.RollerResult;

public final class TestRandomGeneratorDefaultRoller {

    public TestRandomGeneratorDefaultRoller() {
        super();
    }

    @Test
    public final void testRandomGenerator_Bare_Returns() {
        final Dice dice;
        final Roller roller;
        final RollerResult<Integer> result;
        final RandomGenerator generator;
        final Iterator<Integer> itrInteger;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(6);

        generator = Mockito.mock(RandomGenerator.class);

        Mockito.when(generator.generate(Matchers.anyInt())).thenReturn(3, 5, 1);

        roller = new DefaultRoller(generator);

        result = roller.roll(dice);

        itrInteger = result.getBareRollResults().iterator();

        Assert.assertEquals(itrInteger.next(), (Integer) 3);
        Assert.assertEquals(itrInteger.next(), (Integer) 5);
        Assert.assertEquals(itrInteger.next(), (Integer) 1);
    }

    @Test
    public final void testRandomGenerator_Mapped_Returns() {
        final Dice dice;
        final Roller roller;
        final RollerResult<Integer> result;
        final RandomGenerator generator;
        final Iterator<Integer> itrInteger;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(6);

        generator = Mockito.mock(RandomGenerator.class);

        Mockito.when(generator.generate(Matchers.anyInt())).thenReturn(3, 5, 1);

        roller = new DefaultRoller(generator);

        result = roller.roll(dice);

        itrInteger = result.getMappedRollResults().iterator();

        Assert.assertEquals(itrInteger.next(), (Integer) 3);
        Assert.assertEquals(itrInteger.next(), (Integer) 5);
        Assert.assertEquals(itrInteger.next(), (Integer) 1);
    }

}
