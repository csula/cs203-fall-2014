cs203-fall-2014
===============

Programming with Data Structure Fall 2014

# Lab 3

The class `LinkedList` has an aggregious error.  Focus on identifying the error that can be found near lines 13-15.  

Implement a `print(...)` method that traverse the linked list and print out each of the node's `val` data member.

Update `RecursiveTraversal` by filling in the code where labelled `fill in something here`.  The idea here is to recursively traverse the `ArrayList<Square>` using an iterator.  Note that the recursion cannot alter `mylist`. 

# Lab 2

Goal: rewrite the first lab assignment so that we'd decouple the data and functionalities.  Your task is to modify: 

* `createBunchOfObjectsRecursively()` this function is considered a factory class that generates a container `BunchOfObjects` class
* `drawBunchOfObjects()` this function 'visits' each of the objects contained in the `BunOfObject` class and call the object's native draw method (you'll need to implement this method)

`App.java` is the main application:

1. Line 5: the factory method `createBunchOfObjectsRecursively`.  You will need to modify this function so that it recursively creates nested square objects
2. Line 10: this method visit all members of the `basket` and calls each member's `draw()` method
3. Line 15: a `BunchOfObjects` generic container object that parameterizes `square` is created 
4. Line 17: optional print method

Note that You will need to modify `Square.java`, `BunchOfObjects.java`, and `GeometricObject.java`.

# Lab 1

Goal: Write a Java program that recursively place draw boxes on to a two dimensional plane.  The program should work as followed:

1. Given a square, divide the it into four smaller squares of equal size
2. Randomly select one of four squares
3. Paint that square of a shade of grey
4. Repeat step 1 from above

The recursion occurs in step #4.  How you choose to call the `rsquare(...)` method in line 7 dictates how the recursion is invoked.

The `RSquare.java` file requires that you consider the following:

1. Lines 16 - 19: modify so that the correct information can be passed on to the child box 
2. Line 20: the recurisve call -- this should match up with the parameters listed in line 7

