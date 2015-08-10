package com.wandrell.tabletop.dice.notation.function;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ExtremesDiceFunction implements DiceFunction {

    private final Extreme    extreme;
    private final Integer    functionCount;
    private final KeepRemove keepRemove;

    public enum Extreme {
        HIGHEST, LOWEST
    }

    public enum KeepRemove {
        KEEP, REMOVE
    }

    public ExtremesDiceFunction(final Extreme extreme,
            final KeepRemove addRemove, final Integer count) {
        super();

        checkNotNull(extreme, "Received a null pointer as extreme indicator");
        checkNotNull(addRemove,
                "Received a null pointer as keep or remove indicator");
        checkNotNull(count, "Received a null pointer as count");

        this.extreme = extreme;
        this.keepRemove = addRemove;
        this.functionCount = count;
    }

    @Override
    public final Collection<Integer>
            applyFunction(final Collection<Integer> rolls) {
        final Collection<Integer> result;

        checkNotNull(rolls, "Received a null pointer as rolls");

        if (getCount() >= rolls.size()) {
            if (getKeepRemove() == KeepRemove.REMOVE) {
                result = new LinkedList<>();
            } else {
                result = rolls;
            }
        } else {
            switch (getExtreme()) {
                case HIGHEST:
                    switch (getKeepRemove()) {
                        case KEEP:
                            result = removeLowest(rolls,
                                    rolls.size() - getCount());
                            break;
                        case REMOVE:
                            result = keepLowest(rolls,
                                    rolls.size() - getCount());
                            break;
                        default:
                            result = new LinkedList<>();
                    }
                    break;
                case LOWEST:
                    switch (getKeepRemove()) {
                        case KEEP:
                            result = keepLowest(rolls, getCount());
                            break;
                        case REMOVE:
                            result = removeLowest(rolls, getCount());
                            break;
                        default:
                            result = new LinkedList<>();
                    }
                    break;
                default:
                    result = new LinkedList<>();
            }
        }

        return result;
    }

    private final Integer getCount() {
        return functionCount;
    }

    private final Extreme getExtreme() {
        return extreme;
    }

    private final KeepRemove getKeepRemove() {
        return keepRemove;
    }

    private final Collection<Integer>
            keepLowest(final Collection<Integer> rolls, final Integer count) {
        List<Integer> values;

        values = new LinkedList<Integer>(rolls);
        Collections.sort(values);
        values = values.subList(0, count);

        return keepRollsIn(rolls, values);
    }

    private final Collection<Integer> keepRollsIn(
            final Collection<Integer> rolls, final List<Integer> values) {
        final Collection<Integer> result;
        final Iterator<Integer> itrRolls;
        Integer roll;
        int pos;

        result = new LinkedList<>();
        itrRolls = rolls.iterator();
        while ((values.size() > 0) && (itrRolls.hasNext())) {
            roll = itrRolls.next();

            pos = Collections.binarySearch(values, roll);
            if (pos >= 0) {
                result.add(roll);
                values.remove(pos);
            }
        }

        return result;
    }

    private final Collection<Integer>
            removeLowest(final Collection<Integer> rolls, final Integer count) {
        List<Integer> values;

        values = new LinkedList<Integer>(rolls);
        Collections.sort(values);
        values = values.subList(count, values.size());

        return keepRollsIn(rolls, values);
    }

}
