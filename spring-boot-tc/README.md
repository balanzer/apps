# PFM Internaltools

## Maven Compile

1. mvn clean install
2. mvn clean install -DskipTests (to skip unit tests)


## Running Sonar 

Install Sonar   - https://docs.sonarqube.org/display/HOME/SonarQube+Platform

1. Download and unzip the SonarQube distribution (let's say in "C:\sonarqube" or "/etc/sonarqube")

2. Start the SonarQube server
	# On Windows, execute:
	C:\sonarqube\bin\windows-x86-xx\StartSonar.bat
	
3. Download and unzip the SonarQube Scanner, Follow Installation steps

4. run sonar-scanner or mvn sonar:sonar	

5. Open - http://localhost:9000/
