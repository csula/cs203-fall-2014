package hw1;

public class Segment implements RoadConstants {
    Point p1;
    Point p2;
    static int id = 0;
    java.util.ArrayList<Point> discretize(int K) {
        java.util.ArrayList<Point> points = 
                new java.util.ArrayList<Point>();

        double m = (p1.y - p2.y)/(p1.x - p2.x);		
        double dx = Math.abs(p1.x - p2.x)/K;
        for (int i = 0 ; i < K; i++) {
            double x = i * dx;
            double y = 0; /* obviously not correct! */
            /* calculate y using the line equation */
            points.add( new Point(id++, x,y) );
        }

        return points;
    }

    /* this is one possible way -- but there are plenty of others */
    public boolean checkCoverage() {
        boolean status = true;

        for (Point p : discretize(GRANULARITY) ) {
            // do something with p to test for coverage
        }

        return status;
    }
}
