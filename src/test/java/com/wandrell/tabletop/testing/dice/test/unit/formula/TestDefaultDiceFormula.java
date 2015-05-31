package com.wandrell.tabletop.testing.dice.test.unit.formula;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DefaultDiceFormula;
import com.wandrell.tabletop.dice.notation.DiceFormula;
import com.wandrell.tabletop.dice.notation.DiceNotationComponent;

public final class TestDefaultDiceFormula {

    public TestDefaultDiceFormula() {
        super();
    }

    @Test
    public final void testGetPrintableText() {
        final DiceFormula formula;
        DiceNotationComponent component;

        formula = new DefaultDiceFormula();

        component = Mockito.mock(DiceNotationComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("A");

        formula.addDiceNotationComponent(component);

        component = Mockito.mock(DiceNotationComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("B");

        formula.addDiceNotationComponent(component);

        component = Mockito.mock(DiceNotationComponent.class);
        Mockito.when(component.getPrintableText()).thenReturn("A");

        formula.addDiceNotationComponent(component);

        Assert.assertEquals(formula.getPrintableText(), "A B A");
    }

}
