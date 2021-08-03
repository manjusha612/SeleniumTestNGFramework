**Pre Requisites**

1. Install Chrome Browser version 89 or above
2. Install Java 8
3. You may use any IDE of your choice to run the project

**Project Specification**

1. Language: Selenium WebDriver with Java 8
2. Build tool: Maven
3. Framework: TestNG Framework using Java and Maven
4. Report path: SeleniumTestNGFramework\\Report\\{Date of execution}\\Report_{timestamp}.html
5. Browser used: Chrome (Version: 90, ChromeDriver version: 89)
6. IDE used: IntelliJ IDEA Community Edition (version 2021.1)
7. Operating System Used to develop the test scripts and framework: Windows 10 (Don't have access to any other OS)

**Run**

1. Before running the testng.xml file, please update the {UName} and the {Password} field in the "GlobalProperties.properties" file present in the project. Currently, a set of test credentials is provided.
2. The project can be run using the testng.xml file present in the project. You can right click and run the file using your IDE.
3. If you face this error "Error: Could not find or load main class org.testng.remote.RemoteTestNG" while running the testng.xml in eclipse IDE, then right click on the project, select "Properties", click on "TestNG", uncheck checkbox "Use Project TestNG jar", click on "Apply" and then "Close". Run the testng.xml again and it should solve your issue. 

**Challenges while setup**

1. While setting up the framework, disconnect any VPN or go behind the firewall as it may not let the pom.xml to connect
   to Maven repo and download the dependencies of the project.
2. Once all maven dependencies are downloaded, update or refresh the project
