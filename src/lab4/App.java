package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import library.StdDraw;

public class App {

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

        // draw cell towers

        // test for coverage

        StdDraw.save(imageFilename);
    }
}
