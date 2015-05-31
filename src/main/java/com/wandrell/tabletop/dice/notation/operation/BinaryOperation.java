package com.wandrell.tabletop.dice.notation.operation;

public interface BinaryOperation extends Operation {

    public Operand getLeft();

    public Operand getRight();

}
