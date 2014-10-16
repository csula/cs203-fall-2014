package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import library.StdDraw;

public class App {
    // do not use this anymore!
    public static void readRoadMap(String filename, 
            BunchOfObjects<Point> points) { 
        try {
            String line;
            BufferedReader br = 
                    new BufferedReader(new FileReader(new File(filename)));
            while((line = br.readLine()) != null) {
                points.add( new Point(line) );
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        String roadFilename = args[0];
        String cellNetworkFile = args[1];
        String imageFilename = args[2];

        RoadNetwork roadnetwork = new RoadNetwork(
           new java.io.File(roadFilename)	
        );

        CellNetwork cellnetwork = new CellNetwork(
          /* new java.io.File(cellNetworkFile) */
        );

        // draw roads
        // roadnetwork.Draw();
        
        // draw cell towers
        // cellnetwork.Draw();
        
        // test for coverage
        // if (roadnetwork.hasCoverage( cellnetwork ) ) {  } else { }

        StdDraw.save(imageFilename);
    }
}
