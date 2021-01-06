# Introduction
The purpose of this project is to showcase the functionality of a game called **Business Simulator**. The original game was envisioned by a group of students as part of their 
development project for the class. We took their concepts and ideas and created a working rough draft of the final game. The project contains many of the core concepts of the
game, and gives a basic idea of what the final product would look like. 

# Tools
* Java 11
* JavaFX
* Google Maps API
* JavaScript/HTML5
* Eclipse IDE

# Development 
During the initial development phase we encountered various issues, and one of them was that the Google Maps API was used primarly in JavaScript. This was a big issue because as 
a group we needed to be able to work in a language that we were all knowledgeable in. We had discussions about what language to use and we decided that using Java with JavaFX would 
be the most benificial to everyone. However, we began to have doubts over being able to use the Google Maps API with Java and JavaFX, because there were very few sources that had 
attempted to do so. We had further discussions about leaving JavaFX behind and moving on to another plataform that supported Google Maps API such as Android. Although I would of 
been more than accepting to move to a different plataform I believed that this would've severely hinder our productivity as we would've have to learn both a plataform from the
ground up while also trying to code the project. With all of this in mind I decided to dedicate a significant amount of time to find if there was any possible solution to keep 
working with JavaFX. 

# Solution
Looking through various online sources I began to look for the best way to connect a JavaScript/HTML5 file with a Java file. I found this task to be rather hard at first with 
the constraints I had to work with. However, through long periods of research I found that I could use the Java 11 classes of **Web Engine** and **Web View**. Using these two
classes I was able to create communication between my different files and load a working Google Map in the JavaFX UI. This initial victory was short lived as I was only able to 
set a one way communication channel which only allowed the JavaScript/HTML5 file to send the appropriate information to the Java files. My next goal was to set a two way communication channel between the Java file and the JavaScript/HTML5 file. With a little more reasearch I learned that **Web Engine** class has a method called **Execute Script**. This method allowed me to send values to JavaScript functions, which allowed me to send information to the JavaScript code. With this I was able to choose the location
of the Google map and also place location markers. Furthermore, I created new classes that would contain utility methods that memebers of my group would be able to call and use.
This would allow my team to work with the various features of the Google map without the fear of breaking the code or trying to understand the logic behind it unnecessarily. 


# Results

> This is the selection screen. The user would pick from a select group of locations. Each location has a google map associated with it. When the user picks their location
that google map is loaded in the next scene.

![SelectionMap](https://user-images.githubusercontent.com/33674827/103722606-fa1f2a80-4f95-11eb-9822-46d68879fe26.PNG)

> This is the default screen. This screen will show the google map based on the location that was chosen. (Ex. Seoul, South Korea)

![BaseMap](https://user-images.githubusercontent.com/33674827/103722689-1de27080-4f96-11eb-8381-cbb3f90d5196.PNG)

> This shows how the JavaFX gui is able to add google maps markers. This is possible through the use of the **Web Engine** class.

![JobMap](https://user-images.githubusercontent.com/33674827/103722653-102ceb00-4f96-11eb-99d5-3f4fbab4cd02.PNG)
