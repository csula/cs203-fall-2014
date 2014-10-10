package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import library.StdDraw;

/*
 * Recommendation: move this class into its own file
 */
class Point extends GeometricObject {
    int id;
    double x, y;

    public Point(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
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

/*
 * Recommendation: move this class into its own file
 */
class CellTower extends Point {
    double radius;

    public CellTower(int id, double x, double y) {
        super(id, x, y);
    }

    public void draw() {
        super.draw();
        // draw the coverage circle...
    }
}

public class App {
    static void readRoadMap(String filename, BunchOfObjects<Point> points) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(new File(
                    filename)));
            while ((line = br.readLine()) != null) {
                points.add(new Point(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readCellNetwork(String filename, 
            BunchOfObjects<CellTower> towers) {
        /* implement this method (hint: see above)*/
    }
    
    public static void main(String[] args) {
        String roadFilename = args[0];
        String cellNetworkFilename = args[1];
        String imageFilename = args[2];
        // String reportFilename = args[3];

        BunchOfObjects<Point> points = new BunchOfObjects<Point>();
        BunchOfObjects<CellTower> towers = new BunchOfObjects<CellTower>();

        // read road network 
        readRoadMap(roadFilename, points);
        for (Point point : points.getAll()) {
            point.draw();
        }

        // read cell tower network
        readCellNetwork(cellNetworkFilename, towers);
        for (CellTower cell : towers.getAll() ){
            cell.draw();
        }
        
        // draw circles

        // test for coverage

        // save files image and report
        StdDraw.save(imageFilename);
    }
}
