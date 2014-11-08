package hw2;

import java.util.ArrayList;

import library.StdDraw;

public class App {

    public static void main(String[] args) {
        final String roadFilename = args[0];
        final String imageFilename = args[1];
        final String reportFilename = args[3];
        final int numCellTower = Integer.parseInt(args[4]);
        final double sigma = Double.parseDouble(args[5]);

        final boolean isOSM = true;

        RoadNetwork roadNetwork = 
                new RoadNetwork(new java.io.File(roadFilename), isOSM);
        roadNetwork.draw();

        /*
         * Get a list of all of the cellular network configurations
         */

        ArrayList<CellNetwork> cellNetworkConfigurations =
                roadNetwork.getAllCellConfigurations(numCellTower, sigma);
        CellNetwork bestCellConfiguration = null;
        
        double bestScore = 0.0;
        for (CellNetwork cn : cellNetworkConfigurations) {
            // do test on cn to see if cn's score is better than bestScore
            // if it is update bestCellConfiguration = cn
            bestCellConfiguration = cn;
        }

        bestCellConfiguration.draw();

        /*
         * Everything is done
         * 
         */

        StdDraw.save(imageFilename);
        Report report = 
                new Report(new java.io.File(reportFilename));
        report.write();
    }
}
