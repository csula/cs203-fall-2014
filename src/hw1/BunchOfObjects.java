package hw1;

import java.util.ArrayList;

public class BunchOfObjects<T extends GeometricObject> {
    private ArrayList<T> myList = new ArrayList<T>();

    public void add(T o) { /* do this at home */
    	myList.add( o );
    }

    public void clear() { /* do this at home */
    }

    public ArrayList<T> getAll() {
        return myList;
    }

    public T get() {
        return null;
    }

    public void print() {

    }

    public ArrayList<T> getSome(int level) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T t : myList) {
            if (t.getLevel() == level) {
                newList.add(t);
            }
        }
        return newList;
    }

    public ArrayList<T> getSome(double x1, double y1, double x2, double y2) {
        /*
         * do this at home hint T must provide a way to get its center
         */
        return null;
    }

}
