package hw4;

import library.StdDraw;

public class Segment {
    Point p1;
    Point p2;
    static int id = 0;
    double A;
    double B;
    double C;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        A = p2.Yr() - p1.Yr();
        B = p1.Xr() - p2.Xr();
        C = A * p1.Xr() + B * p1.Yr();
    }

    java.util.ArrayList<Point> discretize(int K) {
        java.util.ArrayList<Point> points = 
                new java.util.ArrayList<Point>();

        double xStepSize = ( p2.Xr() - p1.Xr() ) / K; 
        for (int i = 0 ; i < K; i++) {
            double x = p1.Xr() + i * xStepSize;
            double y = (C - A * x)/B;
            points.add( new Point(i, x, y) );
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

    public void dump() {
        System.out.println("segment: ");
        p1.dump();
        p2.dump();
    }

    public void draw() {
        p1.draw();
        p2.draw();
        StdDraw.line( p1.Xs(), p1.Ys(), p2.Xs(), p2.Ys() );
        for (Point p : discretize( 10 ) ) {
            p.drawDot();
        }
    }

}
