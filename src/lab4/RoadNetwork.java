package lab4;

import java.io.File;

public class RoadNetwork {

    java.util.HashMap<String,Road> roads;
    java.util.ArrayList<Intersection> intersections;

    public RoadNetwork(File file) {
        Road road = new Road();
        roads.put("name", road);
        // read in points
        // add two points to segment
        // add segment to road
    }
}
