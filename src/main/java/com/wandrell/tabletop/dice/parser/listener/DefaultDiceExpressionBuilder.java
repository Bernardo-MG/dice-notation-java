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
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarBaseListener;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser.BinaryOpContext;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser.DiceContext;
import com.wandrell.tabletop.dice.generated.DiceNotationGrammarParser.ValueContext;
import com.wandrell.tabletop.dice.notation.DiceNotationExpression;
import com.wandrell.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.roller.Roller;

/**
 * Creates a {@code DiceExpressionComponent} from an ANTLR4 parser by using the
 * visitor pattern.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultDiceExpressionBuilder extends
        DiceNotationGrammarBaseListener implements DiceExpressionBuilder {

    /**
     * Operator which indicates the operation is an addition.
     */
    private static final String                 ADDITION_OPERATOR = "+";

    /**
     * Root of the tree of dice notation model objects.
     * <p>
     * This will be updated as the tree is generated, and will be the final
     * value returned by the builder.
     */
    private DiceNotationExpression              root;

    /**
     * Stack to store operands from the outer nodes in an operation.
     * <p>
     * For example, when parsing an addition operation this stack will hold both
     * operands being added together.
     */
    private final Stack<DiceNotationExpression> operandsStack     = new Stack<>();

    /**
     * Roller for the dice expressions.
     * <p>
     * This is used as a dependency on the dice expressions, which require a
     * roller to generate their value.
     */
    private final Roller                        roller;

    /**
     * Constructs a builder with the specified roller.
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
        final BinaryOperation operation;     // Parsed binary operation
        final String operator;               // Operator
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        checkNotNull(ctx, "Received a null pointer as context");

        // Acquired operands
        right = getOperandsStack().pop();
        left = getOperandsStack().pop();

        // Acquires operator
        operator = ctx.OPERATOR().getText();

        // Checks which kind of operation this is and creates it
        if (ADDITION_OPERATOR.equals(operator)) {
            operation = new AdditionOperation(left, right);
        } else {
            operation = new SubstractionOperation(left, right);
        }

        // Adds to the operands stack
        getOperandsStack().push(operation);

        // Sets as the root
        setDiceExpressionRoot(getOperandsStack().peek());
    }

    @Override
    public final void exitDice(final DiceContext ctx) {
        final Dice dice;        // Parsed dice
        final Integer quantity; // Number of dice
        final Integer sides;    // Number of sides

        checkNotNull(ctx, "Received a null pointer as context");

        // Acquires the dice data
        quantity = Integer.parseInt(ctx.quantity().getText());
        sides = Integer.parseInt(ctx.sides().getText());

        // Creates the dice
        dice = new DefaultDice(quantity, sides);

        // Adds to the operands stack
        getOperandsStack().push(new DefaultDiceOperand(dice, getRoller()));

        // Sets as the root
        setDiceExpressionRoot(getOperandsStack().peek());
    }

    @Override
    public final void exitValue(final ValueContext ctx) {
        final Integer value; // Parsed value

        checkNotNull(ctx, "Received a null pointer as context");

        // Acquires the value
        value = Integer.parseInt(ctx.getText());

        // Adds to the operands stack
        getOperandsStack().push(new IntegerOperand(value));

        // Sets as the root
        setDiceExpressionRoot(getOperandsStack().peek());
    }

    @Override
    public final DiceNotationExpression getDiceExpressionRoot() {
        return root;
    }

    /**
     * Returns the operands stack.
     * 
     * @return the operands stack
     */
    private final Stack<DiceNotationExpression> getOperandsStack() {
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

    /**
     * Sets the root for the tree of dice notation model objects.
     * 
     * @param expression
     */
    private final void setDiceExpressionRoot(
            final DiceNotationExpression expression) {
        root = expression;
    }

}
