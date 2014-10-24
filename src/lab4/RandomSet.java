package lab4;

public class RandomSet {
    public static void main(String[] args) {
        java.util.Set set = new java.util.TreeSet<Integer>();

        while (set.size() < 100) {
            int number = (int)(Math.random() * 100 + 1);
            set.add( new Integer(number) );
            System.out.println(number);
        }

        System.out.println( set );
    }
}
