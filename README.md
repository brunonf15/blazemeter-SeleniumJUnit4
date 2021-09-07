# Test Google Maps using Selenium and JUnit

This objective of this project is to test some Google Maps scenarios based on this requirements:

QA Engineer - Technical Challenge:

Selenium Tech Test:
Write a short automated test of the following using Selenium and NUnit/JUnit in an
OO language (e.g. C#/Java/Python).
1. Go to https://www.google.com/maps
2. Enter Dublin in the search box
3. Search
4. Verify left panel has "Dublin" as a headline text
5. Click Directions icon
6. Verify destination field is "Dublin"

Use element locator methods as necessary. Implement as many assertions as you deem applicable

## Dependencies:

The dependencies from this project are:

Java SDK

Windows (Unix system wasn't tested, and because of that I can't ensure your running as well)

Chromedriver

Google Chrome

### To run the tests execute:

```
mvn test
```

### To generate the report execute:

```
mvn surefire-report:report
```

This project is a fork for How to Run a Selenium Test with JUnit:

https://www.blazemeter.com/blog/how-to-run-a-selenium-test-with-junit/


