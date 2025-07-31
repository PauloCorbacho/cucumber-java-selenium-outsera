# Selenium Cucumber Test Automation Project (Java)

This project implements automated tests for an e-commerce website using:
- Java as the main language
- Selenium WebDriver for browser interaction
- Cucumber (BDD) for human-readable test scenarios

## Tested Features

### Login Flow
- Successful login with valid credentials
- Login attempts with invalid data
- Password recovery

### Purchase Flow
- Adding products to cart
- Checkout process
- Shipping cost calculation
- Discount coupon application

## Prerequisites
- Java JDK 8+
- Maven 3.6+
- ChromeDriver (matching your Chrome version)

## How to Run Tests

1. Clone the repository:
git clone [(https://github.com/PauloCorbacho/cucumber-java-selenium-outsera/)]
cd project-folder

2. Execute tests:
mvn clean verify

3. Execution Options:
- Run specific feature:
# Smoke tests only
mvn test -Psmoke

# Login tests only
mvn test -Plogin

- Run in headless mode:
mvn test -Dheadless=true

## Test Reports
The project generates two report types:

1. Basic HTML Report (Cucumber default)
Location: target/cucumber-reports.html
Quick and simple format

2. Advanced Report (optional Maven plugin)
Location: target/cucumber-reports/
Interactive dashboard with detailed metrics

## Available Tags
- @login - Authentication tests
- @checkout - Purchase completion tests
- @smoke - Critical path tests

## Configuration
Project settings can be adjusted in:
- src/test/resources/config.properties - URLs and credentials
- src/test/resources/junit-platform.properties - Cucumber settings

## Contributing
1. Fork the project
2. Create your branch (git checkout -b feature/new-test)
3. Commit changes (git commit -m 'Add new test case')
4. Push to branch (git push origin feature/new-test)
5. Open a Pull Request

## License
MIT License - See LICENSE file for details
