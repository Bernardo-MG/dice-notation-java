# Dice Notation Tools for Java
With the use of this library dice notation and algebra, using expressions such as "1d6+5" or "2d10*2", can be parsed and operated.

This notation is widely used on tabletop games, such as wargames or RPGs, and was created on the late 70s for Dungeons & Dragons.

With the pass of years it has evolved, and while it never underwent a formal standarization process a core set of rules is kept among all the variations:

* A dice is represented as xdy. Where 'x' is the number of dice and 'y' the number of sides they have.
* Integer numbers can be added and substracted from the results.
* It is possible to swap a dice for a constant. They are both the same kind of term inside a dice algebra operation.

To handle this, and a few additional modifications, a grammar has been created using ANTLR4, which can be found in the path [src/main/antlr4/DiceNotation.g4](src/main/antlr4/DiceNotation.g4).

### Webpage
Currently the project has no webpage.

#### Documentation webpage
The project has a [Maven site][] and [Javadoc page][] with the information from the latest release.

There is also a [development Maven site][] and a [development Javadoc page][], generated from the latest development snapshot.

### Status
The project is still under development, so expect a certain degree of volatility.

Still, it is mostly stable, and classpath or name changes should be infrequent, but classes may be added or removed without warning.

#### Issues management
Issues are managed at the GitHub [project issues page][].

## Building the code
The application is coded in Java, using Maven to handle the project's configuration and tests.

### Prerequisites
Has been tested on the following Java versions:
* JDK 7
* JDK 8
* OpenJDK 7

All other dependencies are handled through Maven, and noted in the included POM file.

### Getting the code
The code can be found at the GitHub [project page][].

To acquire it through Git use the following clone URI:

`git clone https://github.com/Bernardo-MG/Tabletop-Dice-Java.git`

#### Repository
Releases can be found in the [releases repository][] on Bintray.

It can be added to Maven as a repository using the following URI:
`http://dl.bintray.com/bernardo-mg/maven`

## Continuous integration
The continuous integration information can be found at the [project CI page][] based on Travis CI.

## License
The project is released under version 2.0 of the [Apache License][].

[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
[development Javadoc page]: http://docs.wandrell.com/development/maven/tabletop-dice-java/apidocs
[development Maven site]: http://docs.wandrell.com/development/maven/tabletop-dice-java
[Javadoc page]: http://docs.wandrell.com/maven/tabletop-dice-java/apidocs
[Maven site]: http://docs.wandrell.com/maven/tabletop-dice-java
[project CI page]: https://travis-ci.org/Bernardo-MG/Tabletop-Dice-Java
[project issues page]: https://github.com/Bernardo-MG/Tabletop-Dice-Java/issues
[project page]: http://github.com/Bernardo-MG/Tabletop-Dice-Java
[releases repository]: http://dl.bintray.com/bernardo-mg/tabletop-dice-java