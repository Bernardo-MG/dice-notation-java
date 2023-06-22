
package com.bernardomg.tabletop.dice.test.argument;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public final class NotationArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d20+2d6"), Arguments.of("5+2d6"), Arguments.of("2d6+5"), Arguments.of("1d6"),
            Arguments.of("1d20-5*1d8+2d6/3d12"), Arguments.of("1d20-2d6"), Arguments.of("5-2d6"), Arguments.of("2d6-5"),
            Arguments.of("1+2"), Arguments.of("1+2+3"), Arguments.of("1+2+3+4+5"), Arguments.of("1+2-3"),
            Arguments.of("1-2"), Arguments.of("1-2-3"), Arguments.of("1-2-3-4-5"), Arguments.of("3-1+2"));
    }

}
