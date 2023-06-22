
package com.bernardomg.tabletop.dice.test.argument;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public final class NotationAndRollsArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d1+2d1", "1 + [1, 1]"), Arguments.of("1d1+3+2d1", "1 + 3 + [1, 1]"),
            Arguments.of("1+2-3", "1 + 2 - 3"), Arguments.of("1+(2-3)", "1 + 2 - 3"),
            Arguments.of("1d1+4d1/2d1", "1 + [1, 1, 1, 1] / [1, 1]"),
            Arguments.of("1d1+2d1*3d1", "1 + [1, 1] * [1, 1, 1]"));
    }

}
