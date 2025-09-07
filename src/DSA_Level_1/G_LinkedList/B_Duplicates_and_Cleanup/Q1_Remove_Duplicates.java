package DSA_Level_1.G_LinkedList.B_Duplicates_and_Cleanup;

public class Q1_Remove_Duplicates {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void removeDuplicates() {
        if(head == null) return;

        Node curr = head;
        while(curr.next != null) {
            Node ahead = curr.next;

            if(curr.data != ahead.data) {
                // move pointer
                curr = curr.next;
            } else {
                // delete next node
                curr.next = curr.next.next;
                size--;
            }
        }

        tail = curr;
    }

    // Additional utility methods would typically be here
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
