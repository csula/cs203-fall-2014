
public class MyCircle {

	public static void main(String[] args) {
    	StdDraw.setCanvasSize(600, 600);

    	// StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenColor(20, 20, 20);
        StdDraw.setPenRadius(.002);
        for (int i = 0; i < 20; i++) {
        	double x = Math.random();
        	double y = Math.random();
        	System.out.println(Math.pow(-1,i));
        	StdDraw.circle(x, y, 0.2 * Math.random());
        }
        
        // StdDraw.setPenColor(StdDraw.BLACK);
        // StdDraw.text(0.2, 0.5, "black text");
	}
}
