package quiz3;

public class Person extends Vertex {
    private String name;
    
    Person() {
        super();
        this.name = "undefined";
    }
    
    Person(String name) {
        super();
        this.name = name;
    }
    
    String Name() {
        return name;
    }
    
    public String toString() {
        return name; 
    }
    
}
