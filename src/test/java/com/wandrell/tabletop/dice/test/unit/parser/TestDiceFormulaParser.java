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

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.DiceOperand;
import com.wandrell.tabletop.dice.notation.operation.SubstractionOperation;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;
import com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser;

public final class TestDiceFormulaParser {

	private final DefaultDiceNotationParser parser;

	{
		parser = new DefaultDiceNotationParser();
	}

	public TestDiceFormulaParser() {
		super();
	}

	@Test
	public final void testParseDice_Add_Left() {
		final DiceExpression formula;
		final AdditionOperation operation;
		final IntegerConstant integer;
		final DiceOperand dice;
		final String notation;

		notation = "5+2d6";

		formula = parser.parse(notation);

		operation = (AdditionOperation) formula.getComponents().iterator()
				.next();

		dice = (DiceOperand) operation.getRight();
		integer = (IntegerConstant) operation.getLeft();

		Assert.assertEquals(dice.getDice().getDice().getQuantity(), (Integer) 2);
		Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

		Assert.assertEquals(integer.getValue(), (Integer) 5);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Add_Right() {
		final DiceExpression formula;
		final AdditionOperation operation;
		final IntegerConstant integer;
		final DiceOperand dice;
		final String notation;

		notation = "2d6+5";

		formula = parser.parse(notation);

		operation = (AdditionOperation) formula.getComponents().iterator()
				.next();

		dice = (DiceOperand) operation.getLeft();
		integer = (IntegerConstant) operation.getRight();

		Assert.assertEquals(dice.getDice().getDice().getQuantity(), (Integer) 2);
		Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

		Assert.assertEquals(integer.getValue(), (Integer) 5);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Number() {
		final DiceExpression formula;
		final IntegerConstant value;
		final String notation;

		notation = "12";

		formula = parser.parse(notation);

		value = (IntegerConstant) formula.getComponents().iterator().next();

		Assert.assertEquals(value.getValue(), (Integer) 12);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Number_Add() {
		final DiceExpression formula;
		final AdditionOperation value;
		final String notation;

		notation = "12+1";

		formula = parser.parse(notation);

		value = (AdditionOperation) formula.getComponents().iterator().next();

		Assert.assertEquals(value.getLeft().getValue(), (Integer) 12);
		Assert.assertEquals(value.getRight().getValue(), (Integer) 1);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Sub_Left() {
		final DiceExpression formula;
		final SubstractionOperation operation;
		final IntegerConstant integer;
		final DiceOperand dice;
		final String notation;

		notation = "5-2d6";

		formula = parser.parse(notation);

		operation = (SubstractionOperation) formula.getComponents().iterator()
				.next();

		dice = (DiceOperand) operation.getRight();
		integer = (IntegerConstant) operation.getLeft();

		Assert.assertEquals(dice.getDice().getDice().getQuantity(), (Integer) 2);
		Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

		Assert.assertEquals(integer.getValue(), (Integer) 5);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Sub_Right() {
		final DiceExpression formula;
		final SubstractionOperation operation;
		final IntegerConstant integer;
		final DiceOperand dice;
		final String notation;

		notation = "2d6-5";

		formula = parser.parse(notation);

		operation = (SubstractionOperation) formula.getComponents().iterator()
				.next();

		dice = (DiceOperand) operation.getLeft();
		integer = (IntegerConstant) operation.getRight();

		Assert.assertEquals(dice.getDice().getDice().getQuantity(), (Integer) 2);
		Assert.assertEquals(dice.getDice().getDice().getSides(), (Integer) 6);

		Assert.assertEquals(integer.getValue(), (Integer) 5);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

	@Test
	public final void testParseDice_Zero() {
		final DiceExpression formula;
		final IntegerConstant value;
		final String notation;

		notation = "0";

		formula = parser.parse(notation);

		value = (IntegerConstant) formula.getComponents().iterator().next();

		Assert.assertEquals(value.getValue(), (Integer) 0);

		Assert.assertEquals(formula.getStringRepresentation(), notation);
	}

}
