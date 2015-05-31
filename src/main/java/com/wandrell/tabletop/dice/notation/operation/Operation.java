package com.wandrell.tabletop.dice.notation.operation;

import com.wandrell.tabletop.dice.notation.DiceExpressionComponent;

public interface Operation extends DiceExpressionComponent {

    public Operand operate();

}
