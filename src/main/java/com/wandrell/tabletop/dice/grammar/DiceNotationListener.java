package com.wandrell.tabletop.dice.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DiceNotationParser}.
 */
public interface DiceNotationListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link DiceNotationParser#formula}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFormula(DiceNotationParser.FormulaContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#formula}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFormula(DiceNotationParser.FormulaContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIntegerDice(DiceNotationParser.IntegerDiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIntegerDice(DiceNotationParser.IntegerDiceContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#diceHeader}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDiceHeader(DiceNotationParser.DiceHeaderContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#diceHeader}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDiceHeader(DiceNotationParser.DiceHeaderContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#diceSides}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDiceSides(DiceNotationParser.DiceSidesContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#diceSides}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDiceSides(DiceNotationParser.DiceSidesContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#value}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterValue(DiceNotationParser.ValueContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#value}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitValue(DiceNotationParser.ValueContext ctx);
}