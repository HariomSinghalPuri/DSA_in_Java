package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q7_Mirror_Generic_Tree {

    // Method to mirror the generic tree
    public static void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Reverse the order of children at current node
        Collections.reverse(node.children);

        // Recursively mirror all children
        for (Node child : node.children) {
            mirror(child);
        }
    }

    // Method to check if two trees are mirror images
    public static boolean areMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        for (int i = 0; i < node1.children.size(); i++) {
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(node2.children.size() - 1 - i);

            if (!areMirror(child1, child2)) {
                return false;
            }
        }

        return true;
    }

    // Method to check if a tree is symmetric (mirror of itself)
    public static boolean isSymmetric(Node node) {
        if (node == null) {
            return true;
        }
        return areMirror(node, node);
    }

    // Method to create a deep copy of the tree
    public static Node copyTree(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.data);
        for (Node child : node.children) {
            newNode.children.add(copyTree(child));
        }
        return newNode;
    }

    // Method to display the tree (for testing)
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + " ";
        }
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
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

    // Helper method to build a symmetric tree for testing
    public static Node buildSymmetricTree() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(20);

        root.children.add(child1);
        root.children.add(child2);

        Node child3 = new Node(30);
        Node child4 = new Node(40);
        Node child5 = new Node(40);
        Node child6 = new Node(30);

        child1.children.add(child3);
        child1.children.add(child4);
        child2.children.add(child5);
        child2.children.add(child6);

        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Mirror Generic Tree ===\n");

        // Test 1: Mirror a normal tree
        Node root = buildSampleTree();

        System.out.println("Original Tree:");
        display(root);

        System.out.println("\nMirroring Tree...");
        mirror(root);

        System.out.println("\nMirrored Tree:");
        display(root);

        // Test 2: Check if two trees are mirrors
        System.out.println("\n=== Check Mirror Images ===");
        Node root1 = buildSampleTree();
        Node root2 = buildSampleTree();

        // Mirror root2
        mirror(root2);

        System.out.println("Tree 1:");
        display(root1);
        System.out.println("Tree 2 (mirrored):");
        display(root2);

        boolean isMirror = areMirror(root1, root2);
        System.out.println("Are Tree1 and Tree2 mirrors? " + (isMirror ? "Yes ✅" : "No ❌"));

        // Test 3: Symmetric tree
        System.out.println("\n=== Check Symmetric Tree ===");
        Node symmetricRoot = buildSymmetricTree();
        System.out.println("Symmetric Tree:");
        display(symmetricRoot);

        boolean isSymmetric = isSymmetric(symmetricRoot);
        System.out.println("Is the tree symmetric? " + (isSymmetric ? "Yes ✅" : "No ❌"));

        // Test 4: Mirror a symmetric tree
        System.out.println("\n=== Mirroring Symmetric Tree ===");
        System.out.println("Original Symmetric Tree:");
        display(symmetricRoot);

        mirror(symmetricRoot);
        System.out.println("\nMirrored Symmetric Tree (should look same):");
        display(symmetricRoot);

        // Test 5: Copy tree and mirror
        System.out.println("\n=== Copy and Mirror ===");
        Node original = buildSampleTree();
        Node copy = copyTree(original);

        System.out.println("Original Tree:");
        display(original);

        System.out.println("\nCopy Tree:");
        display(copy);

        mirror(copy);
        System.out.println("\nMirrored Copy:");
        display(copy);

        System.out.println("\nOriginal Tree (unchanged):");
        display(original);
    }
}