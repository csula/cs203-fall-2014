package hw3;

import java.util.ArrayList;

import library.StdDraw;

public class Point extends GeometricObject {
    long id;
    double x, y;

    ArrayList<Segment> edges = new ArrayList<Segment>();
    
    ArrayList<Point> getNeighbors() {
    	ArrayList<Point> neighbors = new ArrayList<Point>();
    	
    	for (Segment edge : edges) {
    		if (edge.p1 != this) {
    			neighbors.add(edge.p1);
    		}
    		if (edge.p2 != this) {
    			neighbors.add(edge.p2);
    		}
    	}
    	
    	return neighbors;
    }
    
    
    public Point() { }

    public Point(long id, double x, double y) {
        this.id = id; this.x = x; this.y = y;
    }

    public void drawLine(Point other) {
        // maybe easier to draw a line between other and me...
    }

    double Xr() { return x; }
    double Yr() { return y; }

    double Xs() { 
        return (Xr() - Boundaries.xmin)/(Boundaries.xmax - Boundaries.xmin);
    }

    double Ys() { 
        return (Yr() - Boundaries.ymin)/(Boundaries.ymax - Boundaries.ymin);
    }

    public Point(String line) {
    }

    public Point(String line, boolean isOSM) {
        if (isOSM) {
            this.id = Long.parseLong( OSM.extractStringFromVal(line, "id"));
            this.x =  Double.parseDouble( OSM.extractStringFromVal(line, "lon"));
            this.y =  Double.parseDouble( OSM.extractStringFromVal(line, "lat"));
        }
    }

    public String toString() {
        return "P " + id + " " + x + " " + y;
    }
    
    public void draw() {
        StdDraw.filledRectangle(Xs(), Ys(), 0.01, 0.01);
    }

    public void drawDot() {
        StdDraw.filledCircle(Xs(), Ys(), 0.005);
    }

    public double getArea() {
        return 0;
    }

    public void dump() {
        System.out.printf("p[%ld] = (%f,%f) => (%f,%f)\n", id, 
                Xr(), Yr(), Xs(), Ys());
    }
}

