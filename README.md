## international-api-test
# API Test with RestAssured
## This Java code, authored by Carlos Bonfatti, performs a GET request to a specific endpoint (/posts at the baseURI "https://jsonplaceholder.typicode.com") using the RestAssured framework to test an API. It receives the API response, converts the data into a JSONArray, and then iterates over the JSON objects in that array. For each object, it extracts the title ("title"), assumes all posts are published, and sets the publication date and update date to the current date and time formatted with DateTimeFormatter. It then constructs a string in Markdown format with this data and prints it to the console. Finally, it writes this string to a file named "posts_log.md".

## Project Structure
The project consists of the following files:

## listValuesTest.java: Contains the main code for performing the API test.
pom.xml: Maven configuration file defining project dependencies and Java version.
Prerequisites
Ensure you have the following software installed on your system:

## Java Development Kit (JDK) 11 or higher
Maven
Appium Server 2.2.2
Android SDK for testing on Android devices
Xcode and iOS Simulator or iOS device for testing on iOS devices
Setup
Clone this repository to your local environment.
Open the project in your preferred IDE.
The Maven dependencies are correctly configured in the pom.xml file.
Check the Appium settings in the src/test/java/com/bonfatti/Hooks.java file.
Configure device capabilities in the src/test/resources/capabilities.json file.
Running the Tests
To run the tests, follow these steps:

## Open a terminal at the project root.
Execute the following command:
bash
Copiar código
mvn test
This will start the test execution using JUnit Jupiter.

## Generating Allure Reports
This project is configured to generate detailed reports using the Allure Report. To generate the report, follow these steps:

## After running the tests, open a terminal at the project root.
Execute the following command to generate the reports:
Copiar código
mvn allure:report
This will generate the reports in the allure-report directory and automatically open the report in your default browser.

## Author
Carlos Bonfatti