/**
 * Copyright 2014-2023 the original author or authors
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

package com.bernardomg.tabletop.dice.test.argument;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 * Tests arguments using dice notation.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class NotationArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d20+2d6"), Arguments.of("5+2d6"), Arguments.of("2d6+5"), Arguments.of("1d6"),
            Arguments.of("1d20-5*1d8+2d6/3d12"), Arguments.of("1d20-2d6"), Arguments.of("5-2d6"), Arguments.of("2d6-5"),
            Arguments.of("1+2"), Arguments.of("1+2+3"), Arguments.of("1+2+3+4+5"), Arguments.of("1+2-3"),
            Arguments.of("1-2"), Arguments.of("1-2-3"), Arguments.of("1-2-3-4-5"), Arguments.of("3-1+2"));
    }

}
