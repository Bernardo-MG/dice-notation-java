
package com.bernardomg.tabletop.dice.roll;

import static com.google.common.base.Preconditions.checkNotNull;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.DefaultRollResult;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;
import com.bernardomg.tabletop.dice.visitor.EmptyRollTransformer;
import com.bernardomg.tabletop.dice.visitor.RollTransformer;

public final class DefaultRollGenerator implements RollGenerator {

    /**
     * The random numbers generator.
     * <p>
     * Combined with the data in the rolled this, this will generate a random
     * value in an interval.
     */
    private final NumberGenerator numberGenerator;

    private Integer               rollIndex = 0;

    private final RollTransformer transformer;

    public DefaultRollGenerator() {
        super();

        numberGenerator = new RandomNumberGenerator();

        transformer = new EmptyRollTransformer();
    }

    public DefaultRollGenerator(final NumberGenerator generator) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");

        transformer = new EmptyRollTransformer();
    }

    public DefaultRollGenerator(final NumberGenerator generator,
            final RollTransformer trans) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");
        transformer = checkNotNull(trans,
                "Received a null pointer as transformer");
    }

    public DefaultRollGenerator(final RollTransformer trans) {
        super();

        transformer = checkNotNull(trans,
                "Received a null pointer as transformer");

        numberGenerator = new RandomNumberGenerator();
    }

    @Override
    public final RollResult roll(final Dice dice, final RollTransformer trans) {
        final RollResult result;
        final RollResult finalResult;

        result = getRollResult(dice);
        // TODO: Should chain with the one received
        // TODO: If it can be chained then it can be chained outside this class
        finalResult = transformer.transform(result, rollIndex);

        rollIndex++;

        return finalResult;
    }

    private final RollResult getRollResult(final Dice dice) {
        final Iterable<Integer> rolls;
        Integer total;

        rolls = numberGenerator.generate(dice);

        total = 0;
        for (final Integer roll : rolls) {
            total += roll;
        }

        return new DefaultRollResult(dice, rolls, total);
    }

}
