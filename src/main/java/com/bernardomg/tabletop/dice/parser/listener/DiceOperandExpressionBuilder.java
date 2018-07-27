/**
 * Copyright 2014-2017 the original author or authors
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

import com.bernardomg.tabletop.dice.DefaultDice;
import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.generated.DiceNotationBaseListener;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.BinaryOpContext;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.DiceContext;
import com.bernardomg.tabletop.dice.generated.DiceNotationParser.FunctionContext;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.roller.DefaultRoller;
import com.bernardomg.tabletop.dice.roller.Roller;

/**
 * Visitor for an ANTLR4 parser tree. It returns only a {@link DiceOperand}.
 * <p>
 * This will be the latest operand found. Anything else, such as numeric
 * operations, will be ignored.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DiceOperandExpressionBuilder extends DiceNotationBaseListener
        implements DiceExpressionBuilder<DiceOperand> {

    /**
     * Roller for the dice expressions.
     * <p>
     * This is used as a dependency on the dice expressions, which require a
     * roller to generate their value.
     */
    private final Roller diceRoller;

    /**
     * Operand to return. This builder supports only a single operand, which
     * should for dice.
     */
    private DiceOperand  operand;

    /**
     * Default constructor.
     * <p>
     * It makes use of a {@link DefaultRoller}
     */
    public DiceOperandExpressionBuilder() {
        this(new DefaultRoller());
    }

    /**
     * Constructs a builder with the specified roller.
     * 
     * @param roller
     *            roller for the dice expressions
     */
    public DiceOperandExpressionBuilder(final Roller roller) {
        super();

        diceRoller = checkNotNull(roller, "Received a null pointer as roller");
    }

    @Override
    public final void exitBinaryOp(final BinaryOpContext ctx) {}

    @Override
    public final void exitDice(final DiceContext ctx) {
        checkNotNull(ctx, "Received a null pointer as context");

        operand = getDiceOperand(ctx);
    }

    @Override
    public final void exitFunction(final FunctionContext ctx) {}

    @Override
    public final DiceOperand getDiceExpressionRoot() {
        return operand;
    }

    /**
     * Creates a dice operand from the parsed context data.
     * 
     * @param ctx
     *            parsed context
     * @return a dice operand
     */
    private final DiceOperand getDiceOperand(final DiceContext ctx) {
        final Dice dice;        // Parsed dice
        final Integer quantity; // Number of dice
        final Integer sides;    // Number of sides

        // Parses the dice data
        quantity = Integer.parseInt(ctx.DIGIT(0).getText());
        sides = Integer.parseInt(ctx.DIGIT(1).getText());

        // Creates the dice
        dice = new DefaultDice(quantity, sides);

        return new DefaultDiceOperand(dice, getRoller());
    }

    /**
     * Returns the roller for the dice expressions.
     * 
     * @return the roller for the dice expressions
     */
    private final Roller getRoller() {
        return diceRoller;
    }

}
