package lab6;

import library.StdDraw;

public class Point extends GeometricObject {
    int id;
    double x, y;

    public Point() { }

    public Point(int id, double x, double y) {
        this.id = id; this.x = x; this.y = y;
    }

    public void drawLine(Point other) {
        // maybe easier to draw a line between other and me...
    }

    double Xr() { return x;	}
    double Yr() { return y;	}

    double Xs() { 
        return (Xr() - Boundaries.xmin)/(Boundaries.xmax - Boundaries.xmin);
    }

    double Ys() { 
        return (Yr() - Boundaries.ymin)/(Boundaries.ymax - Boundaries.ymin);
    }

    public Point(String line) {
        String[] cols = line.split("\\s+"); // regex for white spaces
        this.id = Integer.parseInt(cols[0]);
        this.x = Double.parseDouble(cols[1]);
        this.y = Double.parseDouble(cols[2]);
    }

    public Point(String line, boolean b) {
        // write this construct such it takes a string that begins
        // with "<node ... " and extract its x, y values;
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
        System.out.printf("p[%d] = (%f,%f) => (%f,%f)\n", id, 
                Xr(), Yr(), Xs(), Ys());
    }
}

