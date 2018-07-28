# Dice notation parser

The main feature of the project is a parser capable of transforming dice notation expressions into the dice notation model.

## Default Parser

![Dice notation parser class diagram][dice_notation_parser-class_diagram]

The [DiceNotationExpressionParser][dice_notation_parser] interface is implemented by the [DefaultDiceNotationExpressionParser][default_dice_notation_parser]. This makes use of the [ANTRL grammar][grammar-doc] to transform a string into the [dice notation model][dice_notation_model-doc].

### Visitor

![Dice expression builder class diagram][dice_expression_builder-class_diagram]

Most of the parsing is handled by ANTLR, and then adapted to the returned dice notation with the use of a visitor pattern. This visitor is a [DiceExpressionBuilder][dice_expression_buider] which extends over the DiceNotationListener which is automatically generated from the ANTLR grammar file.

The [DefaultDiceExpressionBuilder][default_dice_expression_buider] implements the visitor, and makes use of  a stack to hold all the operands for any operation which may appear during parsing.

## Other Parsers

The [SingleDiceSetNotationExpressionParser][single_dice_notation_parser] parses a single dice. It will return the last dice set found, ignoring algebraic operations.

It makes use of the default parser through composition, and just uses a reduced visitor to change the object returned.

[dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DiceNotationExpressionParser.html
[default_dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DefaultDiceNotationExpressionParser.html
[dice_expression_buider]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/DiceExpressionBuilder.html
[default_dice_expression_buider]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/DefaultDiceExpressionBuilder.html
[single_dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/SingleDiceSetNotationExpressionParser.html

[dice_notation_parser-class_diagram]: ./images/dice_notation_parser_class_diagram.png
[dice_expression_builder-class_diagram]: ./images/dice_expression_builder_class_diagram.png

[grammar-doc]: ./grammar.html
[dice_notation_model-doc]: ./notation.html
