# **Tests for PayPal API using RestAssured and Cucumber**

This repo contains automation tests for [PayPal](https://docs.stripe.com/api) using RestAssured.

## **#Requirments**
- JAVA
- MAVEN
- IDE of your choice

## **#Setting Up**

- Download the repo to your local system.
- Make sure you have all the dependencies required to execute the tests ready like Maven, JDK and JAVA installed.
- Open the project in IDE of your choice.
- Install TestNg plugin to your IDE in case you are using Eclipse, In case of IntelliJ TestNg is available by default.
- Download the JDK if your system is missing it.
- Execute the testng.xml by right-clicking it and selecting "Run".

## **#Pre conditions for executing tests**
- Create a paypal account to access the data.
- Get the secret key from the dev options from Paypal portals.
- Place the secret key in `./src/test/resources.properties/config.properties` file.

## **#Executing tests and Viewing reports**
The tests can be executed by either of the following methods:
- Execute the testng.xml by right-clicking it and selecting "Run".
- Execute the command `mvn clean` to clean the target folder, followed by `mvn test` to execute the tests.
- The reports can be accessed in the Reports folder.