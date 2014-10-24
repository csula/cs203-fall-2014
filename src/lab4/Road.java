package lab4;

public class Road {
    java.util.ArrayList<Segment> segments;
    String name;

    public void addSegment(Segment segment) {
        segments.add( segment );
    }

    public void Travel() {
        for (Segment s : segments) {

        }
    }

    boolean checkCoverage() {
        boolean status = true;
        for (Segment s : segments) {
            if (s.checkCoverage() == false) 
                return false;
        }
        return status;
    }
}
