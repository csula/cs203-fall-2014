package lab4;

public class CellTower extends Point {
    double radius;

    boolean isCovered(Point p) {
        double distance = 
                Math.sqrt(Math.pow(x-p.x, 2) - Math.pow(y-p.y, 2));  
        // scale your distance then compare to radius
        // distance *= Boundaries.scaleFactor;
        // technically you should scale at the point level not here!

        return distance > radius ? false : true;
    }

    public CellTower(int id, double x, double y) {
        super(id, x, y);
    }

    public void draw() {
        super.draw();
        // draw the coverage circle...
    }


}