# Usage example

If needed the dice model, or even the dice notation one, can be used directly. But the recommended way to handle dice notation with the library is with the help of the included parser.

```java
final DiceNotationParser parser;
final DiceNotationExpression parsed;

parser = new DefaultDiceNotationParser(new DefaultRoller());

parsed = parser.parse("1d6+12");

System.out.println(parsed.generateValue());
```

The previous example will process the received expression, which asks for rolling a six sided dice and adding the value twelve to it. Each time the 'generateValue' method is called the result of this expression is calculated and a new random value generated.
