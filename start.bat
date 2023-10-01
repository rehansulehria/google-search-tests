@echo off

rem Clean and build the Maven project (if needed)
mvn clean install -DskipTests

rem Run your Selenium tests
mvn test
