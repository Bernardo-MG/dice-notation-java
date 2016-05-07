# Dice notation parser

A parser, capable of transforming dice notation expressions into the dice notation model, is a backbone of the project.

The [DiceNotationParser][dice_notation_parser] interface is implemented only by the [DefaultDiceNotationParser][default_dice_notation_parser]. This makes use of the [ANTRL grammar][grammar-doc] to transform a string into the [dice notation model][dice_notation_model-doc].

[dice_notation_parser]: ./apidocs/com/wandrell/tabletop/dice/parser/DiceNotationParser.html
[default_dice_notation_parser]: ./apidocs/com/wandrell/tabletop/dice/parser/DefaultDiceNotationParser.html

[grammar-doc]: ./grammar.html
[dice_notation_model-doc]: ./notation.html