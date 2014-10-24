package lab4;

import library.StdDraw;

public class Point extends GeometricObject {
    int id;
    double x, y;
    public Point(int id, double x, double y) {
        this.id = id; this.x = x; this.y = y;
    }

    public void drawLine(Point other) {
        // maybe easier to draw a line between other and me...
    }

    public Point(String line) {
        String[] cols = line.split("\\s+");
        this.id = Integer.parseInt(cols[0]);
        this.x = Double.parseDouble(cols[1]);
        this.y = Double.parseDouble(cols[1]);
    }

    public void draw() {
        StdDraw.filledRectangle(x, y, 0.01, 0.01);
    }
    public double getArea() {
        return 0;
    }
}

