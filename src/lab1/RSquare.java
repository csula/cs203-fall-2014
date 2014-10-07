package lab1;

import library.StdDraw;

public class RSquare {

    public static void rsquare(int level, double w, double x, double y) {
        if (level == 0) {
            // maybe draw something before you return?!?!
            return;
        } else {
            int grey = 255 - level * 20;
            StdDraw.setPenColor(grey, grey, grey);
            StdDraw.filledSquare(x, y, w);
            /*
            int qx = (int) (Math.random() * 2);
            int qy = (int) (Math.random() * 2);
            double xp = qx * w / 2.0;
            double yp = qy * w / 2.0;
            rsquare(level - 1, xp, yp, w / 2.0);
            */
        }
    }

    public static void main(String[] args) {
        rsquare(5, 1.0, 0.0, 1.0);
    }
}
