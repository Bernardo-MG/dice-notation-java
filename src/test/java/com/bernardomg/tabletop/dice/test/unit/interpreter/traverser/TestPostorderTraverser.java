/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.interpreter.traverser;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.interpreter.PostorderTraverser;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("PostorderTraverser parses the expression tree as expected")
public final class TestPostorderTraverser {

    public TestPostorderTraverser() {
        super();
    }

    @Test
    @DisplayName("Parses the tree correctly")
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

        // 1 2 + 3 -
        result = new PostorderTraverser().transform(subtraction);

        Assertions.assertEquals(5,
                StreamSupport.stream(result.spliterator(), false).count());

        exps = result.iterator();

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(Integer.valueOf(1),
                ((IntegerOperand) exp).getValue());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(Integer.valueOf(2),
                ((IntegerOperand) exp).getValue());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof BinaryOperation);

        exp = exps.next();
        Assertions.assertTrue(exp instanceof IntegerOperand);
        Assertions.assertEquals(Integer.valueOf(3),
                ((IntegerOperand) exp).getValue());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof BinaryOperation);
    }

}
