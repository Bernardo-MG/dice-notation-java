package com.wandrell.tabletop.testing.dice.test.unit.parser;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceFormula;
import com.wandrell.tabletop.dice.notation.IntegerComponent;
import com.wandrell.tabletop.dice.parser.DiceFormulaParser;
import com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter.DiceValuesTestParametersFactory;

public final class TestIntegerDiceParser {

    protected static final String             DATA = "data";
    private final Parser<String, DiceFormula> parser;

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceAndText();
    }

    {
        parser = new DiceFormulaParser();
    }

    public TestIntegerDiceParser() {
        super();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public final void testParseDice_Empty_Exception() throws Exception {
        parser.parse("");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public final void testParseDice_Invalid_Exception() throws Exception {
        parser.parse("abc");
    }

    @Test
    public final void testParseDice_Number() throws Exception {
        final DiceFormula formula;
        final IntegerComponent value;

        formula = parser.parse("12");

        value = (IntegerComponent) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 12);
    }

    @Test(dataProvider = DATA)
    public final void testParseDice_Valid(final String text,
            final Integer quantity, final Integer sides) throws Exception {
        final DiceFormula formula;
        final Dice dice;

        formula = parser.parse(text);

        dice = (Dice) formula.getComponents().iterator().next();

        Assert.assertEquals(dice.getQuantity(), quantity);
        Assert.assertEquals(dice.getSides(), sides);
    }

    @Test
    public final void testParseDice_Zero() throws Exception {
        final DiceFormula formula;
        final IntegerComponent value;

        formula = parser.parse("0");

        value = (IntegerComponent) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 0);
    }

}
