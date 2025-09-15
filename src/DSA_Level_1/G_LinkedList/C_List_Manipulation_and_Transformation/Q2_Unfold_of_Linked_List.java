package DSA_Level_1.G_LinkedList.C_List_Manipulation_and_Transformation;

import java.util.*;

class Q2_Unfold_of_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void unfold(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Create two separate lists
        ListNode firstHead = head;
        ListNode secondHead = head.next;

        ListNode first = firstHead;
        ListNode second = secondHead;

        while (second != null && second.next != null) {
            first.next = first.next.next;
            second.next = second.next.next;

            first = first.next;
            second = second.next;
        }

        // Reverse the second list
        secondHead = reverse(secondHead);

        // Append the reversed second list to the end of the first list
        first.next = secondHead;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}