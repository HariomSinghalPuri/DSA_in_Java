package DSA_Level_1.G_LinkedList.B_Duplicates_and_Cleanup;

import java.util.*;

class Q2_Remove_All_Duplicates {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next == null || curr.next.val != curr.val) {
                // unique node
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            } else {
                // delete duplicate nodes
                int temp = curr.val;
                while (curr != null && curr.val == temp) {
                    curr = curr.next;
                }
            }
        }

        tail.next = null; // Terminate the list
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();

        System.out.println("Enter the elements (sorted):");
        ListNode head = makeList(n);

        head = removeDuplicates(head);
        System.out.print("List after removing duplicates: ");
        printList(head);
    }
}