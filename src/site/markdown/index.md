# Working with dice notation

Created on the late 70s for Dungeons & Dragons, the dice notation has become a standard on tabletop games as it allows generating random values in concrete distributions with the help of simple formulas such as '2d6+5', which means "roll two dice, add their values and then add the number five to the result".

To make these expressions usable by a machine they need to be parsed into an object which will generate the correct random result. That is where this library comes into action, with the help of not only a [parser][parser], but also a model for both [dice][dice] and [dice notation expressions][notation].

Right now not all the possible cases are covered. Interpreting this notation is not as easy as it seems as it was never standardized and many variations have appeared during the years, some meant to allow working with specific distributions, such as percentile dice, others meant to generate special results.

An example of the second case are the Fudge dice, which not only represent numbers but also concepts, more precisely: failure, success and no result at all, represented by the '-', '+' and ' ' symbols.

For now such specific situations are not supported by the library, which allows only parsing the most [basic grammar][grammar].

## Features

- [ANTLR 4 grammar][grammar] for the dice notation
- Model for both the [dice notation][notation] and [dice groups][dice]
- Classes for [generating random values][dice] from the dice
- [Parser][parser] which generates model instances from the notation

## Usage example

If needed it is possible using the dice model, or even the dice notation one. But the recommended way to handle dice notation with the library is by using the included parser.

For a concrete example of how to do this take a look at the [usage page][usage].

[grammar]: ./grammar.html
[usage]: ./usage.html

[dice]: ./dice.html
[notation]: ./notation.html
[parser]: ./parser.html