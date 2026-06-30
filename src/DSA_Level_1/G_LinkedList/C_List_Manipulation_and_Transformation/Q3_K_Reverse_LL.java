package DSA_Level_1.G_LinkedList.C_List_Manipulation_and_Transformation;

public class Q3_K_Reverse_LL {

    // Node class (inner class)
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList fields
    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public Q3_K_Reverse_LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add at first
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

    // Add at last
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

    // Remove first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        int data = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return data;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Get size
    public int size() {
        return size;
    }

    // K-REVERSE METHOD (Your main method)
    public void kReverse(int k) {
        LinkedList old = new LinkedList();

        while (this.size() > 0) {
            LinkedList curr = new LinkedList();

            if (this.size() >= k) {
                for (int i = 0; i < k; i++) {
                    int data = this.head.data;
                    curr.addFirst(data);
                    this.removeFirst();
                }
            } else {
                while (this.size() > 0) {
                    int data = this.head.data;
                    curr.addLast(data);
                    this.removeFirst();
                }
            }

            if (old.head == null) {
                old.head = curr.head;
                old.tail = curr.tail;
                old.size = curr.size;
            } else {
                old.tail.next = curr.head;
                old.tail = curr.tail;
                old.size += curr.size;
            }
        }

        this.head = old.head;
        this.tail = old.tail;
        this.size = old.size;
    }

    // Inner LinkedList class used in kReverse
    private static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        void addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        int removeFirst() {
            if (size == 0) return -1;
            int data = head.data;
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
            return data;
        }

        int size() {
            return size;
        }
    }

    // MAIN METHOD to test
    public static void main(String[] args) {
        // Create a list
        Q3_K_Reverse_LL list = new Q3_K_Reverse_LL();

        // Add elements
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        System.out.println("Original List:");
        list.display(); // 1 → 2 → 3 → 4 → 5 → 6 → 7 → null

        // Reverse in groups of k=3
        list.kReverse(3);

        System.out.println("After kReverse(3):");
        list.display(); // 3 → 2 → 1 → 6 → 5 → 4 → 7 → null
    }
}