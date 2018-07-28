# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

To parse generic dice notation, including algebraic operations use this:

```java
final DiceNotationExpressionParser parser;
final DiceNotationExpression parsed;

parser = new DefaultDiceNotationExpressionParser(new DefaultRoller());

parsed = parser.parse("1d6+12");

System.out.println(parsed.getValue());
```

The 'getValue' will generate a number from the expression each time it is called, simulating the dice being rolled, and applying any algebraic operation.

## Parsing A Single Dice Set

If you need to parse a single dice:

```java
final DiceOperand parsed;
final Dice dice;

parsed = new SingleDiceSetNotationExpressionParser().parse("1d6");

dice = parsed.getDice();

System.out.println(dice.getQuantity());
System.out.println(dice.getSides());

System.out.println(parsed.getValue());
```

This will print the number of dice (1) and the number of sides (2). Just like the previous example it can be rolled by calling the 'getValue' method.

It will return only the last dice set parsed, and ignore algebraic operations.
