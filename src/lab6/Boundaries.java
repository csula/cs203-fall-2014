package lab6;

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

    static void update(String line) {
        double xmin = 
                Double.parseDouble( OSM.extractStringFromVal(line, "minlat") );
        // you need to do the rest!
    }

    public static void dump() {
        System.out.printf("(%f,%f) (%f,%f)\n", xmin, ymin, xmax, ymax);
    }
}
