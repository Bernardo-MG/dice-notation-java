package com.wandrell.tabletop.dice.parser.listener;

import com.wandrell.tabletop.dice.generated.DiceNotationListener;
import com.wandrell.tabletop.dice.notation.DiceExpression;

public interface DiceFormulaBuilder extends DiceNotationListener {

	public DiceExpression getDiceExpression();

}
