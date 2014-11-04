package lab6;

import library.StdDraw;

public class App {

    public static void main(String[] args) {
        String roadFilename = args[0];
        String imageFilename = args[1];
        String reportFilename = args[3];
        int numCellTower = Integer.parseInt( args[4] );
        double sigma = Double.parseDouble( args[5] ) ;

        boolean isOSM = true;

        RoadNetwork roadNetwork = new RoadNetwork(
                new java.io.File(roadFilename), isOSM	
                );

        Boundaries.dump();
        roadNetwork.dump();
        System.exit(0);

        /*
		CellNetwork cellNetwork = new CellNetwork(
			new java.io.File(cellNetworkFilename)
		);
         */

        // draw roads
        roadNetwork.draw();

        // draw cell towers
        /*
		cellNetwork.draw();
         */

        // save image to file		
        StdDraw.save(imageFilename);

        // save report to file
        Report report = new Report( 
                new java.io.File(reportFilename)
                );
        report.write();
    }
}
