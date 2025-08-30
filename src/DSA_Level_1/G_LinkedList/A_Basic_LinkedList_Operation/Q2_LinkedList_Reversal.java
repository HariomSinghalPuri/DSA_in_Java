package DSA_Level_1.G_LinkedList.A_Basic_LinkedList_Operation;

public class Q2_LinkedList_Reversal {
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

    // Linked List class with reversal methods
    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;
        private Node left; // For reverseDR()

        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // Add Node at the end
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

        // Display the linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Get node at given index - O(N)
        private Node getNodeAt(int idx) {
            if (idx < 0 || idx >= size) {
                return null;
            }

            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        // Data Iterative Reversal - O(N²)
        public void reverseDI() {
            int left = 0, right = size - 1;
            while (left < right) {
                Node leftNode = getNodeAt(left);
                Node rightNode = getNodeAt(right);

                // Swap data
                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;

                left++;
                right--;
            }
        }

        // Pointer Iterative Reversal - O(N) (Most Efficient)
        public void reversePI() {
            if (head == null || head.next == null) {
                // 0 nodes or 1 node
                return;
            }

            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node nextNode = curr.next; // Save next node
                curr.next = prev;         // Reverse pointer

                // Move pointers forward
                prev = curr;
                curr = nextNode;
            }

            // Update head and tail
            tail = head;
            head = prev;
        }

        // Data Recursive Reversal - Method 1: Using data member 'left'
        private void reverseDRHelper1(Node right, int counter) {
            if (right == null) return;

            reverseDRHelper1(right.next, counter + 1);

            if (counter >= size / 2) {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                left = left.next;
            }
        }

        // Data Recursive Reversal - Method 2: Using return type
        private Node reverseDRHelper2(Node left, Node right, int counter) {
            if (right == null) return left;

            left = reverseDRHelper2(left, right.next, counter + 1);

            if (counter >= size / 2) {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }

            return left.next;
        }

        public void reverseDR() {
            left = head;
            reverseDRHelper1(head, 0);
            // Alternatively: reverseDRHelper2(head, head, 0);
        }

        // Pointer Recursive Reversal - O(N)
        private void reversePRHelper(Node curr) {
            if (curr == tail) {
                // Base case: last node
                return;
            }

            reversePRHelper(curr.next);

            // Process next node in postorder
            curr.next.next = curr;
        }

        public void reversePR() {
            if (head == null) return;

            reversePRHelper(head);

            // Update last node's next as null
            head.next = null;

            // Swap head and tail
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }

    // Test method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements to the list
        for (int i = 1; i <= 5; i++) {
            list.addLast(i);
        }

        System.out.print("Original list: ");
        list.display();

        // Test Data Iterative Reversal
        LinkedList list1 = new LinkedList();
        for (int i = 1; i <= 5; i++) list1.addLast(i);
        list1.reverseDI();
        System.out.print("Data Iterative: ");
        list1.display();

        // Test Pointer Iterative Reversal
        LinkedList list2 = new LinkedList();
        for (int i = 1; i <= 5; i++) list2.addLast(i);
        list2.reversePI();
        System.out.print("Pointer Iterative: ");
        list2.display();

        // Test Data Recursive Reversal
        LinkedList list3 = new LinkedList();
        for (int i = 1; i <= 5; i++) list3.addLast(i);
        list3.reverseDR();
        System.out.print("Data Recursive: ");
        list3.display();

        // Test Pointer Recursive Reversal
        LinkedList list4 = new LinkedList();
        for (int i = 1; i <= 5; i++) list4.addLast(i);
        list4.reversePR();
        System.out.print("Pointer Recursive: ");
        list4.display();
    }
}