# Dice Notation Tools for Java
Dice notation and algebra, using expressions such as "1d6+5" or "2d10*2", can be parsed and operated with the use of this library.

While Dice or RPG notation exists since the late 70s, it is not completely standardized, depending a lot on the game which uses them, but all of the existing variations keep the same core rules:

* A dice is represented as ndm. Where 'n' is the number of dice and 'm' the number of sides they have.
* Addition and substraction is supported, both for constants and for dice results

Apart from this, a few other modifications have been added to the grammar.

The grammar being used on this library has been created for ANTLR4 and can be found on the path [src/main/antlr4/DiceNotation.g4](src/main/antlr4/DiceNotation.g4).

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