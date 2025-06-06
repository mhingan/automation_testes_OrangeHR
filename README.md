# OrangeHRM Automation Tests

This project contains automated tests for the [OrangeHRM](https://opensource-demo.orangehrmlive.com/) demo application.

The purpose of this project is to validate core functionalities of OrangeHRM through automated functional tests using **Selenium WebDriver** and **TestNG**.

## Project structure

* **Page Object Model (POM)** design pattern is used to ensure maintainable and scalable test code.
* Test cases are grouped by functionality (login, dashboard, PIM, admin, etc.).
* Explicit waits (`WebDriverWait`) are used for stable and reliable test execution.

## Tools & Technologies

* **Java 17**
* **Selenium WebDriver 4.33.0**
* **TestNG 7.8.0**
* **WebDriverManager** for automatic driver management
* **Maven** for dependency management and build

## What is tested

✅ Login functionality (positive and negative scenarios)
✅ Logout functionality
✅ Dashboard elements
✅ PIM module — add, search, edit employees
✅ Admin module — user management
✅ General page navigation and URL verification

## How to run

1️⃣ Clone the project:

```bash
git clone https://github.com/your-username/your-orangehrm-automation-project.git
cd your-orangehrm-automation-project
```

2️⃣ Run tests:

```bash
mvn clean test
```

Or use IntelliJ Maven integration with your configured Maven version (recommended Maven 3.9.x).

## Notes

* The project is built to test the public **OrangeHRM Demo** site:
  [https://opensource-demo.orangehrmlive.com](https://opensource-demo.orangehrmlive.com)

* Credentials used (demo):

  * Username: `Admin`
  * Password: `admin123`

* This project is for **educational and demonstration purposes only** — not for production use.
