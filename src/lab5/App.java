package lab5;

import library.StdDraw;

public class App {

    public static void main(String[] args) {
        String roadFilename = args[0];
        String cellNetworkFilename = args[1];
        String imageFilename = args[2];
        String reportFilename = args[3];

        RoadNetwork roadNetwork = new RoadNetwork(
                new java.io.File(roadFilename)	
                );

        roadNetwork.dump();

        CellNetwork cellNetwork = new CellNetwork(
                new java.io.File(cellNetworkFilename)
                );

        // draw roads
        roadNetwork.draw();

        // draw cell towers
        cellNetwork.draw();

        // save image to file		
        StdDraw.save(imageFilename);

        // test for coverage
        String message = "";
        if (cellNetwork.hasCoverage( roadNetwork )) {
            message = "success";
        } else {
            message = "drop signal";
        }

        // save report to file
        Report report = new Report( 
                new java.io.File(reportFilename)
                );
        report.add(message);
        report.write();
    }
}
