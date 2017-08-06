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

package com.wandrell.tabletop.dice.test.unit.notation.operand;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.wandrell.tabletop.dice.roller.DefaultRoller;

/**
 * Units tests for {@code DefaultDiceOperand}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TestDefaultDiceOperand {

    /**
     * Default constructor.
     */
    public TestDefaultDiceOperand() {
        super();
    }

    /**
     * Tests that the text expression is generated correctly.
     */
    @Test
    public final void testTextExpression() {
        final DiceNotationExpression diceOperand; // Tested operand
        final Dice dice;                          // Dice for the operand

        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(6);

        diceOperand = new DefaultDiceOperand(dice, new DefaultRoller());

        Assert.assertEquals(diceOperand.getExpression(), "2d6");
    }

}
