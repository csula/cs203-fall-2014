package quiz3;

public class Relationship extends Edge implements CONSTANTS {
    private final int type;
    
    Relationship() throws Exception {
        super();
        this.type = -1;
    }
    
    Relationship(Person p1, Person p2) {
        super(p1,p2);
        type = CASUAL;
    }
    
    Relationship(Person p1, Person p2, int type) {
        super(p1,p2);
        this.type = type;
    }
    
    int Type() {
        return type;
    }
    
    public String toString() {
        return v1.toString() + " <= " + type + " => " + v2.toString(); 
    }
}
