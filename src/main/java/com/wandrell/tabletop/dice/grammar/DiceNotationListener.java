package com.wandrell.tabletop.dice.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DiceNotationParser}.
 */
public interface DiceNotationListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link DiceNotationParser#dice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDice(DiceNotationParser.DiceContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#expression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterExpression(DiceNotationParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#fudgeDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFudgeDice(DiceNotationParser.FudgeDiceContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIntegerDice(DiceNotationParser.IntegerDiceContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#notation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNotation(DiceNotationParser.NotationContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#operand}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterOperand(DiceNotationParser.OperandContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationParser#operationParenthesis}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterOperationParenthesis(
            DiceNotationParser.OperationParenthesisContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationParser#percentileDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPercentileDice(DiceNotationParser.PercentileDiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#dice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDice(DiceNotationParser.DiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#expression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitExpression(DiceNotationParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#fudgeDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFudgeDice(DiceNotationParser.FudgeDiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIntegerDice(DiceNotationParser.IntegerDiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#notation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNotation(DiceNotationParser.NotationContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#operand}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitOperand(DiceNotationParser.OperandContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationParser#operationParenthesis}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitOperationParenthesis(
            DiceNotationParser.OperationParenthesisContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationParser#percentileDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPercentileDice(DiceNotationParser.PercentileDiceContext ctx);
}