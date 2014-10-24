package lab4;

public class SampleHash {
    public static void main(String[] args) {
        java.util.HashMap<String,Integer> hash = 
                new java.util.HashMap<String, Integer>();
        hash.put("mary", 15);
        hash.put("john", 40);
        hash.put("sudhir", 20);
        System.out.println( hash );

        for (String key : hash.keySet() ) {
            System.out.println( key + " => " + hash.get(key) );
        }
    }
}
