package lab3;

public class Node<T> {
    T val;
    Node<T> next;
    
    public Node () {
        next = null;
    }
    
    public Node(T t) {
        this.val = t;
    }
}
