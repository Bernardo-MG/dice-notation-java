# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

To parse generic dice notation, including algebraic operations use this:

```java
final DiceParser parser;
final TransformableDiceNotationExpression parsed;
final DiceInterpreter interpreter;

parser = new DefaultDiceParser();
parsed = parser.parse("1d6+12");
```

Afterward you can use any dice interpreter to get any info you may wish from the parsed notation.

## Rolling the Values

To roll the expression:

```java
final RollHistory history;

history = new DiceRoller().transform(parsed);
```

It includes the final value:

```java
// Prints the final result
System.out.println(history.getFinalRoll());
```

And the values generated from each dice set:

```java
final Iterable<RollResult> results;
final RollResult result;

// Results from each dice set
results = history.getRollResults();

// Results from the first dice set
result = results .iterator().next();

// Prints each roll
System.out.println(result.getAllRolls());
```

Each time it is called a new set of data will be generated, rolling again all the dice. So the final values may change.

## Getting the Dice Set

If you need to get the dice from the expression:

```java
final DiceInterpreter interpreter;
final Dice dice;

interpreter = new DiceSetsTransformer();

dice = interpreter.transform(parsed).iterator().next();

System.out.println(dice.getQuantity());
System.out.println(dice.getSides());
```

This will print the number of dice (1) and the number of sides (6).

## Changing Random Number Generation on Parsed Dice

Random numbers, for rolling dice, are handled through an instance of [NumberGenerator][number_generator].

To use a custom generator you need to implement this and then set the new generator into the interpreter:

```java
final DiceParser parser;
final TransformableDiceNotationExpression parsed;
final NumberGenerator numGen;
final DiceInterpreter interpreter;

parser = new DefaultDiceParser();
parsed = parser.parse("1d6+12");
numGen = new CustomNumberGenerator();
interpreter = new DiceRoller(numGen);

System.out.println(interpreter.transform(parsed));
```

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
