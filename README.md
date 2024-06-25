# Playwright with Java Tests

## Introduction
This project contains automated UI tests implemented using Playwright using Java for testing different forms hosted on https://play1.automationcamp.ir/forms.html

## Features
- Basic form controls
- Form error validations
- Validating Non-English Labels and Locators

## Setup Instructions
1. Clone the repository.
2. Install Java JDK (version 11 or higher).
3. Install Maven (version 4.0.0 or higher).
4. Run `mvn clean install` to install dependencies.

## Running Tests
To run tests locally:
- Execute `mvn test` from the project root directory.
- Alternatively you can right-click on testng.xml file and then click on Run option
  ![image](https://github.com/sharraut7294/FormControlTestSuite/blob/master/FormTestExecution.png)
  

## Playwright Overview
Playwright is a powerful automation library developed by Microsoft for testing web applications. It offers several key features:

- Cross-Browser Testing: Supports Chromium, Firefox, and WebKit browsers.
- Multiple Languages: Provides bindings for JavaScript, TypeScript, Python, and Java.
- Headless and Headful Mode: Run tests in headless mode for faster execution or in headful mode for debugging.
- Native Event Automation: Automates user interactions such as clicks, typing, and scrolls in a way that simulates real users.
- Network Interception: Modify network requests and responses to simulate various network conditions and test edge cases.
- Intuitive API: Clean and easy-to-use API for navigating web pages, interacting with elements, and handling complex scenarios.

## TestNG Integration
- TestNG is used as the test runner framework to organize and execute tests in this project. It provides powerful annotations and features for test management and reporting.

## Allure Reporting
- Allure is integrated for generating comprehensive and interactive test reports.
- After running tests, generate and view reports using the following command: `allure serve target/allure-results`.
