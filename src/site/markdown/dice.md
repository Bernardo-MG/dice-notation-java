# Dice model and supporting classes

A simple dice model is offered as part of the project, including not only a representation for dice groups, but also a way to generate random values from them.

## Dice model

![Dice class diagram][dice-class_diagram]

The [Dice][dice] interface represents its namesake.

## Dice roller

![Roller class diagram][roller-class_diagram]

The [Roller][roller] generates random values from the dice classes. The default implemention of this interface, the [DefaultRoller][default_roller] makes use of a [NumberGenerator][number_generator] to actually take care of the random number generation concern.

The way the default roller works is simple. It generates a random value between one and the number of sides for the dice, and repeats as many times as the quantity of dice it has received. Afterwards it returns the result.

### Number generator

![Number generator class diagram][number_generator-class_diagram]

The number generators are meant to allow tweaking how the random values are generated. Most of the time just using the default implementation, the [RandomNumberGenerator][random_number_generator], which uses the Java Random class, is enough.

[dice-class_diagram]: ./images/dice_class_diagram.png
[number_generator-class_diagram]: ./images/number_generator_class_diagram.png
[roller-class_diagram]: ./images/roller_class_diagram.png

[dice]: ./apidocs/com/bernardomg/tabletop/dice/Dice.html

[roller]: ./apidocs/com/bernardomg/tabletop/dice/roller/Roller.html
[default_roller]: ./apidocs/com/bernardomg/tabletop/dice/roller/DefaultRoller.html

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
[random_number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/RandomNumberGenerator.html
