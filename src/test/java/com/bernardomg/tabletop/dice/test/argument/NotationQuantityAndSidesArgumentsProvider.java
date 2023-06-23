/**
 * Copyright 2014-2022 the original author or authors
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
 * Tests arguments using notation for a single set of dice, and the quantity and sides from said notation.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class NotationQuantityAndSidesArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d1", 1, 1), Arguments.of("1d6", 1, 6), Arguments.of("-1d6", -1, 6),
            Arguments.of("0d6", 0, 6), Arguments.of("1d0", 1, 0),
            Arguments.of(Integer.MAX_VALUE + "d" + Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

}
