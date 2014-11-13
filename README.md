cs203-fall-2014
===============

Programming with Data Structure Fall 2014

# Homework 2 (updates)

For homework 2 you should do the following:

1. Use the provided `src/hw2` folder as your starting point.  You are free to use your own implementation but it might be challenging.

2. Download 3 OSM files, each with different zoom level so that you'd have 4 different number of node sizes.  I recommend that you have 100, 500, and 1000 nodes (or points).

4. The placement of cell towers should be as followed
   (a) Find the road with the *most* number of points
   (b) Place cell towers only along this road, i.e. the number of cell tower combinations is restricted to just that road

Note that you will need to adopt the method `getAllCellConfigurations(...)` from `RoadNetwork` to `Road` because now instead of relying on the road network to get you all the possible combinations, you're relying on the road.  In particular you're going to select the road with the most points.

5. Run experiment on the following combinations
   (a) collect timing test for npoints = { 100, 500, 1000 } (or approximately there of depending on step 2 from above
   (b) for each npoint, vary your sigma = { 0.2, 0.3, 0.4, 0.5 }
   (c) you should have a report file for each of the above (total 9 report files)

6. Each report file should print out only the best configuration:

```
Road Name: 
P 1 x y
p 2 x y
p 3 x y
C 1 x y sigma
C 2 x y sigma
time: 10 ms
```

7. Using the data collected from your report file and produce a graph that has `x` axis as the number of points, and the `y` axis as the time.  There will be three curves (lines) with N (the number of cell towers) = { 2, 3, 4}.

8. Discuss your finding with regards to the time that you've collected.  For example, what kind of observations can be derived from the algorithm's performance?

*BONUS*  The team that modifies the `RoadNetwork` in such a way that the roads are stored as a `PriorityQueue` where the ordering of the priority is organized by the number of points will get bonus credit.  So that when you can simply ask a `RoadNetwork` object for the road with the largest number points without having to do a search through each road.

# Lab 5

We will now redo homework 1 using the generic data structure.

# Lab 4

`SampleHash.java` shows how to use the Java HashMap generic class.  You should be familiar with how to use a hash map as this is probably the single most important data structure in your computer science career.

We also updated homework 1 with a number of enhancements.  Use them as you see fit.  Most likely your homework 1 assignment will require lots of modifications to the code.

# Lab 3

The class `LinkedList` has an aggregious error.  Focus on identifying the error that can be found near lines 13-15.  

Implement a `print(...)` method that traverse the linked list and print out each of the node's `val` data member.

Update `RecursiveTraversal` by filling in the code where labelled `fill in something here`.  The idea here is to recursively traverse the `ArrayList<Square>` using an iterator.  Note that the recursion cannot alter `mylist`. 

# Lab 2

Goal: rewrite the first lab assignment so that we'd decouple the data and functionalities.  Your task is to modify: 

* `createBunchOfObjectsRecursively()` this function is considered a factory class that generates a container `BunchOfObjects` class
* `drawBunchOfObjects()` this function 'visits' each of the objects contained in the `BunOfObject` class and call the object's native draw method (you'll need to implement this method)

`App.java` is the main application:

1. Line 5: the factory method `createBunchOfObjectsRecursively`.  You will need to modify this method and treat it as a helper function 
2. Line 10: Recursion meat and potato, modify so that it recursively creates nested square objects
2. Line 16: this method visit all members of the `basket` and calls each member's `draw()` method
3. Line 21: a `BunchOfObjects` generic container object that parameterizes `square` is created 
4. Line 23: optional print method

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

