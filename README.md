# individual-project-nidhi-tholar

## Instructions to run the project :
(Route to 'src' directory of the repo)
individual-project-nidhi-tholar >> cd src  <br/>
src >> javac Main.java <br/>
src >> java Main<br/>

•	The program will ask you Enter the following:
1.	File path of Inventory File: (enter absolute file path)
2.	File path of Card data file
3.	File path of Order file <br/>
(Please refer screenshots below)

•	The output files will be written to parent path of the 'Order file path' in the format "output_014738776__RandomInt_.csv" or "error_014738776__RandomInt_.csv" <br/> <br/>
For ex: If path of order file is: "nidhi/project/order.csv" <br/>
Output file path will be: "nidhi/project/output_014738776__5555_.csv"

## Design patterns used:
1. Singleton Pattern:
- The pattern is used to have only instance of internal database class (StaticDB).
- The constructor is made private and a getInstance method is written to ensure only one instance of class is created.
- Please look for StaticDB class in Class diagram.

2. Factory Method:
- The pattern used to handle different types output file. The program can generate two types of output file – a) When order is processed successfully   b) When there’s an error
-	Factory Method is used to create respective object based on successful order processing or error.
-	Participants: <br/>
1 -	Creator – InputOutput Class <br/>
2 -	Product – Output Interface <br/>
3 -	Concrete Products – ErrorOutput and OrderTotalOutput <br/>
(The classes ErrorOutput and OrderTotalOutput implements Output Interface) <br/>

## Class Diagram
<img width="835" alt="Screen Shot 2021-12-05 at 2 13 55 PM" src="https://user-images.githubusercontent.com/91585538/144775198-61f78a7e-0fa5-4d76-bcf5-af8177f078a8.png">


## Screenshots:
Sheet 1: <br/>
<img width="569" alt="sheet1" src="https://user-images.githubusercontent.com/91585538/144775667-e6014a3d-225a-491d-9713-2814b0d5e7cb.png">

<img width="346" alt="sheet1_o" src="https://user-images.githubusercontent.com/91585538/144775753-0d130aef-ca19-4025-ba54-04d28beb2cf1.png">

<br/>Sheet 2: <br/>
<img width="571" alt="sheet2" src="https://user-images.githubusercontent.com/91585538/144775826-82869a24-a806-46cf-892b-9c2f838a7e1e.png">

<img width="539" alt="sheet2_o" src="https://user-images.githubusercontent.com/91585538/144775846-61b6c79a-b0e9-459f-a88c-238e54de9025.png">

<br/>Sheet 3: <br/>
<img width="572" alt="sheet3" src="https://user-images.githubusercontent.com/91585538/144775874-30f1dcb2-e9f0-42b8-bc58-ec034be790d0.png">

<img width="342" alt="Screen Shot 2021-12-05 at 5 15 54 PM" src="https://user-images.githubusercontent.com/91585538/144775890-9531f404-ee6d-4b30-afdd-c4d6aca67f01.png">


