Selenium Framework:
This is a test framework used for web application automation and uses below dependencies.
IDE - Eclipse
TestNG - testing framework
Selenium API
Maven - build tool
Extent Reports - test reporting
Log4j2 - logs
Java - programming language
Design Pattern: POM(Page Object Model)

Project Structure:

configuration:classes that used to fetch project config from src/main/resources/
forms: Page Objects
models: classes that represent the data models of the application under test(POJO classes)
utilities:util classes
src/main/java: 
1)base package has Commons(helps to setup the config.properties file & JSON data file),SetupDriver(helps to trigger the browser based on the browserType key), CustomWaits(contains Thread.sleep function) 
2)pages package includes class for each page of the application
3)Utils package has ExtentReportHelper(used to create Extent Report object),ListenerHelper(uses ITestListener which helps in creating the report as per different functions),
PropertyHeaderHelper(helps to read global config file)
src/main/resources:resource files such as config.properties & log4j2.xml
src/test/java: contains page tests,BaseTest class used for setting up before & after functions.

The project uses a config.properties file to manage global configurations such as url, browser type,username & password.

Test Data:
The project uses JSON file to store test data. Test data is used for new user registration where everytime you need to change the Email ID & Password to get it work.

Browser:
The project contains the implementation for Chrome,Firefox & Edge browsers. 

Page Objects:
The project uses Page Objects to capture the relevant behaviors of a web page. It contains web elements & corresponding methods.

Test case execution:
It uses TestNG as the test runner.Tests can be executed with testng.xml file.

Reporting:
Extent Report is used as a reporting tool. Report data will be placed in extent-reports folder (you canchange it in ExtentReportHelper class file)
