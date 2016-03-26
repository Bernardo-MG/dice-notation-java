
package com.wandrell.tabletop.dice.test.unit.dice;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceValuesTestParametersFactory;

public final class TestPrintableTextDefaultDice {

    protected static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceAndText();
    }

    public TestPrintableTextDefaultDice() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testText(final String text, final Integer quantity,
            final Integer sides) {
        final Dice dice;

        dice = new DefaultDice(quantity, sides);

        Assert.assertEquals(dice.getStringRepresentation(), text);
    }

}
