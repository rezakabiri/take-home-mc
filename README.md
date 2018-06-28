# take-home-mc

The solution is provided in both Java and Python. Below is a brief decription of the challenge and assumptions that were made in building the solution. 

Both projects were written in TDD approach. That is, first the requirements of the project were gathered. Next test cases based on previous steps resutls were written. Then the necessary code was developed such that the test would pass. Finally, code was refactored.

### Code Challenge

* In the programming language of your choice create a class with a method to return the length and longest words in a sentence. For example, “The cow jumped over the moon.” should return 6 and “jumped”. 
* Create unit tests to test that method, reworking your code if needed. 
* Explain any assumptions in comments. 
* Add a README explaining how to execute your tests. 
* Share via GitHub

### Assumptions 

* Only alphanumeric characters are allowed and anything else should be neglected/omitted. If all characters in string are un-allowed then the string should be considered an empty string.
* Also, it is assumed that for empty strings the method should raise an Exception.
* The method should return the first longest word in the input String.
* The method is not case-sensitive and will always return the lowercase.

### Java Solution

The Java solution is a Java Maven project and the idea used for this project (files included) is IntelliJ. Therefore, you need to have Java SDK, Maven (and if you want to run from idea) IntelliJ installed. 

The tests are written using JUnit and they reside under the test folder and are written in the givenSomethingThenSomething format. In order to run the tests form command line navigate to the project main folder and run below command:

**mvn test**

In order to run the test from idea you need to open the project in IntelliJ and simply run the saved  configuration **UnitTest-FindLongestWordAndLengthMethod**.

### Python Solution

This is a python 3.6 project developed in PyCharm idea. At this point, the test are only runnable from the diea. 

## Authors

* **Reza Kabiri**

