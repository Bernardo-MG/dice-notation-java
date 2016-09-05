# Dice notation

Created on the late 70s for Dungeons & Dragons, the tabletop notation has become a standard on tabletop games, defining formulas used to generate random values with the help of dice.

These are very simple: 2d6+5 means "roll two dice, add their values and then add the number five to the result".

## Why this library?

Dice notation appears through tabletop games frequently, making it necessary to handle it in all of it's aspects.

It is needed not only to be able to represent it somehow, but also it should be possible to parse the written notation, and values have to be generated from the parsed notation.

## The components

Several features allow handling dice notation:

- ANTLR 4 grammar for the dice notation
- Model for both the dice notation and dice groups
- Classes for generating random values from the notation
- Parser which generates model instances from the notation