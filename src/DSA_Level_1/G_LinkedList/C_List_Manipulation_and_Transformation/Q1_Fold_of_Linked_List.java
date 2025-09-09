package DSA_Level_1.G_LinkedList.C_List_Manipulation_and_Transformation;

import java.util.*;

class Q1_Fold_of_Linked_List {
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

    public static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void fold(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return; // No folding needed for empty, single, or two-node lists
        }

        ListNode mid = getMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null; // Split the list into two halves

        ListNode curr1 = head;
        ListNode curr2 = l2;

        while (curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        System.out.println("Enter the elements:");
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        System.out.print("Folded list: ");
        printList(head);
    }
}