cs203-fall-2014
===============

Programming with Data Structure Fall 2014

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

# Lab 2

Goal: rewrite the first lab assignment so that we'd decouple the data and functionalities.  Your task is to modify: 

* `createBunchOfObjectsRecursively()` this function is considered a factory class that generates a container `BunchOfObjects` class
* `drawBunchOfObjects()` this function 'visits' each of the objects contained in the `BunOfObject` class and call the object's native draw method (you'll need to implement this method)

`App.java` is the main application
* Line 15: a `BunchOfObjects` generic container object that parameterizes `square` is created by calling the factory method `createBunchOfObjectsRecursively`  

Note that You will need to modify `Square.java`, `BunchOfObjects.java`, and `GeometricObject.java`.
