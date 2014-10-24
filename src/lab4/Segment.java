package lab4;

public class Segment {
    Point p1;
    Point p2;
    static int id = 0;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

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

    public boolean checkCoverage() {
        boolean status = true;

        for (Point p : discretize(100) ) {
            // somehow you need to work in the celltowers...
        }

        return status;
    }
}
