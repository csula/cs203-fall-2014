package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CellNetwork {
    private ArrayList<CellTower> towers;
    private Scanner scanner;

    public CellNetwork(File file) {
        try {
            scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                CellTower cellTower = new CellTower( line );
                add( cellTower );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addTower(CellTower tower) {
        towers.add(tower);
    }
    
    public CellNetwork() {

    }

    public void add(CellTower tower) {
        towers.add(tower);
    }

    public void draw() {
        for ( CellTower cellTower : towers ) { 
            cellTower.draw();
        }
    }

    public boolean hasCoverage(RoadNetwork roadNetwork) {
        boolean assumption = true;

        for (CellTower tower : towers) {
            if (! tower.hasCoverage( roadNetwork) ) {
                return false;
            }
        }

        return assumption;
    }

	public double getCoveragePercentage(Road road) {
		int total = 0;
		
		for (Point p : road.getAllPoints() ) {
			for (CellTower ct : towers) {
				if (ct.isCovered(p)){
					total++;
				}
			}
		}
		
		return total;
	}
}
