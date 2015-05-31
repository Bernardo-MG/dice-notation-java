package com.wandrell.tabletop.dice.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DiceNotationExtendedParser}.
 */
public interface DiceNotationExtendedListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#notation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNotation(DiceNotationExtendedParser.NotationContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationExtendedParser#notation}
     * .
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNotation(DiceNotationExtendedParser.NotationContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#expression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterExpression(DiceNotationExtendedParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationExtendedParser#expression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitExpression(DiceNotationExtendedParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationExtendedParser#operand}
     * .
     * 
     * @param ctx
     *            the parse tree
     */
    void enterOperand(DiceNotationExtendedParser.OperandContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationExtendedParser#operand}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitOperand(DiceNotationExtendedParser.OperandContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#operationParenthesis}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterOperationParenthesis(
            DiceNotationExtendedParser.OperationParenthesisContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationExtendedParser#operationParenthesis}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitOperationParenthesis(
            DiceNotationExtendedParser.OperationParenthesisContext ctx);

    /**
     * Enter a parse tree produced by {@link DiceNotationExtendedParser#dice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDice(DiceNotationExtendedParser.DiceContext ctx);

    /**
     * Exit a parse tree produced by {@link DiceNotationExtendedParser#dice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDice(DiceNotationExtendedParser.DiceContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIntegerDice(DiceNotationExtendedParser.IntegerDiceContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationExtendedParser#integerDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIntegerDice(DiceNotationExtendedParser.IntegerDiceContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#percentileDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPercentileDice(
            DiceNotationExtendedParser.PercentileDiceContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationExtendedParser#percentileDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void
            exitPercentileDice(
                    DiceNotationExtendedParser.PercentileDiceContext ctx);

    /**
     * Enter a parse tree produced by
     * {@link DiceNotationExtendedParser#fudgeDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFudgeDice(DiceNotationExtendedParser.FudgeDiceContext ctx);

    /**
     * Exit a parse tree produced by
     * {@link DiceNotationExtendedParser#fudgeDice}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFudgeDice(DiceNotationExtendedParser.FudgeDiceContext ctx);
}