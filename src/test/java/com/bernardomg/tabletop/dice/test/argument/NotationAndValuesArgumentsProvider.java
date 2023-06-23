
package com.bernardomg.tabletop.dice.test.argument;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public final class NotationAndValuesArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d1", 1, 1), Arguments.of("1d6", 1, 6), Arguments.of("-1d6", -1, 6),
            Arguments.of("0d6", 0, 6), Arguments.of("1d0", 1, 0), Arguments.of("1D6", 1, 6), Arguments.of("d6", 1, 6),
            Arguments.of(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

}
