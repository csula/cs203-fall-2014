package hw2solution;

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

        Road longestRoad = roadNetwork.getLongestRoad();

        /*
         * Get a list of all of the cellular network configurations
         */

        ArrayList<CellNetwork> cellNetworkConfigurations =
                longestRoad.getAllCellConfigurations(numCellTower, sigma);

        CellNetwork bestConfiguration = null;
        double bestScore = 0.0;

        CellNetwork fifth = cellNetworkConfigurations.get(4);

        for (CellNetwork cn : cellNetworkConfigurations) {
            double score = cn.getCoveragePercentage(longestRoad);
            if (score > bestScore) {
                bestConfiguration = cn;
                bestScore = score;
            }
        }

        bestConfiguration.draw();

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
