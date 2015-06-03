# Dice Notation Tools for Java
With the use of this library dice notation and algebra, using expressions such as "1d6+5" or "2d10*2", can be parsed and operated.

This notation is widely used on tabletop games, such as wargames or RPGs, and was created on the late 70s for Dungeons & Dragons.

With the pass of years it has evolved, and while it never underwent a formal standarization process a core set of rules is kept among all the variations:

* A dice is represented as xdy. Where 'x' is the number of dice and 'y' the number of sides they have.
* Integer numbers can be added and substracted from the results.
* It is possible to swap a dice for a constant. They are both the same kind of term inside a dice algebra operation.

To handle this, and a few additional modifications, a grammar has been created using ANTLR4, which can be found in the path [src/main/antlr4/DiceNotation.g4](src/main/antlr4/DiceNotation.g4).

## Features

The library contains the following features:

- ANTLR4 grammar
- Model for dice and dice notation, along classes to generate values from them
- Parser to create model instances from the notation

## Documentation
Documentation is always generated for the latest release:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The site sources come along the source code, so it is always possible to generate them using the Maven site command.

## Building the code
The application is coded in Java, using Maven to handle the project's configuration and tests.

### Prerequisites
The project has been tested on the following Java versions:
* JDK 7
* JDK 8
* OpenJDK 7

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

Thanks to Maven, the project is easy to install, by just using the following command:

```mvn install```

But the recommended way to install the project is by using the code repositories, where the releases and snapshots are stored. The way to set this is detailed on the documentation page.

## Collaborate

The project is still under ongoing development, and any help will be well received.

There are two ways to help: reporting errors and asking for extensions through the issues management, or forking the repository and extending the project.

### Issues management
Issues are managed at the GitHub [project issues page][issues].

Everybody is allowed to report bugs or ask for features.

### Getting the code
The latest version of the code can be found at the [GitHub project page][scm].

Feel free to fork it, and share the changes.

## License
The project is released under the [MIT License][license].

[issues]: https://github.com/Bernardo-MG/tabletop-dice-java/issues
[javadoc-develop]: http://docs.wandrell.com/development/maven/tabletop-dice/apidocs
[javadoc-release]: http://docs.wandrell.com/maven/tabletop-dice/apidocs
[license]: http://www.apache.org/licenses/LICENSE-2.0
[scm]: http://github.com/Bernardo-MG/tabletop-dice-java
[site-develop]: http://docs.wandrell.com/development/maven/tabletop-dice
[site-release]: http://docs.wandrell.com/maven/tabletop-dice