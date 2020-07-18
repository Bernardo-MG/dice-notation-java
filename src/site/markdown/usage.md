# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

Generic dice notation, including algebraic operations, can be parsed like this:

```java
final DiceParser parser;
final DiceNotationExpression parsed;

parser = new DefaultDiceParser();

parsed = parser.parse("1d6+12");
```

### Rolling the Expression

By using the DiceRoller you may simulate rolling the expression:

```java
final DiceInterpreter<RollHistory> roller;
final RollHistory rolls;

// Parse expression like in the previous example

roller = new DiceRoller();

rolls = roller.transform(parsed);

// Prints the final result
System.out.println(rolls.getTotalRoll());
```

This will roll the expression each time transform is called, but if you are not planning on reuse the expression this can be done along the parsing:

```java
rolls = parser.parse("1d6+12", roller);
```

Of course you may want to reuse the expression, avoiding reparsing it, in which case you would do something like this:

### Other Transformations

For more information about transforming the parsed tree check the [interpreters][interpreters].

[interpreters]: ./interpreter.html
