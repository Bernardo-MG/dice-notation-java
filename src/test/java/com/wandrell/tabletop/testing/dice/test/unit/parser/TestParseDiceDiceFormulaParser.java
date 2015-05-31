package com.wandrell.tabletop.testing.dice.test.unit.parser;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceFormula;
import com.wandrell.tabletop.dice.notation.constant.DiceConstant;
import com.wandrell.tabletop.dice.parser.DiceFormulaParser;
import com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter.DiceValuesTestParametersFactory;

public final class TestParseDiceDiceFormulaParser {

    protected static final String             DATA = "data";
    private final Parser<String, DiceFormula> parser;

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceAndText();
    }

    {
        parser = new DiceFormulaParser();
    }

    public TestParseDiceDiceFormulaParser() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testParse_Dice_Valid(final String text,
            final Integer quantity, final Integer sides) throws Exception {
        final DiceFormula formula;
        final DiceConstant dice;

        formula = parser.parse(text);

        dice = (DiceConstant) formula.getComponents().iterator().next();

        Assert.assertEquals(dice.getDice().getQuantity(), quantity);
        Assert.assertEquals(dice.getDice().getSides(), sides);
    }

}
