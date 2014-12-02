package hw3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Road {
    java.util.ArrayList<Segment> segments = 
            new java.util.ArrayList<Segment>();
    java.util.ArrayList<Point> points = 
            new java.util.ArrayList<Point>();
    
    String name;
    long id;

    public void printEdges() {
    	for (Segment segment : segments) {
    		System.out.println(segment);
    	}
    }
    
    ArrayList<CellNetwork> getAllCellConfigurations(int N, double radius) {

        /*
         * This method will return an array of cellular networks
         * Each network consist of cell towers
         */
        ArrayList<CellNetwork> cellNetworks = new ArrayList<CellNetwork>();

        /*
         * obtain points from allPoints hash table
         */
        // ArrayList<Point> points = new ArrayList<Point>(allPoints.values());
        
        /*
         * Use the combinations class to find unique combination of points
         */
        Set<Set<Point>> pointSets = new Combinations<Point>().getCombinationsFor(points, N);
        
        
        for (Set<Point> s : pointSets) {
            CellNetwork cn = new CellNetwork();
            for (Point p : s) {
                CellTower tower = new CellTower(p, radius);
                cn.add(tower);
            }
            cellNetworks.add(cn);
        }
        
        return cellNetworks;
    }
    
    public Road(String line, boolean isOSM) {
        if (isOSM) {
            String idStr = OSM.extractStringFromVal(line, "id");
            id = Long.parseLong(idStr);
        }
    }

    public Road() {

    }
    
    public String toString() {
        String buffer = "R " + id;
        for (Point p : points) {
            buffer += " " + p.id;
        }
        return buffer;
    }

    public void addSegment(Segment segment) {
        segments.add( segment );
    }

    boolean checkCoverage() {
        boolean status = true;
        for (Segment s : segments) {
            if (s.checkCoverage() == false) 
                return false;
        }
        return status;
    }

    public void build(ArrayList<Point> tempPoints) {
        // create segments
        Point p0 = tempPoints.get(0);
        for (int i = 1; i < tempPoints.size(); i++) {
            Point p1 = tempPoints.get(i);
            Segment segment = new Segment(p0, p1);
            addSegment( segment );
            p0 = p1;
        }
    }

    public void dump() {
        for ( Segment segment : segments ) {
            segment.dump();
        }
    }

    public void draw() {
        for ( Segment segment : segments ) {
            segment.draw();
        }
    }

    public void AppendDiscretizePoints(ArrayList<Point> discretizePoints) {
        for (Segment s : segments) {
            discretizePoints.addAll( s.discretize(100) );
        }

    }

    public Collection<? extends Point> getAllPoints() {
        return null;
    }

	public void connect() {
        // create segments
        Point p0 = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i);
            Segment segment = new Segment(p0, p1);
            
            p0.edges.add(segment);
            p1.edges.add(segment);
            
            addSegment( segment );
            p0 = p1;
        }
	}
}
