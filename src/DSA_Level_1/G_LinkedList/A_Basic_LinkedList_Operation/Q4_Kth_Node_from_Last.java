package DSA_Level_1.G_LinkedList.A_Basic_LinkedList_Operation;

public class Q4_Kth_Node_from_Last {

    // Node class definition
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public Q4_Kth_Node_from_Last() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Your kthFromLast method with improvements
    public int kthFromLast(int k) {
        if (head == null) {
            throw new IllegalStateException("LinkedList is empty");
        }

        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        Node slow = head;
        Node fast = head;

        // Move fast pointer k nodes ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    // Alternative approach using size (if size is maintained)
    public int kthFromLastUsingSize(int k) {
        if (head == null) {
            throw new IllegalStateException("LinkedList is empty");
        }

        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        Node current = head;
        int position = size - k;

        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Helper method to add nodes (for testing)
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Helper method to display the list (for testing)
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        Q4_Kth_Node_from_Last list = new Q4_Kth_Node_from_Last();

        // Add some nodes
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Linked List:");
        list.display();

        // Test kth from last
        int k = 2;
        System.out.println(k + "th node from last: " + list.kthFromLast(k));

        k = 1;
        System.out.println(k + "th node from last: " + list.kthFromLast(k));

        k = 5;
        System.out.println(k + "th node from last: " + list.kthFromLast(k));
    }
}