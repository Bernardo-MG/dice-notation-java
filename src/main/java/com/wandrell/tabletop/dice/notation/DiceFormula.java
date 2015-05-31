package com.wandrell.tabletop.dice.notation;

import java.util.Collection;

public interface DiceFormula {

    public void addDiceNotationComponent(final DiceFormulaComponent component);

    public Collection<DiceFormulaComponent> getComponents();

    public String getPrintableText();

    public void
            removeDiceNotationComponent(final DiceFormulaComponent component);

}
