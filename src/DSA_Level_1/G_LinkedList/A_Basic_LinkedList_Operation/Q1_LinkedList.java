package DSA_Level_1.G_LinkedList.A_Basic_LinkedList_Operation;

public class Q1_LinkedList {
    // Node class definition
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Linked List class definition
    private Node head;
    private Node tail;
    private int size;

    public Q1_LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add Node at the end - O(1)
    public void addLast(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Add Node at the beginning - O(1)
    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add Node at given index - O(N) worst case
    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node prev = getNodeAt(idx - 1);
            Node newNode = new Node(val);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    // Traverse Linked List - O(N)
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Get first element - O(1)
    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    // Get last element - O(1) with tail pointer
    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    // Get element at given index - O(N) worst case
    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Get node at given index - O(N)
    private Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Remove first element - O(1)
    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    // Remove last element - O(N) in singly linked list
    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
        } else {
            Node secondLast = head;
            while (secondLast.next != tail) {
                secondLast = secondLast.next;
            }
            secondLast.next = null;
            tail = secondLast;
        }
        size--;
    }

    // Remove element at given index - O(N) worst case
    public void removeAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node prev = getNodeAt(idx - 1);
            prev.next = prev.next.next;
            size--;
        }
    }

    // Display Linked List in Reverse using Recursion
    // O(N) Time, O(N) Recursion Call Stack Space
    public void displayReverse() {
        displayReverseHelper(head);
        System.out.println();
    }

    private void displayReverseHelper(Node curr) {
        if (curr == null) return;
        displayReverseHelper(curr.next);
        System.out.print(curr.data + " ");
    }

    // Get size of the list
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Test the implementation
    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addAt(2, 15);

        System.out.print("List: ");
        list.display(); // Output: 5 10 15 20 30

        System.out.println("First element: " + list.getFirst()); // Output: 5
        System.out.println("Last element: " + list.getLast()); // Output: 30
        System.out.println("Element at index 2: " + list.getAt(2)); // Output: 15

        System.out.print("List in reverse: ");
        list.displayReverse(); // Output: 30 20 15 10 5

        list.removeAt(2);
        System.out.print("After removing element at index 2: ");
        list.display(); // Output: 5 10 20 30

        list.removeFirst();
        System.out.print("After removing first element: ");
        list.display(); // Output: 10 20 30

        list.removeLast();
        System.out.print("After removing last element: ");
        list.display(); // Output: 10 20
    }
}