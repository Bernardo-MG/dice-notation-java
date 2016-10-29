# Dice notation model

When a dice notation expression is parsed a tree is generated from it, this is composed by dice notation entities, representing the expression in such a way that it is possible both generating a random value from it and getting back the original expression.

## The tree and the nodes

![Dice notation expression class diagram][dice_notation_expression-class_diagram]

[DiceNotationExpression][dice_notation_expression] instances compose the tree nodes. These are meant small pieces in a bigger expression, each of them will be linked to the next one, but not knowing the previous.

For example, the expression "2d6+1d20+5" would become something like this:

![Dice notation tree example][dice_notation_expression-tree_example]

Were each node would be an implementation of the DiceNotationExpression interface.

## Operands

The leaf nodes of the are composed by operands, which just store a value to be used by other components of the model.

They lack a common interface, and currently only two exist, the [IntegerOperand][integer_operand] and the [DiceOperand][dice_operand].

### Integer operand

![Integer operand class diagram][integer_operand-class_diagram]

The integer operand just stores an integer value for operations.

### Dice operand

![Dice operand class diagram][dice_operand-class_diagram]

The dice operand can generate a random value from a dice, which is needed to operate with it. The [DefaultDiceOperand][default_dice_operand] makes use of a [Roller][roller-doc] for it.

## Operations

![Binary operation class diagram][binary_operation-class_diagram]

Only the most simple binary operations, addition and subtraction, are supported. The [BinaryOperation][binary_operation] interface represents them, while the [AdditionOperation][addition_operation] and [SubtractionOperation][subtraction_operation] are their implementations.

[binary_operation-class_diagram]: ./images/binary_operation_class_diagram.png
[dice_notation_expression-class_diagram]: ./images/dice_notation_class_diagram.png
[dice_operand-class_diagram]: ./images/dice_operand_class_diagram.png
[integer_operand-class_diagram]: ./images/integer_operand_class_diagram.png

[dice_notation_expression-tree_example]: ./images/dice_notation_tree_example.png

[roller-doc]: ./dice.html

[dice_notation_expression]: ./apidocs/com/wandrell/tabletop/dice/notation/DiceNotationExpression.html

[integer_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/IntegerOperand.html
[dice_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/DiceOperand.html
[default_dice_operand]: ./apidocs/com/wandrell/tabletop/dice/notation/operand/DefaultDiceOperand.html

[binary_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/BinaryOperation.html
[addition_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/AdditionOperation.html
[subtraction_operation]: ./apidocs/com/wandrell/tabletop/dice/notation/operation/SubtractionOperation.html
