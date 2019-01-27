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

package com.bernardomg.tabletop.dice.test.unit.transformer.inorder;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.transformer.InorderTransformer;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link InorderTransformer}, verifying that it transforms a
 * tree correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestInorderTransformer {

    /**
     * Default constructor.
     */
    public TestInorderTransformer() {
        super();
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testList() {
        final AdditionOperation addition;
        final SubtractionOperation subtraction;
        final DiceNotationExpression left;
        final DiceNotationExpression right;
        final DiceNotationExpression rightSecond;
        final Iterable<DiceNotationExpression> result;
        final Iterator<DiceNotationExpression> exps;
        DiceNotationExpression exp;

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 + 2
        addition = new AdditionOperation(left, right);

        rightSecond = new IntegerOperand(3);

        // (1 + 2) - 3
        subtraction = new SubtractionOperation(addition, rightSecond);

        // 1 + 2 - 3
        result = new InorderTransformer().transform(subtraction);

        Assertions.assertEquals(5, Iterables.size(result));

        exps = result.iterator();

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(new Integer(1),
                ((IntegerOperand) exp).getValue());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof AdditionOperation);

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(new Integer(2),
                ((IntegerOperand) exp).getValue());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof SubtractionOperation);

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(new Integer(3),
                ((IntegerOperand) exp).getValue());
    }

}
