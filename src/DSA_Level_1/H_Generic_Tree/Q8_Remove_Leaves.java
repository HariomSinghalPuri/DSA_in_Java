package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q8_Remove_Leaves {

    // Helper method to remove leaves from the tree
    public static void removeLeavesHelper(Node root) {
        if (root == null) {
            return;
        }

        // Meeting Expectation: Remove leaf children
        // Iterate from end to start to avoid index shifting issues
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);

            // If child node is a leaf node, remove it
            if (child.children.size() == 0) {
                root.children.remove(i);
            }
        }

        // Faith: Recursively remove leaves from remaining children
        for (Node child : root.children) {
            removeLeavesHelper(child);
        }
    }

    // Main method to remove leaves from the tree
    public static void removeLeaves(Node root) {
        if (root == null) {
            return;
        }

        // If root itself is a leaf (only one node in tree)
        if (root.children.size() == 0) {
            // Can't set root to null in Java and expect it to reflect outside
            // So we just return and handle this case in main
            return;
        }

        removeLeavesHelper(root);
    }

    // Alternative approach: Remove leaves in one pass
    public static void removeLeavesAlt(Node root) {
        if (root == null) {
            return;
        }

        // If root has no children, it's a leaf
        if (root.children.size() == 0) {
            return;
        }

        // Remove leaf children
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                root.children.remove(i);
            }
        }

        // Recursively process remaining children
        for (Node child : root.children) {
            removeLeavesAlt(child);
        }
    }

    // Method to display the tree (for testing)
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = node.data + " -> ";
        if (node.children.isEmpty()) {
            str += ".";
        } else {
            for (Node child : node.children) {
                str += child.data + " ";
            }
        }
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    // Method to count nodes in tree (for verification)
    public static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int count = 1; // Count current node
        for (Node child : node.children) {
            count += countNodes(child);
        }
        return count;
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

        // Adding some leaf nodes for testing
        Node child10 = new Node(110);
        Node child11 = new Node(120);
        child4.children.add(child10);
        child4.children.add(child11);

        return root;
    }

    // Helper method to build a tree where root is a leaf
    public static Node buildSingleNodeTree() {
        return new Node(10);
    }

    // Helper method to build a tree with only root and leaves
    public static Node buildTreeWithOnlyLeaves() {
        Node root = new Node(10);
        root.children.add(new Node(20));
        root.children.add(new Node(30));
        root.children.add(new Node(40));
        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Remove Leaves from Generic Tree ===\n");

        // Test 1: Remove leaves from normal tree
        System.out.println("Test 1: Normal Tree");
        Node root = buildSampleTree();
        System.out.println("Original Tree:");
        display(root);
        System.out.println("Number of nodes: " + countNodes(root));

        System.out.println("\nRemoving leaves...");
        removeLeaves(root);

        System.out.println("\nTree after removing leaves:");
        display(root);
        System.out.println("Number of nodes after removal: " + countNodes(root));

        // Test 2: Tree with only root and leaves
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nTest 2: Tree with only root and leaves");
        Node root2 = buildTreeWithOnlyLeaves();
        System.out.println("Original Tree:");
        display(root2);
        System.out.println("Number of nodes: " + countNodes(root2));

        System.out.println("\nRemoving leaves...");
        removeLeaves(root2);

        System.out.println("\nTree after removing leaves (only root should remain):");
        display(root2);
        System.out.println("Number of nodes after removal: " + countNodes(root2));

        // Test 3: Single node tree
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nTest 3: Single Node Tree");
        Node root3 = buildSingleNodeTree();
        System.out.println("Original Tree:");
        display(root3);
        System.out.println("Number of nodes: " + countNodes(root3));

        System.out.println("\nRemoving leaves...");
        removeLeaves(root3);

        System.out.println("\nTree after removing leaves (should remain unchanged):");
        display(root3);
        System.out.println("Number of nodes after removal: " + countNodes(root3));

        // Test 4: Alternative approach
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nTest 4: Alternative Approach");
        Node root4 = buildSampleTree();
        System.out.println("Original Tree:");
        display(root4);

        System.out.println("\nRemoving leaves using alternative method...");
        removeLeavesAlt(root4);

        System.out.println("\nTree after removing leaves:");
        display(root4);
        System.out.println("Number of nodes after removal: " + countNodes(root4));
    }
}