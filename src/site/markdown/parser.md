# Dice Notation Parser

The main feature of the project is a parser capable of transforming dice notation expressions into the dice notation model.

## Default Parser

![Dice notation parser class diagram][dice_notation_parser-class_diagram]

The [DiceParser][dice_notation_parser] interface is implemented by the [DefaultDiceParser][default_dice_notation_parser]. This makes use of the [ANTRL grammar][grammar] to transform a string into the [dice notation model][dice_notation_model-doc].

### Visitor

![Dice expression builder class diagram][dice_expression_builder-class_diagram]

Most of the parsing is handled by ANTLR, and then adapted by the [DefaultDiceExpressionBuilder][default_dice_expression_buider] which extends over the DiceNotationListener, an interface generated automatically from the ANTLR grammar file.

[dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DiceParser.html
[default_dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DefaultDiceParser.html
[default_dice_expression_buider]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/DefaultDiceExpressionBuilder.html

[dice_notation_parser-class_diagram]: ./images/dice_notation_parser_class_diagram.png
[dice_expression_builder-class_diagram]: ./images/dice_expression_builder_class_diagram.png

[grammar]: ./grammar.html
[dice_notation_model-doc]: ./notation.html
