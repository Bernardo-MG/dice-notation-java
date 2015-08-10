package com.wandrell.tabletop.dice.parser.listener;

import java.util.Stack;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.grammar.DiceNotationBaseListener;
import com.wandrell.tabletop.dice.grammar.DiceNotationParser;
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

public final class DiceFormulaBuilder extends DiceNotationBaseListener {

    private DiceExpression                       formula;
    private final Stack<DiceExpressionComponent> operandsStack = new Stack<>();

    public DiceFormulaBuilder() {
        super();
    }

    @Override
    public final void
            enterFormula(final DiceNotationParser.FormulaContext ctx) {
        formula = new DefaultDiceExpression();
    }

    @Override
    public final void exitFormula(final DiceNotationParser.FormulaContext ctx) {
        while (!getOperandsStack().isEmpty()) {
            formula.addDiceNotationComponent(getOperandsStack().pop());
        }
    }

    @Override
    public final void
            exitIntegerDice(final DiceNotationParser.IntegerDiceContext ctx) {
        final Dice dice;
        final Integer count;
        final Integer sides;

        count = Integer.parseInt(ctx.diceHeader().NUMBER().getText());
        sides = Integer.parseInt(ctx.diceSides().getText());

        dice = new DefaultDice(count, sides);

        getOperandsStack().push(new DiceOperand(new DiceConstant(dice)));
    }

    @Override
    public void exitIntegerOpAdd(DiceNotationParser.IntegerOpAddContext ctx) {
        final BinaryOperation opAdd;
        final String operator;
        final Operand left;
        final Operand right;

        operator = ctx.OPERATOR_ADD().getText();

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
    public final void exitValue(final DiceNotationParser.ValueContext ctx) {
        final Integer value;

        value = Integer.parseInt(ctx.getText());

        getOperandsStack().push(new IntegerConstant(value));
    }

    public final DiceExpression getDiceFormula() {
        return formula;
    }

    private final Stack<DiceExpressionComponent> getOperandsStack() {
        return operandsStack;
    }

}
