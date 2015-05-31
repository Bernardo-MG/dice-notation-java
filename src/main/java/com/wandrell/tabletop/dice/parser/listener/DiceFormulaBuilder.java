package com.wandrell.tabletop.dice.parser.listener;

import org.antlr.v4.runtime.ParserRuleContext;

import com.wandrell.tabletop.dice.DefaultDice;
import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.grammar.DiceNotationBaseListener;
import com.wandrell.tabletop.dice.grammar.DiceNotationParser;
import com.wandrell.tabletop.dice.notation.DefaultDiceFormula;
import com.wandrell.tabletop.dice.notation.DiceFormula;
import com.wandrell.tabletop.dice.notation.IntegerComponent;

public final class DiceFormulaBuilder extends DiceNotationBaseListener {

    private Integer     count;
    private DiceFormula formula;
    private Integer     sides;

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
    public final void exitDiceHeader(
            final DiceNotationParser.DiceHeaderContext ctx) {
        if (ctx.NUMBER() != null) {
            count = Integer.parseInt(ctx.NUMBER().getText());
        }
    }

    @Override
    public final void exitDiceSides(
            final DiceNotationParser.DiceSidesContext ctx) {
        if (ctx.NUMBER() != null) {
            sides = Integer.parseInt(ctx.NUMBER().getText());
        }
    }

    @Override
    public final void exitIntegerDice(
            final DiceNotationParser.IntegerDiceContext ctx) {
        final Dice dice;

        dice = new DefaultDice(count, sides);

        formula.addDiceNotationComponent(dice);
    }

    @Override
    public final void exitValue(final DiceNotationParser.ValueContext ctx) {
        final Integer value;

        value = Integer.parseInt(ctx.getText());

        formula.addDiceNotationComponent(new IntegerComponent(value));
    }

    public final DiceFormula getDiceFormula() {
        return formula;
    }

    public final Dice getParsedDice() {
        return new DefaultDice(count, sides);
    }

}
