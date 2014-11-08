package hw2;

import library.StdDraw;

public class CellTower extends Point {
    double radius;

    boolean isCovered(Point p) {
        double distance = 
                Math.sqrt(Math.pow(Xs()-p.Xs(), 2) - Math.pow(Ys()-p.Ys(), 2));  

        return distance > radius ? false : true;
    }

    public CellTower(int id, double x, double y) {
        super(id, x, y);
    }

    public CellTower(String line) {
        String[] cols = line.split("\\s+"); // regex for white spaces
        this.id = Integer.parseInt(cols[0]);
        this.x = Double.parseDouble(cols[1]);
        this.y = Double.parseDouble(cols[2]);
        this.radius = Double.parseDouble(cols[3]);
    }

    public CellTower(Point p, double radius) {
        super(p.id, p.x, p.y);
        this.radius = radius;
    }

    public void draw() {
        super.draw();
        StdDraw.filledCircle(Xs(), Ys(), radius);
    }

    public boolean hasCoverage(RoadNetwork roadNetwork) {
        boolean assumption = true;
        for (Road road : roadNetwork.roads ) {
            for ( Segment segment : road.segments ) {
                for (Point point : segment.discretize(100) ) {
                    if (! isCovered( point ) ) {
                        return false;
                    }
                }
            }
        }

        return assumption;
    }


}