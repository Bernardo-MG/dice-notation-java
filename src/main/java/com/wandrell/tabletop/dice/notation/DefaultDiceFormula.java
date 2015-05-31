package com.wandrell.tabletop.dice.notation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class DefaultDiceFormula implements DiceFormula {

    private final Collection<DiceNotationComponent> components = new LinkedList<>();

    public DefaultDiceFormula() {
        super();
    }

    @Override
    public final void addDiceNotationComponent(
            final DiceNotationComponent component) {
        getComponentsModifiable().add(component);
    }

    @Override
    public final Collection<DiceNotationComponent> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    @Override
    public final String getPrintableText() {
        final StringBuilder builder;

        builder = new StringBuilder();

        for (final DiceNotationComponent component : getComponentsModifiable()) {
            if (builder.length() > 0) {
                builder.append(' ');
            }

            builder.append(component.getPrintableText());
        }

        return builder.toString();
    }

    @Override
    public final void removeDiceNotationComponent(
            final DiceNotationComponent component) {
        getComponentsModifiable().remove(component);
    }

    private final Collection<DiceNotationComponent> getComponentsModifiable() {
        return components;
    }

}
