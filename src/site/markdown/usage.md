# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

To parse generic dice notation, including algebraic operations use this:

```java
final DiceNotationExpressionParser<DiceNotationExpression> parser;
final DiceNotationExpression parsed;

parser = new DefaultDiceNotationExpressionParser();

parsed = parser.parse("1d6+12");

System.out.println(parsed.getValue());
```

The 'getValue' will generate a number from the expression each time it is called, simulating the dice being rolled, and applying any algebraic operation.

## Parsing A Single Dice Set

If you need to parse a single dice:

```java
final DiceNotationExpressionParser<DiceNotationExpression> parser;
final DiceOperand parsed;
final Dice dice;

parser = new DefaultDiceNotationExpressionParser();
parsed = parser.parse("1d6");

dice = parsed.getDice();

System.out.println(dice.getQuantity());
System.out.println(dice.getSides());

System.out.println(parsed.getValue());
```

This will print the number of dice (1) and the number of sides (2). Just like the previous example it can be rolled by calling the 'getValue' method.

It will return only the last dice set parsed, and ignore algebraic operations.

## Changing Random Number Generation on Parsed Dice

Random numbers, for rolling dice, are handled through an instance of [NumberGenerator][number_generator].

To use a custom generator you need to implement this and then set the new generator into the parser:

```java
final NumberGenerator numGen;
final Roller roller;
final DiceNotationExpressionParser<DiceNotationExpression> parser;

numGen = new CustomNumberGenerator();
roller = new DefaultRoller(numGen);

parser = new DefaultDiceNotationExpressionParser(roller);
```

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
