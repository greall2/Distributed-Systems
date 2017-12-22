# Distributed-Systems
Assignment for Distributed Systems Module - 4th Year Software Development
Ríona Greally - G00325504

### An Asynchronous RMI Dictionary Service

Client is running on Tomcat Server v9. The Client enters a word to search the dictionary.

The word is then passed through to a remote object on a remote server to search the dictionary. 
The user will recieve the result but will not have direct access to the dictionary file and the implementation is hidden from the user.

	NOTE: dictionary.csv only contains 50 words for example some are:

	Allure
	Alter
	Babble
	Bachelor
	Backboard
	Cabin
	Cable
	Each
	Gain
	Hang
	Jug
	Laboratories
	Laboratory

##### Run the Application 

    Download the job-server.war and the dictionary-service.jar files from github

    In the CMD, direct to the folder where the JAR file is located and run the following command:

	          java -jar dictionary-service.jar

    The CMD shout output "server ready"

            

    Paste the WAR file into the webapps folder of Tomcat directory.

    In a seperate CMD, direct rto the bin folder of the Tomcat Server Folder
    and enter "startup" to activate the Tomcat server.

    Open a browser and go to:

          	localhost:8080/job-server

    The aplication should be up and running now!
    To close down Tomcat enter the command "shutdown" in the CMD
