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

package com.wandrell.tabletop.dice.parser.listener;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Stack;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.generated.DiceNotationBaseListener;
import com.wandrell.tabletop.dice.generated.DiceNotationParser.BinaryOpContext;
import com.wandrell.tabletop.dice.generated.DiceNotationParser.DiceContext;
import com.wandrell.tabletop.dice.generated.DiceNotationParser.ValueContext;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.roller.Roller;

/**
 * Default {@code DiceExpression} builder.
 * <p>
 * It implements the visitor pattern, and will build the {@code DiceExpression}
 * by pieces, after entering or exiting nodes in the parsed tree.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultDiceExpressionBuilder extends
        DiceNotationBaseListener implements DiceExpressionBuilder {

    /**
     * Generated dice expression.
     */
    private DiceExpressionComponent              expression;

    /**
     * Stack to store operands from the outer nodes on operations.
     */
    private final Stack<DiceExpressionComponent> operandsStack = new Stack<>();

    /**
     * Roller for the dice expressions.
     */
    private final Roller                         roller;

    /**
     * Default constructor.
     * 
     * @param roller
     *            roller for the dice expressions
     */
    public DefaultDiceExpressionBuilder(final Roller roller) {
        super();

        this.roller = checkNotNull(roller, "Received a null pointer as roller");
    }

    @Override
    public final void exitBinaryOp(final BinaryOpContext ctx) {
        final BinaryOperation opAdd;
        final String operator;
        final DiceExpressionComponent left;
        final DiceExpressionComponent right;

        checkNotNull(ctx, "Received a null pointer as context");

        operator = ctx.OPERATOR().getText();

        right = getOperandsStack().pop();
        left = getOperandsStack().pop();

        if (operator.equals("+")) {
            opAdd = new AdditionOperation(left, right);
        } else {
            opAdd = new SubstractionOperation(left, right);
        }

        getOperandsStack().push(opAdd);

        expression = getOperandsStack().peek();
    }

    @Override
    public final void exitDice(final DiceContext ctx) {
        final Dice dice;
        final Integer count;
        final Integer sides;

        checkNotNull(ctx, "Received a null pointer as context");

        count = Integer.parseInt(ctx.quantity().getText());
        sides = Integer.parseInt(ctx.sides().getText());

        dice = new DefaultDice(count, sides);

        getOperandsStack().push(new DefaultDiceOperand(dice, getRoller()));

        expression = getOperandsStack().peek();
    }

    @Override
    public final void exitValue(final ValueContext ctx) {
        final Integer value;

        checkNotNull(ctx, "Received a null pointer as context");

        value = Integer.parseInt(ctx.getText());

        getOperandsStack().push(new IntegerOperand(value));

        expression = getOperandsStack().peek();
    }

    @Override
    public final DiceExpressionComponent getDiceExpression() {
        return expression;
    }

    /**
     * Returns the operands stack.
     * 
     * @return the operands stack
     */
    private final Stack<DiceExpressionComponent> getOperandsStack() {
        return operandsStack;
    }

    /**
     * Returns the roller for the dice expressions.
     * 
     * @return the roller for the dice expressions
     */
    private final Roller getRoller() {
        return roller;
    }

}
