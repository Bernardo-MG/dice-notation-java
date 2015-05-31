package com.wandrell.tabletop.dice.notation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public final class DefaultDiceExpression implements DiceExpression {

    private final Collection<DiceExpressionComponent> components = new LinkedList<>();

    public DefaultDiceExpression() {
        super();
    }

    public DefaultDiceExpression(final DiceExpressionComponent... components) {
        super();

        for (final DiceExpressionComponent component : components) {
            getComponentsModifiable().add(component);
        }
    }

    @Override
    public final void addDiceNotationComponent(
            final DiceExpressionComponent component) {
        getComponentsModifiable().add(component);
    }

    @Override
    public final Collection<DiceExpressionComponent> getComponents() {
        return Collections.unmodifiableCollection(getComponentsModifiable());
    }

    @Override
    public final String getPrintableText() {
        final StringBuilder builder;

        builder = new StringBuilder();

        for (final DiceExpressionComponent component : getComponentsModifiable()) {
            if (builder.length() > 0) {
                builder.append(' ');
            }

            builder.append(component.getPrintableText());
        }

        return builder.toString();
    }

    @Override
    public final void removeDiceNotationComponent(
            final DiceExpressionComponent component) {
        getComponentsModifiable().remove(component);
    }

    private final Collection<DiceExpressionComponent> getComponentsModifiable() {
        return components;
    }

}
