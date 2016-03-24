# Spring library

## Synopsis

This projects creates basic library service implemented with Spring technology. Due to usage of Spring Beans, Inversion of Control and Aspect Oriented Programming it's good example of creating advanced applications with Spring technology. Also this project is perfect for wide variety of upgrades, starting with adding database support to managing web interface to allow using library in browser.

## Motivation

Project has no actual purpose. It is exercise, which should not make sense on it's own. It's a base for future development and occasion to learn a lot about Spring environment. 

## Install

Project has been developed in Eclipse IDE with Maven technology. To use this repository, it is required to clone it and then import into workspace. All Spring-connected technologies are added by Maven configuration files (pom.xml's).

## Test

Project has 9 tests, which checks it's core functionality. They can be run as Maven goal with Eclipse IDE, or via reposity's author small script called tester.sh, which should be launch in terminal. Tester.sh purpose is to display small amount of information focused on result of tests. To launch it it is required to give script appropriate permissions and call it with:

```
# for Windows (in which project has been developed)

bash tester.sh

# for Unix-based systems

./tester.sh
```

In both test launching options, all 9 tests pass.


