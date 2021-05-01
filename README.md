# Build Automation Tools- ASE

[![Build Status](https://travis-ci.com/katerinadimatou/Applied-Software-Engineering.svg?token=3uYynQRzsSnj3RgFsvxR&branch=main)](https://travis-ci.com/katerinadimatou/Applied-Software-Engineering)

This repository is dedicated to a simple demonstration of the build automation tools (i.e.,Maven) for the needs of the course "Software Engineering in Practice" offered by the [Department of Management Science and Technology](https://www.aueb.gr/el/content/department-management-science-and-technology) of the [Athens University of Economics and Business](https://www.aueb.gr/).

The goal of this repository is to present the structure of a multi-module Maven project!

## Project Structure

This repository consists of a parent Maven project and one sub-project (modules).

1. [Histogram Generator](https://github.com/katerinadimatou/Applied-Software-Engineering/tree/development/gradeshistogram)- Creates a histogram of frequencies from a given file of grades

Execute the following command in the repository root directory in order to build all modules (in this case the module "Histogram Generator").

```no-highlight
mvn package
```

This command generates a seperate jar file in each module's corresponding target (`module/target`) directory (in this case Histogram Generator's target directory).

### Histogram Generator 

This module requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the `maven-assembly-plugin` plugin and also define the class that is the main entry point of the system (the class that contains the main method).

```no-highlight
<plugin>
	<artifactId>maven-assembly-plugin</artifactId>
	<configuration>
		<archive>
			<manifest>
			  <mainClass>histogramgenerator.JFreeChartXYLineChartDemo</mainClass> 
			</manifest>
		</archive>
		<descriptorRefs>
			<descriptorRef>jar-with-dependencies</descriptorRef>
		</descriptorRefs>
	</configuration>
	<executions>
		<execution>
			<id>make-assembly</id>
			<phase>package</phase>
			<goals>
				<goal>single</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

The produced jar is located in the target (module/target) directory. The grades file should be given as a command-line argument at runtime. The jar can be executed as following:


```no-highlight
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar grades.txt
```

Note that the gradeshistogram-0.0.1-SNAPSHOT.jar is not executable.

### Unit Testing 

Information about the purpose and usage of the module Unit Testing are specified in its [individual README.md](https://github.com/katerinadimatou/Applied-Software-Engineering/blob/development/unittesting/README.md) file



## How to 
1. [Set up Maven in Windows](https://mkyong.com/maven/how-to-install-maven-in-windows/)
2. Set up Maven in Linux: Execute `sudo apt update && sudo apt install maven` in terminal