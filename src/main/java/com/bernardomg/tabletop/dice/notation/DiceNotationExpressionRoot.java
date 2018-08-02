
package com.bernardomg.tabletop.dice.notation;

public interface DiceNotationExpressionRoot extends DiceNotationExpression {

    public DiceNotationExpression getRoot();

    public Integer roll();

}
