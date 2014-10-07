package lab2;

public class App {

    static BunchOfObjects<Square> createBunchOfObjectsRecursively(int numLevel) {
        /* do this at home: recursively */
        return null;
    }

    static void drawBunchOfObjects(BunchOfObjects<Square> basket) {
        /* do this at home */
    }

    public static void main(String args[]) {
        BunchOfObjects<Square> basket = createBunchOfObjectsRecursively(5);

        basket.print();
        drawBunchOfObjects(basket);
    }
}
