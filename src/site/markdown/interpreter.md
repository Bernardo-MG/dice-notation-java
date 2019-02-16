# Dice Notation Interpreter

Once the notation has been parsed it can be transformed into other object with a DiceInterpreter.

The two main implementations are the DiceRoller, to generate a random values from the parsed expression, and the DiceGatherer, to get all the dice sets in the expression.

## Dice Roller

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
final DiceInterpreter interpreter;

numGen = new CustomNumberGenerator();
interpreter = new DiceRoller(numGen);

System.out.println(interpreter.transform(parsed));
```

## Dice Gatherer

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


## Traversers

Complex operations will require traversing the parsed tree. For these cases there are the following interpreters:

* InorderTraverser
* PostorderTraverser
* PreorderTraverser

## Custom Interpreters

The easiest way to create a new interpreter is by composing it with one of the traversers, which will return a list with all the objects in the expression.

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
