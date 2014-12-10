package quiz3;

import java.io.File;

public class SocialNetwork extends Graph implements CONSTANTS {
    
    SocialNetwork() {
        super();
    }

    SocialNetwork(File file) {
        super();
        // implement file reader so that your social network is read in from 
        // a file.  The format of the file is
        // 
        // P Name1
        // P Name2
        // P Name3
        // ...
        // R # Name1 Name2
        // R # Name2 Name3
        // ...
        // 
        // where # is the integer relationship type (see CONSTANTS.java)
        //    can be 0, 1, 2 or 3
        // 
        // FOR EXAMPLE:
        // P John
        // P Mary
        // P Bob
        // R 0 John Mary
        // R 1 Mary Bob
        // R 3 John Bob
    }
    
    int getRelationshipType(String name1, String name2) {
        int type = -1;
        
        // implement code to check to see if there is a relationship between
        // name1 and name2 then return the relationship type, otherwise return
        // -1 to indicate no relationship
        
        return type;
    }

    boolean hasConnection(String name1, String name2) {
        boolean status = false;
        
        // implement the code to see if there is a path between person name1
        // and person name2.  In other words is there a direct or indirect
        // relationship between name1 and name2
        
        return status;
    }
    
    public void print() {
        System.out.println("-- vertices --");
        for (Vertex vertex : vertices) {
            System.out.println(vertex.Id() + ") " + vertex);
        }
        System.out.println("-- edges --");
        for (Edge edge : edges) {
            System.out.println(edge.Id() + ") " + edge);
        }
    }
    
    public static void main(String args[]) {
        SocialNetwork sn1 = new SocialNetwork();
        Person john = new Person("john");
        Person mary = new Person("mary");
        Person mike = new Person("mike");
        Person bob = new Person("bob");
        sn1.addVertex(john);
        sn1.addVertex(mary);
        sn1.addVertex(mike);
        sn1.addVertex(bob);
        
        sn1.addEdge(new Relationship(john, mary, FRIEND) );
        sn1.addEdge(new Relationship(john, mike, FAMILY));
        sn1.addEdge(new Relationship(mike, bob, CASUAL));

        sn1.print();
        System.out.println("Relationship between john and mike: " + sn1.getRelationshipType("john", "mike"));
        System.out.println("Relationship between mike and mary: " + sn1.getRelationshipType("mike", "mary"));
        System.out.println("Is there a relationship b/w john and bob? " + sn1.hasConnection("john", "bob"));
        System.out.println("Is there a relationship b/w mary and bob? " + sn1.hasConnection("mary", "bob"));
        
        SocialNetwork sn2 = new SocialNetwork(new File("network.txt"));
        sn2.print();
    }
}
