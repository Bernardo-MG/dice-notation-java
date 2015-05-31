package com.wandrell.tabletop.testing.dice.test.unit.formula;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DefaultDiceExpression;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;

public final class TestDefaultDiceFormula {

    public TestDefaultDiceFormula() {
        super();
    }

    @Test
    public final void testGetPrintableText() {
        final DiceExpression formula;
        DiceExpressionComponent component;

        formula = new DefaultDiceExpression();

        component = Mockito.mock(DiceExpressionComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("A");

        formula.addDiceNotationComponent(component);

        component = Mockito.mock(DiceExpressionComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("B");

        formula.addDiceNotationComponent(component);

        component = Mockito.mock(DiceExpressionComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("A");

        formula.addDiceNotationComponent(component);

        Assert.assertEquals(formula.getPrintableText(), "A B A");
    }

}
