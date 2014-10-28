package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellNetwork {
    java.util.ArrayList<CellTower> towers;
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
}
