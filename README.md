# MowItNow

[![Build Status](https://travis-ci.org/saidbouig/MowItNow.svg?branch=master)](https://travis-ci.org/saidbouig/MowItNow)

## Used technologies

    Java - JDK 8
    Maven
    Lombok
    Git
    Travis
    
    * Functional programming: [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * Tests: [JUnit 5](https://junit.org/junit5/)
    * Test Driven Development: [TDD](https://en.wikipedia.org/wiki/Test-driven_development)
    
## Installation

    git clone https://github.com/saidbouig/MowItNow.git
    cd MowItNow
    mvn clean install
    
## Run
    
    java -jar ./target/mowItNow-1.0.0.jar <full_path_to_input_file>
    
### Input example

    55
    12 N
    GAGAGAGAA
    33 E
    AADAADADDA

### Excpected output

    13 N
    51 E