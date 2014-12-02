package hw2solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class OSM {
    private static Scanner scanner;

    static String extractStringFromVal(String haystack, String needle) {
        String[] array = haystack.split("\\s+");
        for (String a : array) {
            String[] b = a.split("=");
            if (b.length != 2) {
                continue;
            }
            String key = b[0];
            String val = b[1];
            if(needle.compareToIgnoreCase(key) == 0) {
                return val.replaceAll("\"", "").replaceAll("\\/", "").replaceAll(">", "");
            }
        }

        return null;
    }
    
    public static void extractBoundaries(File file) {
        try {
            scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                if (line.contains("<bounds")) {
                    Boundaries.update(line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1); 
        }
    }

    public static HashMap<Long,Point> extractNodes(File file) {
        HashMap<Long,Point> nodes = new HashMap<Long,Point>();
        
        try {
            scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                if (line.contains("<node")) {
                    Point p = new Point(line, true);
                    nodes.put( (long)p.id, p);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        
        return nodes;
    }

    public static HashMap<Long,Road> 
    extractWays(File file, HashMap<Long, Point> nodes) {
        HashMap<Long,Road> ways = new HashMap<Long,Road>();
        
        try {
            scanner = new Scanner( file );
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                if (line.contains("<way")) {
                    Road road = new Road(line, true);
                    while (!line.contains("</way")) {
                        line = scanner.nextLine();
                        if (line.contains("<nd")) {
                            long nodeIdRef = Long.parseLong(OSM.extractStringFromVal(line, "ref"));
                            Point p = nodes.get(nodeIdRef);
                            assert (p != null);
                            road.points.add( p );
                        }
                    }
                    ways.put( road.id, road );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return ways;
    }
    
    public static void OSM2Text(File osmFile, File textFile) {
        extractBoundaries(osmFile);
        HashMap<Long,Point> nodes = extractNodes(osmFile);
        HashMap<Long,Road> ways = extractWays(osmFile, nodes);
        
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(textFile));
            writer.write("boundaries: " + Boundaries.xmin + " " + Boundaries.ymin + " " + Boundaries.xmax + " " +  Boundaries.ymax + "\n");
            for (Point p : nodes.values()) {
                writer.write(p.toString() + "\n");
            }
            for (Road r : ways.values()) {
                writer.write(r.toString() + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
        
    }
    
    public static void main(String[] args) {
        try {
            File osmFile = new File(args[0]);
            File textFile = new File(args[1]);
            OSM2Text(osmFile, textFile);
            
        } catch (Exception ex) {
            System.out.println("usage: prog <osm file> <text file>");
        }
    }

}
