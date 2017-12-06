# Dice Notation Tools for Java

This project aims to make the dice notation readable by Java applications, and for this it offers both a model representing it and a parser which can instantiate the model from dice notation expressions.

Created on the late 70s for Dungeons & Dragons, the dice notation has become a standard on tabletop games as it allows generating random values in concrete distributions with the help of simple formulas such as '2d6+5', which means "roll two dice, add their values and then add the number five to the result".

With the pass of years it has evolved, and while it never underwent a formal standardization process a core set of rules is kept among all the variations, mostly representing dice in a format such as '1d6', and the use of algebra operations like addition and subtraction.

Its usefulness is very clear, it allows working with specific random values distributions. And while this is no feat for a machine, which has better tools for it, the aim of the project is not actually handling those distributions, but giving a way for applications to work with the same tools a board game would have.

[![Maven Central](https://img.shields.io/maven-central/v/com.bernardomg.tabletop/dice.svg)][maven-repo]
[![Bintray](https://api.bintray.com/packages/bernardo-mg/tabletop-toolkits/dice/images/download.svg)][bintray-repo]

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

[![Release javadocs](https://img.shields.io/badge/javadocs-release-blue.svg)][javadoc-release]
[![Development javadocs](https://img.shields.io/badge/javadocs-develop-blue.svg)][javadoc-develop]

## Features

- ANTLR4 grammar
- Model for dice and dice notation, along classes to generate values from them
- Parser to create model instances from the notation

## Limitations

- Currently only the most basic operations (dice, numbers and additions or subtractions) are supported

## ANTLR4 grammars

The grammar is included among the [ANTLR4 sample grammars][antrl-grammars].

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The documentation site sources come along the source code (as it is a Maven site), so it is always possible to generate them using the following Maven command:

```
$ mvn verify site
```

The verify phase is required, as otherwise some of the reports won't be created.

## Usage

The application is coded in Java, using Maven to manage the project.

### Prerequisites

The project has been tested on the following Java versions:
* JDK 8

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

The recommended way to install the project is by setting up your preferred dependencies manager. To get the configuration information for this check the [Bintray repository][bintray-repo], or the [Maven Central Repository][maven-repo].

If for some reason manual installation is necessary, just use the following Maven command:

```
$ mvn install
```

### Usage example

If needed the dice model, or even the dice notation one, can be used directly. But the recommended way to handle dice notation with the library is with the help of the included parser.

```java
final DiceNotationExpressionParser parser;
final DiceNotationExpression parsed;

parser = new DefaultDiceNotationExpressionParser(new DefaultRoller());

parsed = parser.parse("1d6+12");

System.out.println(parsed.getValue());
```

The previous example will process the received expression, which asks for rolling a six sided dice and adding the value twelve to it. Each time the 'generateValue' method is called the result of this expression is calculated and a new random value generated.

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under version 2.0 of the [Apache License][license].

[antrl-grammars]: https://github.com/antlr/grammars-v4
[bintray-repo]: https://bintray.com/bernardo-mg/tabletop-toolkits/dice/view
[maven-repo]: http://mvnrepository.com/artifact/com.bernardomg.tabletop/dice
[issues]: https://github.com/Bernardo-MG/dice-notation-java/issues
[javadoc-develop]: http://docs.bernardomg.com/development/maven/dice/apidocs
[javadoc-release]: http://docs.bernardomg.com/maven/dice/apidocs
[license]: http://www.apache.org/licenses/LICENSE-2.0
[scm]: http://github.com/Bernardo-MG/dice-notation-java
[site-develop]: http://docs.bernardomg.com/development/maven/dice
[site-release]: http://docs.bernardomg.com/maven/dice