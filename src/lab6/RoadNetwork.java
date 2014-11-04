package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoadNetwork {

    java.util.ArrayList<Road> roads = 
            new java.util.ArrayList<Road>() ;

    private void readTextFormat(File file) {
        Road road = new Road();
        java.util.ArrayList<Point> tempPoints = 
                new java.util.ArrayList<Point>();
        try {
            Scanner scanner = new Scanner( file );
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

    public RoadNetwork(File file) {
        readTextFormat(file);
    }


    private void readOSMFormat(File file) {
        // extract boundaries

        try {
            Scanner scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                if (line.startsWith(" <bounds")) {
                    Boundaries.update(line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;  // not good! plz handle exceptions accordingly
        }

        // extract points
        try {
            Scanner scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine().replace("^\\s+", "");
                if (line.startsWith("<node")) {
                    Point p = new Point(line, true);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;  // not good! plz handle exceptions accordingly
        }

        // extract ways
    }

    public RoadNetwork(File file, boolean isOSM) {
        if (isOSM) {
            readOSMFormat(file); // this should really be its class
        } else {
            readTextFormat(file);
        }
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
