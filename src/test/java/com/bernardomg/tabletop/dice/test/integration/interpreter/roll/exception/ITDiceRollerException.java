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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.exception;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller handles exceptions")
public final class ITDiceRollerException {

    public ITDiceRollerException() {
        super();
    }

    @Test
    @DisplayName("Divide by zero throws an exception")
    public final void testParse_DivideByZero() {
        final DiceNotationExpression parsed; // Parsed expression
        final ThrowingCallable       closure;

        parsed = new DefaultDiceParser().parse("1/0");

        closure = () -> new DiceRoller().transform(parsed);

        Assertions.assertThatThrownBy(closure)
            .isInstanceOf(Exception.class);
    }

}
