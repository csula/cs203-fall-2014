cs203-fall-2014
===============

Programming with Data Structure Fall 2014

# Lab 1

`RSquare.java`

This program requires that you modify lines 15 - 21 so that the correct coordinate of a child box is computed.  Note that the recursion call (line 20) is such that the new level is and coordinates are pre-computed ahead of the call itself.

# Lab 2

`App.java` is the main application.  Line 15: a `BunchOfObjects` generic container object that parameterizes `square` is created by calling the factory method `createBunchOfObjectsRecursively`  Your goal is to modify `createBunchOfObjectsRecursively` and `drawBunchOfObjects` so that they work as followed:

1. Create the square objects in memory then add each object to the `BunchOfObjects` container
2. Call the `drawBunchOfObjects` method where each object would invoke its own draw method

You will need to modify `Square.java`, `BunchOfObjects.java`, and `GeometricObject.java`.