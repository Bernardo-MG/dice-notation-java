# Dice Notation Interpreter

Once the notation has been parsed the resulting [DiceNotationExpression][dice_notation_expression] can be transformed into other object with a [DiceInterpreter][dice_interpreter].

The two main implementations are the [DiceRoller][dice_roller], to generate a random values from the parsed expression, and the [DiceGatherer][dice_gatherer], to get all the dice sets in the expression.

## Applying Interpreters

They can be applied when parsing:

```java
final DiceInterpreter<RollHistory> interpreter;
final RollHistory history;

interpreter = new DiceRoller();

history = new DefaultDiceParser().parse("2d6+12", interpreter);
```

But in some cases they may be applied manually to the parsed result, mostly when it will be transformed multiple times, as it may happen when rolling.

## Dice Roller

To roll the expression:

```java
final RollHistory history;

history = new DiceRoller().transform(parsed);
```

The result includes the final value:

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

The default roll history also prints a clean text output:

```java
// Prints the full history
System.out.println(history.toString());
```

Which for the expression "4d6+5" may look similar to "[4 5 6 4] + 5";

Each time it is called a new set of data will be generated, rolling again all the dice. So the final values may change.

### Changing Random Number Generation on Parsed Dice

Random numbers, for rolling dice, are handled through an instance of [NumberGenerator][number_generator].

To use a custom generator you need to implement this and then set the new generator into the interpreter:

```java
final NumberGenerator numGen;
final DiceInterpreter<RollHistory> interpreter;

numGen = new RandomNumberGenerator();
interpreter = new DiceRoller(numGen);

System.out.println(interpreter.transform(parsed));
```

### Customizing Roll History

The dice roller can receive a function which will be applied after generating each roll result:

```java
interpreter = new DiceRoller(new DiceToRollResult(), (r) -> function(r));
```

## Dice Gatherer

If you need to get the dice from the expression:

```java
final DiceInterpreter<Iterable<Dice>> interpreter;
final Dice dice;

interpreter = new DiceGatherer();

dice = interpreter.transform(parsed).iterator().next();

System.out.println(dice.getQuantity());
System.out.println(dice.getSides());
```

This will print the number of dice (1) and the number of sides (6).


## Traversers

Complex operations will require traversing the parsed tree. For these cases there are the following interpreters:

* InorderTraverser
* PostorderTraverser
* PreorderTraverser

## Custom Interpreters

The easiest way to create a new interpreter is by composing it with one of the traversers, which will return a list with all the objects in the expression.

The ConfigurableInterpreter can help with this. For example this is the actual dice roller interpreter:

```java
wrapped = new ConfigurableInterpreter<>(new PostorderTraverser(),
        () -> new DiceRollAccumulator(roller));
```

It just needs another interpreter, which returns a list of nodes, and an accumulator.

[dice_gatherer]: ./apidocs/com/bernardomg/tabletop/dice/interpreter/DiceGatherer.html
[dice_interpreter]: ./apidocs/com/bernardomg/tabletop/dice/interpreter/DiceInterpreter.html
[dice_notation_expression]: ./apidocs/com/bernardomg/tabletop/dice/notation/DiceNotationExpression.html
[dice_roller]: ./apidocs/com/bernardomg/tabletop/dice/interpreter/DiceRoller.html
[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/random/NumberGenerator.html
