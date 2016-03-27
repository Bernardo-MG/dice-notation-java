
package com.wandrell.tabletop.dice.test.unit.parser.exception;

import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.parser.DiceExpressionParser;

public final class TestExceptionDiceFormulaParser {

    private final DiceExpressionParser parser;

    {
        parser = new DiceExpressionParser();
    }

    public TestExceptionDiceFormulaParser() {
        super();
    }

    @Test(expectedExceptions = Exception.class)
    public final void testParseDice_Empty() {
        parser.parse("");
    }

    @Test(expectedExceptions = Exception.class)
    public final void testParseDice_Invalid() {
        parser.parse("abc");
    }

}
