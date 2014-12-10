package quiz3;

import java.util.HashSet;

public abstract class Graph {
    HashSet<Edge> edges;
    HashSet<Vertex> vertices;
    
    Graph() {
        edges = new HashSet<Edge>();
        vertices = new HashSet<Vertex>(); 
    }
    
    int vCount() {
        return vertices.size();
    }
    
    int eCount() {
        return edges.size();
    }
    
    void addVertex(Vertex v) {
        vertices.add(v);
    }

    void addEdge(Edge e) {
        edges.add(e);
    }
}
