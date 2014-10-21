package quiz1;

class Node<T> {
    T value;
    Node<T> next;

    public Node () {
        value = null;
        next = null;
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public String toString() {
        return value.toString();
    }
}

public class LinkedList {
    Node<String> head = null;

    public void addNode(Node<String> node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void recursivePrint(Node<String> ptr) {

        // update this method so that it recursively print each of the 
        // elements in the linked list

    }

    public int findPosition(String item) {
        int position = 0;

        // update this method so it returns the correct position in the
        // linked list for the item 

        return position;
    }

    public String findLongestName() {
        String longestName = "";
        
        // update this method so that it returns the longest name

        return longestName;
    }
    public void run() {
        addNode( new Node<String>("robert") );
        addNode( new Node<String>("john") );
        addNode( new Node<String>("michael") );
        addNode( new Node<String>("mary") );
        addNode( new Node<String>("joe") );

        System.out.println("1. Recursively print linked list:");
        recursivePrint(head);

        System.out.println("2. The position of mary is: " +
                findPosition("mary"));

        System.out.println("3. The longest name is: " +
                findLongestName());
    }

    public static void main(String[] args) {
        new LinkedList().run();
    }
}