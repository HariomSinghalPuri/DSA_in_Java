package DSA_Level_1.G_LinkedList.A_Basic_LinkedList_Operation;

public class Q3_Middle_of_Linked_List {

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

    public Q3_Middle_of_Linked_List() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add element at the end
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

    // Add element at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Your kthFromLast method
    public int kthFromLast(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("k must be between 1 and size of list");
        }

        Node slow = head;
        Node fast = head;

        // Move fast pointer k steps ahead
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches tail
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    // Alternative implementation (more common approach)
    public int kthFromLastAlternative(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("k must be between 1 and size of list");
        }

        Node slow = head;
        Node fast = head;

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get size of list
    public int size() {
        return size;
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Q3_Middle_of_Linked_List list = new Q3_Middle_of_Linked_List();

        // Add elements to the list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);

        System.out.println("Linked List:");
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println();

        // Test kthFromLast method
        try {
            System.out.println("1st element from last: " + list.kthFromLast(1)); // Should be 70
            System.out.println("2nd element from last: " + list.kthFromLast(2)); // Should be 60
            System.out.println("3rd element from last: " + list.kthFromLast(3)); // Should be 50
            System.out.println("4th element from last: " + list.kthFromLast(4)); // Should be 40
            System.out.println("5th element from last: " + list.kthFromLast(5)); // Should be 30
            System.out.println("6th element from last: " + list.kthFromLast(6)); // Should be 20
            System.out.println("7th element from last: " + list.kthFromLast(7)); // Should be 10

            System.out.println();

            // Test alternative implementation
            System.out.println("Using alternative implementation:");
            System.out.println("1st element from last: " + list.kthFromLastAlternative(1));
            System.out.println("3rd element from last: " + list.kthFromLastAlternative(3));
            System.out.println("7th element from last: " + list.kthFromLastAlternative(7));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test edge cases
        System.out.println();
        System.out.println("Testing edge cases:");

        try {
            System.out.println("k = 0: " + list.kthFromLast(0)); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("k = 0: " + e.getMessage());
        }

        try {
            System.out.println("k = 8: " + list.kthFromLast(8)); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("k = 8: " + e.getMessage());
        }
    }
}
