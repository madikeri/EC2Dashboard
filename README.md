# EC2 Instance Dashboard


This is a java Spring based web application that allows the user to view all the mocked up instances that are currently in the database and their status and details. The interface also allows the user to to sort and search based on specific fields. In memory H2 database is used to store the mocked up data


### Prerequisites

- Maven
- Java 
- Tomcat
- Eclipse (optional) - to view code and for running from eclipse
```
Give examples
```

### Installing

#### Install Java 
	Java SE Development Kit
	```
	In your ~/.bash_profile, set the JAVA_HOME environment variable.
	export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home"
	# change "jdk1.8.0_40.jdk" to the actual folder on your system, which depends on your version of Java.
	```
#### Install Maven 
	On the Apache website, download the Binary zip of the current version.
	Uncompress and move the folder to a convenient location (for example: ~/bin).
	```
	In your ~/.bash_profile, add a MAVEN HOME environment variable pointing to that folder. For example:
	export MAVEN_HOME=~/bin/apache-maven-3.3.1
	export PATH=$PATH:$MAVEN_HOME/bin
	```
	
#### Install Tomcat
	On the Apache website, under Binary distributions, under Core, download the zip file.
	Uncompress and move the folder to a convenient location (for example: ~/bin).
	Make the scripts in the bin subfolder executable:
	```
	chmod +x bin/*.sh
	```

### Running the application

* Clone the repository to a local folder
* From the command line: go to the folder, that has the pom.xml file, and enter the following command: 
	```
	mvn clean install spring-boot:run
	```
* Once the server has started, go to a web browser and go to localhost:8080
* Login using - user: "user" and password: "password"

### Features

	* User needs to login with a user name and password
	* Sort by any column by clicking on the column names
	* Filter by Instance name or Type
	* Search based on any specific fields
	* Results are paged 
	* 2 automated tests
	* Deployed on Heroku at - 


### Running the tests

There are 2 tests, one is a junit test and the other is an integration test

TestEc2 - Creates 2 test instances and checks if the ListAll function returns back 2 instance and compares the name of the instance

	* From Eclipse, open the test file: TestEc2.java
	* Right and select "Run as" and click "JUnit Test"

IntegrationTestEc2 - Tests if the data in the H2 memory matches 19 instances as we have loaded 19 instances in the Baseloader.java. It also  checks if the ListAll function returns back the correct name for the first instance "A_instance"

	* From Eclipse, open the test file: IntegrationTestEc2.java
	* Right and select "Run as" and click "JUnit Test"


## Author

* **Gayathri Kulathumani** 

