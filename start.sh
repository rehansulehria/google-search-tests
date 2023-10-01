#!/bin/bash

# clean install dependencies
mvn clean install -DskipTests
# Run your Selenium tests
mvn test
