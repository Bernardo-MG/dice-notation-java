package com.wandrell.tabletop.dice.parser.listener;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;

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
import com.wandrell.tabletop.dice.notation.operation.constant.DiceConstant;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;

public final class DiceFormulaBuilder extends DiceNotationBaseListener {

    private DiceExpression                       formula;
    private final Stack<DiceExpressionComponent> operandsStack = new Stack<>();

    public DiceFormulaBuilder() {
        super();
    }

    @Override
    public final void enterEveryRule(final ParserRuleContext ctx) {}

    @Override
    public final void enterFormula(final DiceNotationParser.FormulaContext ctx) {
        formula = new DefaultDiceExpression();
    }

    @Override
    public final void exitFormula(final DiceNotationParser.FormulaContext ctx) {
        while (!getOperandsStack().isEmpty()) {
            formula.addDiceNotationComponent(getOperandsStack().pop());
        }
    }

    @Override
    public final void exitIntegerDice(
            final DiceNotationParser.IntegerDiceContext ctx) {
        final Dice dice;
        final Integer count;
        final Integer sides;

        count = Integer.parseInt(ctx.diceHeader().NUMBER().getText());
        sides = Integer.parseInt(ctx.diceSides().getText());

        dice = new DefaultDice(count, sides);

        // formula.addDiceNotationComponent(new DiceConstant(dice));

        getOperandsStack().push(new DiceOperand(new DiceConstant(dice)));
    }

    @Override
    public void exitIntegerOpAdd(DiceNotationParser.IntegerOpAddContext ctx) {
        final BinaryOperation opAdd;

        opAdd = new AdditionOperation((Operand) getOperandsStack().pop(),
                (Operand) getOperandsStack().pop());

        getOperandsStack().push(opAdd);
    }

    @Override
    public final void exitValue(final DiceNotationParser.ValueContext ctx) {
        final Integer value;

        value = Integer.parseInt(ctx.getText());

        // formula.addDiceNotationComponent(new IntegerConstant(value));

        getOperandsStack().push(new IntegerConstant(value));
    }

    public final DiceExpression getDiceFormula() {
        return formula;
    }

    private final Stack<DiceExpressionComponent> getOperandsStack() {
        return operandsStack;
    }

}
