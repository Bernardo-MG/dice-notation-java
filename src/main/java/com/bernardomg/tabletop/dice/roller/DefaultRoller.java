
package com.bernardomg.tabletop.dice.roller;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;
import com.bernardomg.tabletop.dice.visitor.EmptyRollTransformer;
import com.bernardomg.tabletop.dice.visitor.RollTransformer;

public final class DefaultRoller implements Roller {

    /**
     * The random numbers generator.
     * <p>
     * Combined with the data in the rolled this, this will generate a random
     * value in an interval.
     */
    private final NumberGenerator numberGenerator;

    private Integer               rollIndex = 0;

    private final RollTransformer transformer;

    public DefaultRoller() {
        super();

        numberGenerator = new RandomNumberGenerator();

        transformer = new EmptyRollTransformer();
    }

    public DefaultRoller(final NumberGenerator generator) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");

        transformer = new EmptyRollTransformer();
    }

    public DefaultRoller(final NumberGenerator generator,
            final RollTransformer trans) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");
        transformer = checkNotNull(trans,
                "Received a null pointer as transformer");
    }

    public DefaultRoller(final RollTransformer trans) {
        super();

        transformer = checkNotNull(trans,
                "Received a null pointer as transformer");

        numberGenerator = new RandomNumberGenerator();
    }

    @Override
    public final RollResult roll(final Dice dice) {
        final Iterable<Integer> rolls;
        final RollResult result;
        final RollResult finalResult;
        Integer total;

        rolls = numberGenerator.generate(dice);

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        result = new DefaultRollResult(dice, rolls, total);
        finalResult = transformer.transform(result, rollIndex);

        rollIndex++;

        return finalResult;
    }

}
