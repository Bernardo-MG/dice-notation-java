/**
 * Copyright 2014-2018 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses dice notation expressions for signed dice groups.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSignedDice {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSignedDice() {
        super();
    }

    /**
     * Verifies that dice notation with a signed negative single dice and a
     * single side can be parsed.
     */
    @Test
    public final void testParse_OnesDice_SignedNegative() {
        final SubtractionOperation operation; // Parsed expression
        final IntegerOperand left;            // Left operand
        final DiceOperand right;              // Right operand

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse("-1d1").getRoot();

        left = (IntegerOperand) operation.getLeft();
        right = (DiceOperand) operation.getRight();

        // -1d1 = 0-1d1
        Assertions.assertEquals(new Integer(0), left.getValue());
        Assertions.assertEquals(new Integer(1), right.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), right.getDice().getSides());
    }

    /**
     * Verifies that dice notation with a signed single dice and a single side
     * can be parsed.
     */
    @Test
    public final void testParse_OnesDice_SignedPositive() {
        final AdditionOperation operation; // Parsed expression
        final IntegerOperand left;         // Left operand
        final DiceOperand right;           // Right operand

        operation = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse("+1d1").getRoot();

        left = (IntegerOperand) operation.getLeft();
        right = (DiceOperand) operation.getRight();

        // +1d1 = 0+1d1
        Assertions.assertEquals(new Integer(0), left.getValue());
        Assertions.assertEquals(new Integer(1), right.getDice().getQuantity());
        Assertions.assertEquals(new Integer(1), right.getDice().getSides());
    }

}
