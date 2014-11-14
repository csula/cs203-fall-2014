package hw2;

import java.util.ArrayList;
import java.util.Collection;

public class Road {
    java.util.ArrayList<Segment> segments = 
            new java.util.ArrayList<Segment>();
    java.util.ArrayList<Point> points = 
            new java.util.ArrayList<Point>();
    
    String name;
    long id;

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
}
