package lab3;

public class LinkedList {
    
    public static Node<String> newNode() {
        return new Node<String>();
    }
    
    public static Node<String> newNode(String t) {
        return new Node<String>(t);
    }
    
    public static void addNode(Node<String> head, Node<String> newNode) {
        head.next = newNode;
    }
    
    public static void main(String[] args) {
        Node<String> head = newNode();
        head.val = "head";
        addNode(head, newNode("bob"));
    }
}
