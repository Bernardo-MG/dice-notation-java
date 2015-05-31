package com.wandrell.tabletop.dice.parser.listener;

import org.antlr.v4.runtime.ParserRuleContext;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.grammar.DiceNotationBaseListener;
import com.wandrell.tabletop.dice.grammar.DiceNotationParser;
import com.wandrell.tabletop.dice.notation.DefaultDiceFormula;
import com.wandrell.tabletop.dice.notation.DiceFormula;
import com.wandrell.tabletop.dice.notation.constant.DiceConstant;
import com.wandrell.tabletop.dice.notation.constant.IntegerConstant;

public final class DiceFormulaBuilder extends DiceNotationBaseListener {

    private DiceFormula formula;

    public DiceFormulaBuilder() {
        super();
    }

    @Override
    public final void enterEveryRule(final ParserRuleContext ctx) {}

    @Override
    public final void enterFormula(final DiceNotationParser.FormulaContext ctx) {
        formula = new DefaultDiceFormula();
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

        formula.addDiceNotationComponent(new DiceConstant(dice));
    }

    @Override
    public final void exitValue(final DiceNotationParser.ValueContext ctx) {
        final Integer value;

        value = Integer.parseInt(ctx.getText());

        formula.addDiceNotationComponent(new IntegerConstant(value));
    }

    public final DiceFormula getDiceFormula() {
        return formula;
    }

}
