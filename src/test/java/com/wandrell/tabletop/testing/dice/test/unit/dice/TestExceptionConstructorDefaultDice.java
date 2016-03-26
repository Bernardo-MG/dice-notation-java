
package com.wandrell.tabletop.testing.dice.test.unit.dice;

import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.DefaultDice;

public final class TestExceptionConstructorDefaultDice {

    public TestExceptionConstructorDefaultDice() {
        super();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testQuantity_Negative() {
        new DefaultDice(-1, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSides_Negative() {
        new DefaultDice(0, -1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSides_Zero() {
        new DefaultDice(0, 0);
    }

}
