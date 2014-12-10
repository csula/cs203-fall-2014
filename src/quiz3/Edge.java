package quiz3;

public abstract class Edge {
    private static int idCounter = 0;
    int id;
    Vertex v1;
    Vertex v2;

    Edge() throws Exception {
        throw new Exception("default edge constructor not permitted");
    }
    
    Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
        id = idCounter++;
    }

    int Id() {
        return id;
    }

    Vertex One() {
        return v1;
    }

    Vertex Two() {
        return v2;
    }

    Vertex Other(Vertex v) {
        if (v == v1) {
            return v2;
        } else if (v == v2) {
            return v1;
        } else {
            return null;
        }
    }
}
