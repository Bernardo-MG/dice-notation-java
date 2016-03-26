
package com.wandrell.tabletop.testing.dice.test.unit.roller;

import java.util.Iterator;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.roller.DefaultRoller;
import com.wandrell.tabletop.dice.roller.Roller;
import com.wandrell.tabletop.dice.roller.Roller.RollMapper;
import com.wandrell.tabletop.dice.roller.Roller.RollerResult;
import com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter.DiceValuesTestParametersFactory;

public final class TestRollMapperDefaultRoller {

    protected static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDice();
    }

    public TestRollMapperDefaultRoller() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void testRollMapper_Alphanumeric_Returns() {
        final Dice dice;
        final Roller roller;
        final RollMapper<String> mapper;
        final String value;
        final Iterator<String> itrValues;

        value = "ABC";

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(5);
        Mockito.when(dice.getSides()).thenReturn(6);

        mapper = Mockito.mock(RollMapper.class);

        Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
                .thenReturn(value);

        roller = new DefaultRoller();

        itrValues = roller.roll(dice, mapper).getMappedRollResults().iterator();

        Assert.assertEquals(itrValues.next(), value);
        Assert.assertEquals(itrValues.next(), value);
        Assert.assertEquals(itrValues.next(), value);
        Assert.assertEquals(itrValues.next(), value);
        Assert.assertEquals(itrValues.next(), value);
    }

    @Test(dataProvider = DATA)
    public final void testRollMapper_Default_ResultsEqual(
            final Integer quantity, final Integer sides) {
        final Dice dice;
        final Roller roller;
        final RollerResult<Integer> result;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(quantity);
        Mockito.when(dice.getSides()).thenReturn(sides);

        roller = new DefaultRoller();

        result = roller.roll(dice);

        Assert.assertEquals(result.getBareRollResults(),
                result.getMappedRollResults());
    }

    @SuppressWarnings("unchecked")
    @Test
    public final void testRollMapper_Returns() {
        final Dice dice;
        final Roller roller;
        final RollMapper<Integer> mapper;
        final Iterator<Integer> itrValues;

        dice = Mockito.mock(Dice.class);

        Mockito.when(dice.getQuantity()).thenReturn(3);
        Mockito.when(dice.getSides()).thenReturn(6);

        mapper = Mockito.mock(RollMapper.class);

        Mockito.when(mapper.getValueFor(Matchers.any(Integer.class)))
                .thenReturn(11, 14, 1);

        roller = new DefaultRoller();

        itrValues = roller.roll(dice, mapper).getMappedRollResults().iterator();

        Assert.assertEquals(itrValues.next(), (Integer) 11);
        Assert.assertEquals(itrValues.next(), (Integer) 14);
        Assert.assertEquals(itrValues.next(), (Integer) 1);
    }

}
