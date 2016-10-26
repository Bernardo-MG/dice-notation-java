/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.operand.DiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.SubtractionOperation;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.parser.DiceNotationParser;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Integration tests for {@code DefaultDiceNotationParser}, checking that it
 * parses complex operations.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>A complex operation is parsed correctly.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITDefaultDiceNotationParserComplex {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationParserComplex() {
        super();
    }

    /**
     * Tests that a complex operation is parsed correctly.
     */
    @Test
    public final void testParse_Complex() {
        final DiceNotationParser parser;
        final SubtractionOperation operationFirst;
        final AdditionOperation operationSecond;
        final IntegerOperand integer;
        final DiceOperand diceLeftmost;
        final DiceOperand dice;
        final String notation;

        parser = new DefaultDiceNotationParser(new DefaultRoller());

        notation = "1d20-5+2d6";

        operationFirst = (SubtractionOperation) parser.parse(notation);

        diceLeftmost = (DiceOperand) operationFirst.getLeft();
        operationSecond = (AdditionOperation) operationFirst.getRight();

        integer = (IntegerOperand) operationSecond.getLeft();
        dice = (DiceOperand) operationSecond.getRight();

        Assert.assertEquals(diceLeftmost.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(diceLeftmost.getDice().getSides(), (Integer) 20);

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operationFirst.getExpression(), notation);
    }

}
