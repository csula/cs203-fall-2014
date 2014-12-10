package quiz3;

public abstract class Vertex {
    private static int idCounter = 0;
    int id;
    
    Vertex() {
        this.id = idCounter++;
    }
    
    int Id() {
        return id;
    }
}
