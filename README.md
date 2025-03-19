
# ParserEjadaJackson

# APIs test framework
This project is an API testing framework built using RestAssured for API testing, TestNG for test execution and reporting, and Maven for dependency management. It tests the ReqRes API and includes tests to create, retrieve, and update a user.

# Features!
-Reads URL from config file
-insert new users and store new id 
-  retrieve and update user data
- Maven
- CI ready (run maven commands)

# Prerequisites
- Java 8 or higher "JDK and JRE"
- Maven for dependency management
- IntelliJ IDEA (or any Java IDE)

# Dpendecies
RestAssured: A Java DSL for testing RESTful APIs.
TestNG: A testing framework used for test execution and reporting.
Maven: A build automation tool used for managing project dependencies.
SLF4J: A logging framework used for logging errors (optional but useful).
Dependencies are managed through Maven and defined in the pom.xml file.

# Setup Instructions
1. Clone the Repository
   Project is hosted on GitHub, clone it using the following command:
```sh
$ git clone https://github.com/reemahmed-ejada/APIsFramework.git
```

2- Build the Project from the directory which contain the cloned project

```sh
$ mvn clean install
```
3-Install the dependencies using this command

```sh
$ mvn dependency:sources
```
4- Run

```sh
mvn test
```
5- Tests can be run from IDE directlly 
