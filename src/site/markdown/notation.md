# Dice Notation Model

Expressions are parsed into a tree to allow operating with it.

## The Tree and the Nodes

The parsed tree is composed by instances of [DiceNotationExpression][dice_notation_expression].

For example, the expression "2d6+1d20+5" would become something like this:

![Dice notation tree example][dice_notation_expression-tree_example]

## Operands

The leaf nodes of the are composed by operands. Each of them stores a value.

There are two operands currently, the [IntegerOperand][integer_operand] and the [DiceOperand][dice_operand].

## Operations

Binary operations, represented by the [BinaryOperation][binary_operation] interface, are supported.

[dice_notation_expression-tree_example]: ./images/dice_notation_tree_example.png

[dice_notation_expression]: ./apidocs/com/bernardomg/tabletop/dice/notation/DiceNotationExpression.html

[integer_operand]: ./apidocs/com/bernardomg/tabletop/dice/notation/operand/IntegerOperand.html
[dice_operand]: ./apidocs/com/bernardomg/tabletop/dice/notation/operand/DiceOperand.html

[binary_operation]: ./apidocs/com/bernardomg/tabletop/dice/notation/operation/BinaryOperation.html
