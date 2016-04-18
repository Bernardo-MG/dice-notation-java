/**
 * Copyright 2014-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dice.notation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

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
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final DefaultDiceExpression other;

		other = (DefaultDiceExpression) obj;

		return Objects.equal(components, other.components);
	}

	@Override
	public final Collection<DiceExpressionComponent> getComponents() {
		return Collections.unmodifiableCollection(getComponentsModifiable());
	}

	@Override
	public final String getStringRepresentation() {
		final StringBuilder builder;

		builder = new StringBuilder();

		for (final DiceExpressionComponent component : getComponentsModifiable()) {
			if (builder.length() > 0) {
				builder.append(' ');
			}

			builder.append(component.getStringRepresentation());
		}

		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(components);
	}

	@Override
	public final void removeDiceNotationComponent(
			final DiceExpressionComponent component) {
		getComponentsModifiable().remove(component);
	}

	@Override
	public final String toString() {
		return MoreObjects.toStringHelper(this).add("components", components)
				.toString();
	}

	private final Collection<DiceExpressionComponent> getComponentsModifiable() {
		return components;
	}

}
