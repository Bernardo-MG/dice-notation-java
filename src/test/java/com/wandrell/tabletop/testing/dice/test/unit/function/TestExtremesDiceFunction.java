package com.wandrell.tabletop.testing.dice.test.unit.function;

import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.function.DiceFunction;
import com.wandrell.tabletop.dice.function.ExtremesDiceFunction;
import com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter.DiceFunctionValuesTestParametersFactory;

public final class TestExtremesDiceFunction {

    protected static final String HIGHEST_KEEP   = "highest_keep";
    protected static final String HIGHEST_REMOVE = "highest_remove";
    protected static final String LOWEST_KEEP    = "lowest_keep";
    protected static final String LOWEST_REMOVE  = "lowest_remove";

    @DataProvider(name = HIGHEST_KEEP)
    public final static Iterator<Object[]> getHighestKeep() throws Exception {
        return DiceFunctionValuesTestParametersFactory.getInstance()
                .getHighestKeep();
    }

    @DataProvider(name = HIGHEST_REMOVE)
    public final static Iterator<Object[]> getHighestRemove() throws Exception {
        return DiceFunctionValuesTestParametersFactory.getInstance()
                .getHighestRemove();
    }

    @DataProvider(name = LOWEST_KEEP)
    public final static Iterator<Object[]> getLowestKeep() throws Exception {
        return DiceFunctionValuesTestParametersFactory.getInstance()
                .getLowestKeep();
    }

    @DataProvider(name = LOWEST_REMOVE)
    public final static Iterator<Object[]> getLowestRemove() throws Exception {
        return DiceFunctionValuesTestParametersFactory.getInstance()
                .getLowestRemove();
    }

    public TestExtremesDiceFunction() {
        super();
        // TODO: Make these tests parameterized
    }

    @Test(dataProvider = HIGHEST_KEEP)
    public final void
            testKeep_Highest(final Integer count,
                    final Collection<Integer> rolls,
                    final Collection<Integer> expected) {
        final DiceFunction function;

        function = new ExtremesDiceFunction(
                ExtremesDiceFunction.Extreme.HIGHEST,
                ExtremesDiceFunction.KeepRemove.KEEP, count);

        Assert.assertEquals(function.applyFunction(rolls), expected);
    }

    @Test(dataProvider = LOWEST_KEEP)
    public final void
            testKeep_Lowest(final Integer count,
                    final Collection<Integer> rolls,
                    final Collection<Integer> expected) {
        final DiceFunction function;

        function = new ExtremesDiceFunction(
                ExtremesDiceFunction.Extreme.LOWEST,
                ExtremesDiceFunction.KeepRemove.KEEP, count);

        Assert.assertEquals(function.applyFunction(rolls), expected);
    }

    @Test(dataProvider = HIGHEST_REMOVE)
    public final void
            testRemove_Highest(final Integer count,
                    final Collection<Integer> rolls,
                    final Collection<Integer> expected) {
        final DiceFunction function;

        function = new ExtremesDiceFunction(
                ExtremesDiceFunction.Extreme.HIGHEST,
                ExtremesDiceFunction.KeepRemove.REMOVE, count);

        Assert.assertEquals(function.applyFunction(rolls), expected);
    }

    @Test(dataProvider = LOWEST_REMOVE)
    public final void
            testRemove_Lowest(final Integer count,
                    final Collection<Integer> rolls,
                    final Collection<Integer> expected) {
        final DiceFunction function;

        function = new ExtremesDiceFunction(
                ExtremesDiceFunction.Extreme.LOWEST,
                ExtremesDiceFunction.KeepRemove.REMOVE, count);

        Assert.assertEquals(function.applyFunction(rolls), expected);
    }

}
