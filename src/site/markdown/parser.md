# Dice notation parser

The main feature of the project is a parser capable of transforming dice notation expressions into the dice notation model.

## Parser

![Dice notation parser class diagram][dice_notation_parser-class_diagram]

The [DiceNotationParser][dice_notation_parser] interface is implemented only by the [DefaultDiceNotationParser][default_dice_notation_parser]. This makes use of the [ANTRL grammar][grammar-doc] to transform a string into the [dice notation model][dice_notation_model-doc].

### Visitor

![Dice expression builder class diagram][dice_expression_builder-class_diagram]

Most of the parsing is handled by ANTLR, and then adapted to the returned dice notation with the use of a visitor pattern. This visitor is a [DiceExpressionBuilder][dice_expression_buider], by default the [DefaultDiceExpressionBuilder][default_dice_expression_buider], and extends over the DiceNotationGrammarListener which is automatically generated from the ANTLR grammar file.

[dice_notation_parser]: ./apidocs/com/wandrell/tabletop/dice/parser/DiceNotationParser.html
[default_dice_notation_parser]: ./apidocs/com/wandrell/tabletop/dice/parser/DefaultDiceNotationParser.html
[dice_expression_buider]: ./apidocs/com/wandrell/tabletop/dice/parser/listener/DiceExpressionBuilder.html
[default_dice_expression_buider]: ./apidocs/com/wandrell/tabletop/dice/parser/listener/DefaultDiceExpressionBuilder.html

[dice_notation_parser-class_diagram]: ./images/dice_notation_parser_class_diagram.png
[dice_expression_builder-class_diagram]: ./images/dice_expression_builder_class_diagram.png

[grammar-doc]: ./grammar.html
[dice_notation_model-doc]: ./notation.html