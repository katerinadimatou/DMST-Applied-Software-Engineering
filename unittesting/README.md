# Unit Testing Assignment 

This is a Java project that is dedicated to a simple demonstration for Unit Testing for the needs of the course "Software Engineering in Practice" offered by the [Department of Management Science and Technology](https://www.aueb.gr/el/content/department-management-science-and-technology) of the [Athens University of Economics and Business](https://www.aueb.gr/).

The classes that are tested are ArithmeticOperations.java, MyMath.java and ArrayOperations.java in the math package and FileIO.java in the io package.


## Build Project
In order to build the project execute the following Maven command:
```no-highlight
mvn clean install jacoco:report
```

This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
In order to build the project execute the following Maven command:
```no-highlight
target/site/jacoco
```

## Test Project 
To run the unit tests of the project, execute the following Maven command:
In order to build the project execute the following Maven command:
```no-highlight
mvn test
```

## Generate Test-Coverage Jacoco report
To simply run the unit tests of the project, execute the following Maven command:
```no-highlight
mvn test jacoco:report
```
## Continuous Integration service

This projects utilizes TravisCI services in other to test and build the application upon each git-push in the remote repository.


## Jacoco Plugin
```no-highlight
<build>
		<plugins>
			<!-- required for code coverage reporting -->
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.3</version>
				<executions>
					<execution>
						<id>prepare-agent</id>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			</plugins>
	</build>
```


## JUnit Dependency 

```no-highlight
<!-- https://mvnrepository.com/artifact/junit/junit -->
	<dependency>
    	<groupId>junit</groupId>
    	<artifactId>junit</artifactId>
    	<version>4.12</version>
   	<scope>test</scope>
	</dependency>
```

## Mochito-core Dependency
```no-highlight
 <!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
	<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.9.0</version>
    <scope>test</scope>
	</dependency>
```
