# Working with dice notation

Created on the late 70s for Dungeons & Dragons, the dice notation has become a standard on tabletop games as it allows generating random values in concrete distributions with the help of simple formulas such as '2d6+5', which means "roll two dice, add their values and then add the number five to the result".

To make these expressions usable by a machine they need to be parsed into an object which will generate the correct random result. That is where this library comes into action, with the help of not only a [parser][parser], but also a model for both [dice][dice] and [dice notation expressions][notation].

Right now not all the possible cases are covered. Interpreting this notation is not as easy as it seems as it was never standardized and many variations have appeared during the years, some meant to allow working with specific distributions, such as percentile dice, others meant to generate special results.

An example of the second case are the Fudge dice, which not only represent numbers but also concepts, more precisely: failure, success and no result at all, represented by the '-', '+' and ' ' symbols.

For now such specific situations are not supported by the library, which allows only parsing the most [basic grammar][grammar].

## The aim of the project

The dice notation allows working with random values distributions. And while it is great for a tabletop game a machine will have better tools for handling this need.

But the project is not trying to generate random values, it is more of a side effect. The actual objective is giving a way for Java applications to work with the same tools a board game would have.

This is very useful when creating tools related to these games, but won't make much sense in other context.

## Related projects

- [Dice Notation Tools CLI][dice-notation-java-cli], a CLI to roll expressions through line command

## Features

- [ANTLR 4 grammar][grammar] for the dice notation
- Model for both the [dice notation][notation] and [dice groups][dice]
- Classes for [generating random values][dice] from the dice
- [Parser][parser] which generates model instances from the notation
- Allows custom [random number generation][number_generator]

## Usage example

The project includes model, BNF grammar and parsers, which allow working with the most common dice notation expressions.

For more details take a look at the [usage page][usage].

## ANTLR4 grammars

The grammar is included among the [ANTLR4 sample grammars][antrl-grammars].

[antrl-grammars]: https://github.com/antlr/grammars-v4

[grammar]: ./grammar.html
[usage]: ./usage.html

[dice]: ./dice.html
[notation]: ./notation.html
[parser]: ./parser.html

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html

[dice-notation-java-cli]: https://github.com/Bernardo-MG/dice-notation-java-cli
