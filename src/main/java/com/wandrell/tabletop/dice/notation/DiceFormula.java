package com.wandrell.tabletop.dice.notation;

import java.util.Collection;

public interface DiceFormula {

    public void addDiceNotationComponent(final DiceNotationComponent component);

    public Collection<DiceNotationComponent> getComponents();

    public String getPrintableText();

    public void removeDiceNotationComponent(
            final DiceNotationComponent component);

}
