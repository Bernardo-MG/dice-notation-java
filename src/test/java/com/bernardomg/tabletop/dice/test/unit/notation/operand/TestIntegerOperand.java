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

package com.bernardomg.tabletop.dice.test.unit.notation.operand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;

/**
 * Units tests for {@link IntegerOperand}, verifying that it can generate a
 * valid notation expression.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public class TestIntegerOperand {

    /**
     * Default constructor.
     */
    public TestIntegerOperand() {
        super();
    }

    /**
     * Verifies that the text expression is generated correctly.
     */
    @Test
    public final void testTextExpression() {
        final DiceNotationExpression operand; // Tested operand

        operand = new IntegerOperand(1);

        Assertions.assertEquals("1", operand.getExpression());
    }

}
