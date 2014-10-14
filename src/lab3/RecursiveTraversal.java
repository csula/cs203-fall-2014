package lab3;

import java.util.Iterator;

class Square {
    double x, y, w;
    Square(double x,double y, double w) { 
        this.x = x; this.y = y; this.w = w;
    }
    public String toString() { 
        return String.format("x=%f,y=%f,w=%f", x, y, w);
    }
}

public class RecursiveTraversal {
    public static void visit( /* fill in something here */ ) {
        /*
        if (  ) {
            return;
        } else {
            // fill in something here
        }
        */
    }

     public static void main(String[] args) {
        java.util.ArrayList<Square> mylist = 
                new java.util.ArrayList<Square>();
        mylist.add( new Square (1.0, 1.0, 2.0) );
        mylist.add( new Square (2.0, 2.0, 4.0) );
        visit( /* fill in something here */ );
    }
}

