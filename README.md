# individual-project-nidhi-tholar

## Instructions to run the project :
individual-project-nidhi-tholar >> cd src  <br/>
javac Main.java <br/>
java Main<br/>

•	The program will ask you Enter the following:
1.	File path of Inventory File: (enter absolute file path)
2.	File path of Card data file
3.	File path of Order file <br/>
(Please refer screenshots below)

•	The output files will be written to output_files folder of the project (individual-project-nidhi-tholar/output_files)

## Design patterns used:
1. Singleton Pattern:
- The pattern is used to have only instance of internal database class (StaticDB).
- The constructor is made private and a getInstance method is written to ensure only one instance of class is created.
- Please look for StaticDB class in Class diagram.

2. Factory Method:
- The pattern used to handle different types output file. The program can generate two types of output file – 
- - a) When order is processed successfully
- - b) When there’s an error
-	Factory Method is used to create respective object based on successful order processing or error.
-	Participants:
1 -	Creator – InputOutput Class
2 -	Product – Output Interface
3 -	Concrete Products – ErrorOutput and OrderTotalOutput
(The classes ErrorOutput and OrderTotalOutput implements Output Interface)


