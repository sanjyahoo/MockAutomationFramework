# 🚀 Mock Automation Framework

This is a modular and extensible automation testing framework built with Java, Selenium WebDriver, and TestNG. It follows best practices like Page Object Model (POM), central configuration, utility reusability, and listener-based logging and reporting. Ideal for scalable web UI testing and CI/CD pipelines.

---

## 📁 Project Structure

MockFramework/
├── src/
│ ├── main/java/
│ │ ├── base/ # Base classes for driver setup and test initialization
│ │ ├── config/ # Centralized configuration management
│ │ ├── drivers/ # Browser driver setup
│ │ ├── pages/ # Page Object Model classes
│ │ ├── utils/ # Utilities like waits, screenshots, data handlers
│ │ └── Listners/ # TestNG listeners for logging/reporting
│ └── test/java/
│ └── tests/ # Test classes organized by features
├── testng.xml # Test suite configuration
├── pom.xml # Maven dependencies and build config
├── Jenkinsfile (optional)
└── test-output/ # TestNG output reports


---

## ⚙️ Tech Stack

| Layer        | Tool / Library             |
|--------------|----------------------------|
| Language     | Java                       |
| Test Runner  | TestNG                     |
| UI Automation| Selenium WebDriver         |
| Build Tool   | Maven                      |
| Reporting    | TestNG default + Listeners |
| Versioning   | Git                        |
| CI/CD        | Jenkins (optional)         |

---

## ✅ Features

- 🚗 Cross-browser automation setup
- 🧩 Page Object Model (POM)
- 🔁 Reusable base and utility classes
- 📋 Config-driven execution
- 🔍 Listener integration for logging and reporting
- 📊 TestNG-based test suite management

---

## 🚀 Getting Started

### 🧰 Prerequisites

- Java JDK 11+
- Maven
- Git
- Chrome/Firefox installed

### 🔧 Installation

```bash
# Clone the repository
git clone https://github.com/your-username/MockFramework.git
cd MockFramework

# Run tests
mvn clean test

# Execute all tests defined in testng.xml
mvn test