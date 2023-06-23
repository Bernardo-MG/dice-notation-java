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

package com.bernardomg.tabletop.dice.test.integration.parser.exception;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.test.argument.InvalidNotationArgumentsProvider;

@DisplayName("DefaultDiceParser handles exceptions")
public final class ITDefaultDiceParserException {

    public ITDefaultDiceParserException() {
        super();
    }

    @ParameterizedTest(name = "Notation: {0}")
    @ArgumentsSource(InvalidNotationArgumentsProvider.class)
    @DisplayName("An invalid notation causes an exception")
    public final void testParse(final String notation) {
        final ThrowingCallable closure;

        closure = () -> new DefaultDiceParser().parse(notation);

        Assertions.assertThatThrownBy(closure)
            .isInstanceOf(Exception.class);
    }

}
