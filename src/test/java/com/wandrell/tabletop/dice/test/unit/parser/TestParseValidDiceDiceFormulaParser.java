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

package com.wandrell.tabletop.dice.test.unit.parser;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;
import com.wandrell.tabletop.dice.test.util.config.factory.parameter.DiceValuesTestParametersFactory;

public final class TestParseValidDiceDiceFormulaParser {

    protected static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return DiceValuesTestParametersFactory.getInstance().getDiceAndText();
    }

    private final DefaultDiceNotationParser parser;

    {
        parser = new DefaultDiceNotationParser();
    }

    public TestParseValidDiceDiceFormulaParser() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testParse_Dice_Valid(final String text,
            final Integer quantity, final Integer sides) {
        final DiceExpression formula;
        final DiceOperand dice;

        formula = parser.parse(text);

        dice = (DiceOperand) formula.getComponents().iterator().next();

        Assert.assertEquals(dice.getDice().getDice().getQuantity(), quantity);
        Assert.assertEquals(dice.getDice().getDice().getSides(), sides);
    }

}
