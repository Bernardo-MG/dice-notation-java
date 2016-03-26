
package com.wandrell.tabletop.dice.test.unit.parser.exception;

import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.parser.DiceExpressionParser;

public final class TestExceptionDiceFormulaParser {

    private final Parser<String, DiceExpression> parser;

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
