## Java Maven TestNG - Google Search Tests
This repository contains automated tests written in Java, using Maven and TestNG, 
to perform Google search and verify search results. These tests showcase how to set up 
a Selenium WebDriver projects for automated web testing.

### Prerequisites
Before running the tests, make sure you have the following installed on your system:

* Java
* Maven
* IntelliJ IDEA
* Google Chrome
* ChromeDriver Binary (for Chrome WebDriver)

## Getting Started
Clone this repository to your local machine:

```
git clone https://github.com/rehansulehria/google-search-tests.git
```

cd `google-search-tests`

## Set up the Driver Binary:

Download the chromedriver matching your chrome browser version. e.g for Chrome version 117, download the chromedriver 
from the following link for your OS type.

```
https://googlechromelabs.github.io/chrome-for-testing/#stable
```

Place the WebDriver executable in a directory that is included in your system's PATH or update the WebDriver path in the BasePage class
using system property

```
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
```

e.g if running on **_MACOS_**: the binary file is located in the following system path: 
```/usr/local/bin```.
Alternatively you can place the binary on the project root folder and update the path in the BasePage class.

## How to Run the tests:

To run the tests on `MAC-OS`, you can execute the the ``start.sh`` script file from the project root folder.
Make sure to have the execution permission on the file.
```
chmod +x ./start.sh
```
Then run the script file with command
```
./start.sh
```

If you are on `Windows`, you can run the tests using the following command from the project root folder:
```
./start.bat
```

## CI workflow using Github Actions

The project is configured to run the tests on Github Actions. The workflow is defined in the 
``.github/workflows/build.yaml`` file.



## Test Reports

The test reports are generated in the ``/allure-report/index.html`` file.

```
allure generate allure-results --clean -o allure-report
```






