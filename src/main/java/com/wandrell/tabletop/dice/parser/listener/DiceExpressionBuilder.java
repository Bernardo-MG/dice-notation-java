
package com.wandrell.tabletop.dice.parser.listener;

import com.wandrell.tabletop.dice.generated.DiceNotationListener;
import com.wandrell.tabletop.dice.notation.DiceExpression;

public interface DiceExpressionBuilder extends DiceNotationListener {

    public DiceExpression getDiceExpression();

}
