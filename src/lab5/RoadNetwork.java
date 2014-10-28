package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoadNetwork {

    java.util.ArrayList<Road> roads = 
            new java.util.ArrayList<Road>() ;
    private Scanner scanner;

    public RoadNetwork(File file) {
        Road road = new Road();

        // read all points into temporary collection of points
        java.util.ArrayList<Point> tempPoints = 
                new java.util.ArrayList<Point>();
        try {
            scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                Point p = new Point( line );
                Boundaries.update( p );
                tempPoints.add( p );
                // tempPoints.add( new Point( scanner.nextLine() ) );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        road.build( tempPoints );

        roads.add(road);
    }

    public void draw() {
        for (Road road : roads ) {
            road.draw();
        }
    }

    public void dump() {
        for (Road road : roads ) {
            road.dump();
        }
    }
}
