package hw4;

import java.util.ArrayList;

interface CONSTANTS {
	public static final int THREAD_COUNT = 4;
}

class Task implements Runnable, CONSTANTS{
	private int id;
	private ArrayList<CellNetwork> cellNetworks;
	
	private double score;
	private CellNetwork bestConfig = null;
	
	public Task() {
		System.out.println("default constructor not allowed");
		System.exit(-1);
	}

	public Task(int id, ArrayList<CellNetwork> cellNetworks) {
		this.id = id;
		this.cellNetworks = cellNetworks;
	}

	public void run() {
		// figure out start, end index of cellNetworks based on id
		// cellNetworks.get(idx)
	}
}

public class MTRoad extends Road implements CONSTANTS {
	
	public void calculateCoverage(ArrayList<CellNetwork> cellNetworks, 
				Double score, CellNetwork bestConfig) {
		Task[] tasks = new Task[THREAD_COUNT];
		Thread[] threads = new Thread[THREAD_COUNT];
		
		for (int i = 0; i < THREAD_COUNT; i++) {
			tasks[i] = new Task(i, cellNetworks);
			threads[i] = new Thread(tasks[i]);
		}
		
		// run the threads
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i].start();
		}
		
		// wait for threads to finish
		for (int i = 0; i < THREAD_COUNT; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// of the THREAD_COUNT threads pick the best one
		for (int i = 0; i < THREAD_COUNT; i++) {
			// obtain results from tasks[i].someMethod() blah
		}
		
		// set score and set bestConfig
	}
	
}


