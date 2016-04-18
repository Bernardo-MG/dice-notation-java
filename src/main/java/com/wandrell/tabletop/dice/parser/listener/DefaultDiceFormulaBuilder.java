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

import java.util.Stack;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.generated.DiceNotationBaseListener;
import com.wandrell.tabletop.dice.generated.DiceNotationParser;
import com.wandrell.tabletop.dice.notation.DefaultDiceExpression;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.notation.operation.Operand;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.notation.operation.constant.DiceConstant;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;

public final class DefaultDiceFormulaBuilder extends DiceNotationBaseListener
		implements DiceFormulaBuilder {

	private DiceExpression expression;

	private final Stack<DiceExpressionComponent> operandsStack = new Stack<>();

	public DefaultDiceFormulaBuilder() {
		super();
	}

	@Override
	public final void enterParse(final DiceNotationParser.ParseContext ctx) {
		expression = new DefaultDiceExpression();
	}

	@Override
	public final void exitBinaryOp(DiceNotationParser.BinaryOpContext ctx) {
		final BinaryOperation opAdd;
		final String operator;
		final Operand left;
		final Operand right;

		operator = ctx.OPERATOR().getText();

		right = (Operand) getOperandsStack().pop();
		left = (Operand) getOperandsStack().pop();

		if (operator.equals("+")) {
			opAdd = new AdditionOperation(left, right);
		} else {
			opAdd = new SubstractionOperation(left, right);
		}

		getOperandsStack().push(opAdd);
	}

	@Override
	public final void exitDice(final DiceNotationParser.DiceContext ctx) {
		final Dice dice;
		final Integer count;
		final Integer sides;

		count = Integer.parseInt(ctx.quantity().getText());
		sides = Integer.parseInt(ctx.sides().getText());

		dice = new DefaultDice(count, sides);

		getOperandsStack().push(new DiceOperand(new DiceConstant(dice)));
	}

	@Override
	public final void exitFunction(final DiceNotationParser.FunctionContext ctx) {
		// while (!getOperandsStack().isEmpty()) {
		// expression.addDiceNotationComponent(getOperandsStack().pop());
		// }
	}

	@Override
	public final void exitParse(final DiceNotationParser.ParseContext ctx) {
		while (!getOperandsStack().isEmpty()) {
			expression.addDiceNotationComponent(getOperandsStack().pop());
		}
	}

	@Override
	public final void exitValue(final DiceNotationParser.ValueContext ctx) {
		final Integer value;

		value = Integer.parseInt(ctx.getText());

		getOperandsStack().push(new IntegerConstant(value));
	}

	@Override
	public final DiceExpression getDiceExpression() {
		return expression;
	}

	private final Stack<DiceExpressionComponent> getOperandsStack() {
		return operandsStack;
	}

}
