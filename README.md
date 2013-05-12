sea
===

##Introduction

"sea" is a DNA sequence analyzing tool which is programmed for the third category (Java, Ruby or C#) of the fifth coding 
contest ("http://www.coding-contest.de").

"sea" stands for **se**quence **a**nalyzer.

The main purpose of this tool is to recieve a text file with a 1000-nucleobase long segment of a DNA and analyze 
it to several questions given in the task of of the coding contest.

##Solution to the given Tasks
To get the answers to the questions given in the task, please check out the LogicIntegrationTest, which can be found in `src/test/java/LogicIntegrationTest.java`

##How to use the application

1. Start the runnable .jar file.
2. Click on 'Choose File' and select a text file (*.txt) which contains a DNA sequence you want to analyze.
3. Click on 'Analyze'. Now a report will be created and showed to you.
4. (optional)  Click on 'New Report' to get back to the first screen for loading a new file. 

That's all you need to do!

##System requirements

You need an actual Java 7 installation on your computer to run this application.
To build the application you need an installation of Maven 3. 
For more information to build and run the application, please check out the INSTALL.md.

##Technologies

This software was programmed in Java with its UI-Technology JavaFX2.2. To build the application Maven was used. For testing purposes I used JUnit. 

##Design of the application

###User Interface

For the user interface of the application the new standard UI-technology JavaFX2.2 was used. I decided to use a flat design according to the actual design trend for user interfaces. With its simple and clear structure the user gets all the information on one place. 
The blue color scheme for the application stands in a correlation with the name of the application. 
All objects with round corners charaterizes objects the user could interact with.

##Licence

This software is licenced under the GPLv3. See the LICENCE.md for more information.
