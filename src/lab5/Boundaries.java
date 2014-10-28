package lab5;

public class Boundaries {
    static double xmin = Double.MAX_VALUE;
    static double ymin = Double.MAX_VALUE;
    static double xmax = -Double.MAX_VALUE;
    static double ymax = -Double.MAX_VALUE;

    static void update(Point point) {
        xmin = point.x < xmin ? point.x : xmin;
        ymin = point.y < ymin ? point.y : ymin;  // see below
        xmax = Math.max(xmax, point.x);
        ymax = Math.max(ymax, point.y);
    }
}
