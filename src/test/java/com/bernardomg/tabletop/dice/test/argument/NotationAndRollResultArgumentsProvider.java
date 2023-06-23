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
 * Tests arguments using notation which always gives the same result, and said roll.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class NotationAndRollResultArgumentsProvider implements ArgumentsProvider {

    @Override
    public final Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of("1d1", 1), Arguments.of("1d1+2d1", 3), Arguments.of("5+d1", 6),
            Arguments.of("5+2d1", 7), Arguments.of("2d1+5", 7), Arguments.of("1+2+3", 6), Arguments.of("1+2+3+4+5", 15),
            Arguments.of("1+2", 3), Arguments.of("1+-2", -1), Arguments.of("-1+2", 1), Arguments.of("-1-2-3", -6),
            Arguments.of("1+2*3", 7), Arguments.of("1+2-3", 0), Arguments.of("1+-2-3", -4), Arguments.of("6/2+1", 4),
            Arguments.of("6/3-3", -1), Arguments.of("2*3+2", 8), Arguments.of("2*4/2", 4), Arguments.of("2*3-3", 3),
            Arguments.of("1-2+3", 2), Arguments.of("3-1+2", 4), Arguments.of("2-8/2", -2), Arguments.of("1-2*3", -5),
            Arguments.of("3--1+2", 6), Arguments.of("3--1+-2", 2), Arguments.of("1d1+3+d1+12d1+d1", 18),
            Arguments.of("(1d1+2d1)*3d1", 9), Arguments.of("1d1+3*4/2", 7), Arguments.of("-1d1", -1),
            Arguments.of("d1", 1), Arguments.of("1d0", 0), Arguments.of("1d1", 1), Arguments.of("0d1", 0),
            Arguments.of("6d1/2d1", 3), Arguments.of("10/2d1", 5), Arguments.of("20d1/2", 10), Arguments.of("4/2", 2),
            Arguments.of("1d1*2d1", 2), Arguments.of("3d1*2d1", 6), Arguments.of("5*2d1", 10),
            Arguments.of("2d1*5", 10), Arguments.of("1*2", 2), Arguments.of("12", 12), Arguments.of("-12", -12),
            Arguments.of("001200", 1200), Arguments.of("(1+2)*3", 9), Arguments.of("(1)", 1),
            Arguments.of("-1d1-2d1", -3), Arguments.of("1d1-2d1", -1), Arguments.of("1d1+3+2d1", 6),
            Arguments.of("1d1+2d1*3d1", 7), Arguments.of("5-2d1", 3), Arguments.of("2d1-5", -3),
            Arguments.of("1-2-3", -4), Arguments.of("1-2-3-4-5", -13), Arguments.of("1-2", -1), Arguments.of("1--2", 3),
            Arguments.of("-1-2", -3));
    }

}
