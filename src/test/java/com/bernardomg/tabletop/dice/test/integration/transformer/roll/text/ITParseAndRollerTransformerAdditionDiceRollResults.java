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

package com.bernardomg.tabletop.dice.test.integration.transformer.roll.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;

/**
 * Integration tests for {@link DiceRoller}, verifying that it returns the
 * expected roll results for addition operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerAdditionDiceRollResults {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerAdditionDiceRollResults() {
        super();
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_DiceAddition_Text() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory result;

        notation = "1d1+2d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + [1, 1]", result.getHistoryText());
    }

}
