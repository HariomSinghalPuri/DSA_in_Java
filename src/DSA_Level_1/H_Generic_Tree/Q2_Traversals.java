package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q2_Traversals {

    // Pre-order and Post-order traversals with edge traversals
    public static void traversals(Node root) {
        // Node Pre - Entering the node
        System.out.println("Node Pre " + root.data);

        // Traverse all children
        for (Node child : root.children) {
            // Edge Pre - Going from parent to child
            System.out.println("Edge Pre " + root.data + "--" + child.data);

            // Recursive call on child
            traversals(child);

            // Edge Post - Coming back from child to parent
            System.out.println("Edge Post " + root.data + "--" + child.data);
        }

        // Node Post - Exiting the node
        System.out.println("Node Post " + root.data);
    }

    // Level Order Traversal (BFS)
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (q.size() > 0) {
            // Remove 1 Node from front
            Node curr = q.remove();
            System.out.print(curr.data + " ");

            // Add all children to the queue
            for (Node child : curr.children) {
                q.add(child);
            }
        }

        System.out.println(".");
    }

    // Helper method to build a sample tree for testing
    public static Node buildSampleTree() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(30);
        Node child3 = new Node(40);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        Node child4 = new Node(50);
        Node child5 = new Node(60);
        child1.children.add(child4);
        child1.children.add(child5);

        Node child6 = new Node(70);
        Node child7 = new Node(80);
        child2.children.add(child6);
        child2.children.add(child7);

        Node child8 = new Node(90);
        Node child9 = new Node(100);
        child3.children.add(child8);
        child3.children.add(child9);

        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        Node root = buildSampleTree();

        System.out.println("=== Traversals (Pre/Post with Edges) ===");
        traversals(root);

        System.out.println("\n=== Level Order Traversal ===");
        levelOrder(root);
    }
}