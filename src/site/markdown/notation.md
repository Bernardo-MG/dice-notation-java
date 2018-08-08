# Dice notation model

When a dice notation expression is parsed a tree is generated from it, this is composed by dice notation entities, representing the expression in such a way that it is possible both generating a random value from it and getting back the original expression.

## The tree and the nodes

![Dice notation expression class diagram][dice_notation_expression-class_diagram]

The parsed tree is composed by instances of [DiceNotationExpression][dice_notation_expression]. Only the root returned by the parser changes, as it is a [TransformableDiceNotationExpression][transformable_dice_notation_expression], which allows acquiring values from the parse tree.

These objects are meant to be small pieces in a bigger expression, each of them will be linked to the next one, but not knowing the previous.

For example, the expression "2d6+1d20+5" would become something like this:

![Dice notation tree example][dice_notation_expression-tree_example]

Were each node would be an implementation of the DiceNotationExpression interface.

## Operands

The leaf nodes of the are composed by operands. Each of them stores a value.

They lack a common interface. There are two operands currently: the integer operand and the dice operand.

### Integer operand

![Integer operand class diagram][integer_operand-class_diagram]

The [IntegerOperand][integer_operand] stores an integer value.

### Dice operand

![Dice operand class diagram][dice_operand-class_diagram]

The [DiceOperand][dice_operand] stores an dice set.

## Operations

![Binary operation class diagram][binary_operation-class_diagram]

Only the most simple binary operations, addition and subtraction, are supported. They are represented by the [BinaryOperation][binary_operation] interface, and implemented by [AdditionOperation][addition_operation] and [SubtractionOperation][subtraction_operation].

[binary_operation-class_diagram]: ./images/binary_operation_class_diagram.png
[dice_notation_expression-class_diagram]: ./images/dice_notation_class_diagram.png
[dice_operand-class_diagram]: ./images/dice_operand_class_diagram.png
[integer_operand-class_diagram]: ./images/integer_operand_class_diagram.png

[dice_notation_expression-tree_example]: ./images/dice_notation_tree_example.png

[dice_notation_expression]: ./apidocs/com/bernardomg/tabletop/dice/notation/DiceNotationExpression.html
[transformable_dice_notation_expression]: ./apidocs/com/bernardomg/tabletop/dice/notation/TransformableDiceNotationExpression.html

[integer_operand]: ./apidocs/com/bernardomg/tabletop/dice/notation/operand/IntegerOperand.html
[dice_operand]: ./apidocs/com/bernardomg/tabletop/dice/notation/operand/DiceOperand.html

[binary_operation]: ./apidocs/com/bernardomg/tabletop/dice/notation/operation/BinaryOperation.html
[addition_operation]: ./apidocs/com/bernardomg/tabletop/dice/notation/operation/AdditionOperation.html
[subtraction_operation]: ./apidocs/com/bernardomg/tabletop/dice/notation/operation/SubtractionOperation.html
