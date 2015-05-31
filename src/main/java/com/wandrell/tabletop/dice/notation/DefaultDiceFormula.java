package com.wandrell.tabletop.dice.notation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class DefaultDiceFormula implements DiceFormula {

    private final Collection<DiceFormulaComponent> components = new LinkedList<>();

    public DefaultDiceFormula() {
        super();
    }

    public DefaultDiceFormula(final DiceFormulaComponent... components) {
        super();

        for (final DiceFormulaComponent component : components) {
            getComponentsModifiable().add(component);
        }
    }

    @Override
    public final void addDiceNotationComponent(
            final DiceFormulaComponent component) {
        getComponentsModifiable().add(component);
    }

    @Override
    public final Collection<DiceFormulaComponent> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    @Override
    public final String getPrintableText() {
        final StringBuilder builder;

        builder = new StringBuilder();

        for (final DiceFormulaComponent component : getComponentsModifiable()) {
            if (builder.length() > 0) {
                builder.append(' ');
            }

            builder.append(component.getPrintableText());
        }

        return builder.toString();
    }

    @Override
    public final void removeDiceNotationComponent(
            final DiceFormulaComponent component) {
        getComponentsModifiable().remove(component);
    }

    private final Collection<DiceFormulaComponent> getComponentsModifiable() {
        return components;
    }

}
