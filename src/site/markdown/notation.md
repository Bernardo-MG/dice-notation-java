# Dice notation model

The dice notation grammar is meant to allow working with dice notation expressions, which will be transformed into an equivalent structure by using a custom model.

With this any expression can be represented as a tree, where each node can be transformed back into the dice notation expression, or it can be used to generate a random value.

## The tree and the nodes

![Dice notation expression class diagram][dice_notation_expression-class_diagram]

A dice notation tree is composed by implementations of [DiceNotationExpression][dice_notation_expression]. These are meant to be small pieces in a bigger expression, each of them linked to the next one, but not knowing the previous.

For example, the expression "2d6+1d20+5" would become something like this:

![Dice notation tree example][dice_notation_expression-tree_example]

## Operands

The leaf nodes are composed by operands, these just store a value which will be used by other components of the model.

They lack a common interface, and currently only two exist, the [IntegerOperand][integer_operand] and the [DiceOperand][dice_operand].

### Dice operand

![Dice operand class diagram][dice_operand-class_diagram]

The dice operand has the additional need to generate a random value from the dice in the node. This is taken care by the default implementation, the [DefaultDiceOperand][default_dice_operand], which is using a [Roller][roller-doc] for it.

## Operations

Only the most simple binary operations, addition and subtraction, are supported. The [BinaryOperation][binary_operation] interface represents them, while the [AdditionOperation][addition_operation] and [SubtractionOperation][subtraction_operation] are their implementations.

[dice_notation_expression-class_diagram]: ./images/dice_notation_class_diagram.png
[dice_operand-class_diagram]: ./images/dice_operand_class_diagram.png

[dice_notation_expression-tree_example]: ./images/dice_notation_tree_example.png

[roller-doc]: ./dice.html

[dice_notation_expression]: ./apidocs/com/wandrell/tabletop/dice/notation/DiceNotationExpression.html

[integer_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/IntegerOperand.html
[dice_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/DiceOperand.html
[default_dice_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/DefaultDiceOperand.html

[binary_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/BinaryOperation.html
[addition_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/AdditionOperation.html
[subtraction_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/SubtractionOperation.html
