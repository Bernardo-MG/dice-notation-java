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

## Transforming the Parsed Tree

If you need to roll the expression, gather all its dice sets or prepare more complex operations check the [interpreters][interpreters].

[interpreters]: ./interpreter.html
