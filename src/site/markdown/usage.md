# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

Generic dice notation, including algebraic operations, can be parsed like this:

```java
final DiceParser parser;
final TransformableDiceNotationExpression parsed;
final DiceInterpreter interpreter;

parser = new DefaultDiceParser();

parsed = parser.parse("1d6+12");
```

Or if you want to change the returned object make use of an interpreter:

```java
final DiceParser parser;
final RollHistory rolls;
final DiceInterpreter interpreter;
final DiceInterpreter<RollHistory> roller;

parser = new DefaultDiceParser();
roller = new DiceRoller();

rolls = parser.parse("1d6+12", roller);

// Prints the final result
System.out.println(rolls.getTotalRoll());
```

The second example also will roll the expression, generating a random result.

Of course you may want to reuse the expression, avoiding reparsing it, in which case you would do something like this:

```java
final DiceParser parser;
final DiceInterpreter<RollHistory> roller;
final TransformableDiceNotationExpression expression;
RollHistory rolls;

parser = new DefaultDiceParser();

expression = parser.parse("1d6+12");

roller = new DiceRoller();

// Rolls once
rolls = roller.transform(expression);
// Rolls again
rolls = roller.transform(expression);
// And again, generating even more new random value
rolls = roller.transform(expression);
```

For more information about transforming the parsed tree check the [interpreters][interpreters].

[interpreters]: ./interpreter.html
