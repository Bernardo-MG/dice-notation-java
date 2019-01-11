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
 * that it parses complex operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserComplexStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserComplexStructure() {
        super();
    }

    /**
     * Verifies that a complex operation is parsed correctly.
     */
    @Test
    public final void testParse_Complex_Structure() {
        final AdditionOperation operationFirst;
        final SubtractionOperation operationSecond;
        final IntegerOperand integer;
        final DiceOperand leftDice;
        final DiceOperand rightDice;
        final String notation;

        notation = "1d20-5+2d6";

        // ((1d20-5)+2d6)
        operationFirst = (AdditionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        operationSecond = (SubtractionOperation) operationFirst.getLeft();
        rightDice = (DiceOperand) operationFirst.getRight();

        leftDice = (DiceOperand) operationSecond.getLeft();
        integer = (IntegerOperand) operationSecond.getRight();

        // Leftmost dice was parsed correctly
        Assertions.assertEquals((Integer) 2, rightDice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, rightDice.getDice().getSides());

        // Rightmost dice was parsed correctly
        Assertions.assertEquals((Integer) 1, leftDice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 20, leftDice.getDice().getSides());

        // Integer value was parsed correctly
        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

}
