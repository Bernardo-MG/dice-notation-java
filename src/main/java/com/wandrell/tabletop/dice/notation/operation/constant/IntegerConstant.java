package com.wandrell.tabletop.dice.notation.operation.constant;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operation.Operand;

public final class IntegerConstant implements DiceExpressionComponent, Operand {

    private final Integer value;

    public IntegerConstant(final Integer value) {
        super();

        this.value = value;
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

        final IntegerConstant other;

        other = (IntegerConstant) obj;

        return Objects.equal(value, other.value);
    }

    @Override
    public final String getPrintableText() {
        return getValue().toString();
    }

    @Override
    public final Integer getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("value", value).toString();
    }

}
