# Dice model and supporting classes

A simple dice model is offered as part of the project. While by itself it makes little, just stores a bit of descriptive info, it can be combined with other classes for things such as generating random values.

## Dice model

![Dice class diagram][dice-class_diagram]

The [Dice][dice] interface is meant to allow creating value objects representing a dice group.

## Dice roller

![Roller class diagram][roller-class_diagram]

To generate random values from the dice classes there is the [Roller][roller]. The default implemention of this interface, the [DefaultRoller][default_roller] makes use of a [NumberGenerator][number_generator] to actually take care of the random number generation concern.

The way a roller works is simple. It generates a random value between one and the number of sides for the dice, and repeats as many times as the quantity of dice it has received. Afterwards it returns the result.

### Number generator

The number generators are to allow tweaking the actual way the random values are generated, in case it is needed. Most of the time just using the default implementation, the [RandomNumberGenerator][random_number_generator], which is based on the Java Random class, is enough.

[dice-class_diagram]: ./images/dice_class_diagram.png

[roller-class_diagram]: ./images/roller_class_diagram.png

[dice]: ./apidocs/com/wandrell/tabletop/dice/Dice.html

[roller]: ./apidocs/com/wandrell/tabletop/dice/roller/Roller.html
[default_roller]: ./apidocs/com/wandrell/tabletop/dice/roller/DefaultRoller.html

[number_generator]: ./apidocs/com/wandrell/tabletop/dice/roller/random/NumberGenerator.html
[random_number_generator]: ./apidocs/com/wandrell/tabletop/dice/roller/random/RandomNumberGenerator.html
