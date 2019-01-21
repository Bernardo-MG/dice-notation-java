/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.transformer.roll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;
import com.bernardomg.tabletop.dice.parser.transformer.RollerTransformer;

/**
 * Integration test for {@link RollerTransformer}, verifying that it transforms
 * parsed expressions.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerException {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerException() {
        super();
    }

    /**
     * Verifies that dividing by zero causes an exception.
     */
    @Test
    public final void testParse_DivideByZero() {
        final DiceNotationExpression parsed; // Parsed expression
        final Executable closure;

        parsed = new DefaultDiceNotationExpressionParser().parse("1/0");

        closure = () -> new RollerTransformer().transform(parsed);

        Assertions.assertThrows(Exception.class, closure);
    }

}
