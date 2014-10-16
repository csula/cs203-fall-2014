package hw1;

public class Road {
    java.util.ArrayList<Segment> segments;

    public void Travel() {
        for (Segment s : segments) {
            /* maybe do something with s later */
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
