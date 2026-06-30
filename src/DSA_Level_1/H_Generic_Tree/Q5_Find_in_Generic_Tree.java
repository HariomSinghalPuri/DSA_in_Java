package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q5_Find_in_Generic_Tree {

    // Method to find if a node with given data exists in the tree
    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        // Check if current node has the data
        if (node.data == data) {
            return true;
        }

        // Recursively search in all children
        for (Node child : node.children) {
            boolean ans = find(child, data);
            if (ans == true) {
                return true;
            }
        }

        return false;
    }

    // Alternative implementation using DFS approach
    public static boolean findDFS(Node node, int data) {
        if (node == null) {
            return false;
        }

        // Stack for iterative DFS
        Stack<Node> stk = new Stack<>();
        stk.push(node);

        while (!stk.isEmpty()) {
            Node curr = stk.pop();

            if (curr.data == data) {
                return true;
            }

            // Add children to stack
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stk.push(curr.children.get(i));
            }
        }

        return false;
    }

    // Alternative implementation using BFS (Level Order)
    public static boolean findBFS(Node node, int data) {
        if (node == null) {
            return false;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr.data == data) {
                return true;
            }

            for (Node child : curr.children) {
                q.add(child);
            }
        }

        return false;
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

        System.out.println("=== Find in Generic Tree ===\n");

        // Test cases using recursive method
        int[] testData = {50, 90, 25, 100, 10, 200};

        System.out.println("Recursive Method:");
        for (int data : testData) {
            boolean found = find(root, data);
            System.out.println("Find " + data + ": " + (found ? "Found ✅" : "Not Found ❌"));
        }

        System.out.println("\nDFS Method:");
        for (int data : testData) {
            boolean found = findDFS(root, data);
            System.out.println("Find " + data + ": " + (found ? "Found ✅" : "Not Found ❌"));
        }

        System.out.println("\nBFS Method:");
        for (int data : testData) {
            boolean found = findBFS(root, data);
            System.out.println("Find " + data + ": " + (found ? "Found ✅" : "Not Found ❌"));
        }
    }
}