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

package com.bernardomg.tabletop.dice.parser.listener;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.generated.DiceNotationBaseListener;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.BinaryOpContext;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.DiceContext;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.NumberContext;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

/**
 * Visitor for an ANTLR4 parser tree. It can return the fully parsed
 * {@link DiceNotationExpression}.
 * <p>
 * This {@code DiceNotationExpression} is the root for a tree representing the
 * expression received by the parser.
 * <p>
 * It contains a stack which stores the operands as they are parsed, this way
 * any operation, such as an addition, can acquire the latest operands, which
 * will be the ones it will employ.
 * <p>
 * The way this works is simple:
 * <ul>
 * <li>Numbers are parsed into {@code IntegerOperand} and stored in the
 * stack</li>
 * <li>Dice are parsed into {@code DiceOperand} and stored in the stack</li>
 * <li>Binary operations take the last two values from the stack, get parsed
 * into a {@code BinaryOperation} and then are stored into the stack</li>
 * </ul>
 * <p>
 * The stack is also used to find the root, which will be the last value added
 * into it.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultDiceExpressionBuilder extends DiceNotationBaseListener
        implements DiceExpressionBuilder {

    /**
     * Operator which indicates the operation is an addition.
     */
    private static final String                 ADDITION_OPERATOR    = "+";

    /**
     * Logger.
     */
    private static final Logger                 LOGGER               = LoggerFactory
            .getLogger(DefaultDiceExpressionBuilder.class);

    /**
     * Operator which indicates the operation is a subtraction.
     */
    private static final String                 SUBTRACTION_OPERATOR = "-";

    /**
     * Stack to store operands from the outer nodes in an operation.
     * <p>
     * For example, when parsing an addition operation this stack will hold both
     * operands being added together.
     */
    private final Stack<DiceNotationExpression> operandsStack        = new Stack<>();

    /**
     * Default constructor.
     */
    public DefaultDiceExpressionBuilder() {
        super();
    }

    @Override
    public final void exitBinaryOp(final BinaryOpContext ctx) {
        final DiceNotationExpression expression;

        checkNotNull(ctx, "Received a null pointer as context");

        expression = getBinaryOperation(ctx);

        LOGGER.debug("Parsed binary operation: {}", expression);

        operandsStack.push(expression);
    }

    @Override
    public final void exitDice(final DiceContext ctx) {
        final DiceNotationExpression expression;

        checkNotNull(ctx, "Received a null pointer as context");

        expression = getDiceOperand(ctx);

        LOGGER.debug("Parsed dice: {}", expression);

        operandsStack.push(expression);
    }

    @Override
    public final void exitNumber(final NumberContext ctx) {
        final DiceNotationExpression expression;

        checkNotNull(ctx, "Received a null pointer as context");

        expression = getIntegerOperand(ctx.DIGIT());

        LOGGER.debug("Parsed number: {}", expression);

        operandsStack.push(expression);
    }

    @Override
    public final DiceNotationExpression getDiceExpressionRoot() {
        // The last value added to the stack will be the root
        return operandsStack.peek();
    }

    /**
     * Creates a binary operation from the parsed context data.
     * <p>
     * This method will take the two last operands from the stack, and use them
     * to create the binary operation.
     * 
     * @param ctx
     *            parsed context
     * @return a binary operation
     */
    private final DiceNotationExpression
            getBinaryOperation(final BinaryOpContext ctx) {
        BinaryOperation operation;    // Parsed binary operation
        DiceNotationExpression left;  // Left operand
        DiceNotationExpression right; // Right operand
        final Collection<String> operators;
        final Stack<DiceNotationExpression> operands;

        operators = ctx.OPERATOR().stream().map(TerminalNode::getText)
                .collect(Collectors.toList());

        operands = new Stack<>();
        operands.push(operandsStack.pop());
        for (Integer i = 0; i < operators.size(); i++) {
            if (operandsStack.isEmpty()) {
                // Single value binary operation
                // Negative values may be mapped to this case
                LOGGER.debug(
                        "No operands in stack. The left operand will be defaulted to 0.");
                operands.push(new IntegerOperand(0));
            } else {
                operands.push(operandsStack.pop());
            }
        }

        for (final String operator : operators) {
            // Acquired operands
            left = operands.pop();
            right = operands.pop();

            // Checks which kind of operation this is and creates it
            if (ADDITION_OPERATOR.equals(operator)) {
                LOGGER.trace("Addition operation");
                operation = new AdditionOperation(left, right);
            } else if (SUBTRACTION_OPERATOR.equals(operator)) {
                LOGGER.trace("Subtraction operation");
                operation = new SubtractionOperation(left, right);
            } else {
                throw new IllegalArgumentException(
                        String.format("The %s operator is invalid", operator));
            }

            operands.push(operation);
        }

        return operands.pop();
    }

    /**
     * Creates a dice operand from the parsed context data.
     * 
     * @param ctx
     *            parsed context
     * @return a dice operand
     */
    private final DiceOperand getDiceOperand(final DiceContext ctx) {
        final Dice dice;                     // Parsed dice
        final Integer quantity;              // Number of dice
        final Integer sides;                 // Number of sides
        final Iterator<TerminalNode> digits; // Parsed digits

        // Parses the dice data
        digits = ctx.DIGIT().iterator();
        quantity = Integer.parseInt(digits.next().getText());
        sides = Integer.parseInt(digits.next().getText());

        // Creates the dice
        dice = new DefaultDice(quantity, sides);

        return new DefaultDiceOperand(dice);
    }

    /**
     * Creates an integer operand from a terminal node.
     * 
     * @param node
     *            terminal node
     * @return an integer operand
     */
    private final IntegerOperand getIntegerOperand(final TerminalNode node) {
        final Integer value; // Parsed value

        // Parses the value
        value = Integer.parseInt(node.getText());

        return new IntegerOperand(value);
    }

}
