package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q6_Node_to_Root_Path {

    // Method to find path from node to root
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    // Method to find Lowest Common Ancestor
    // Time Complexity - O(N), Auxiliary Space - O(N)
    public static int lca(Node node, int d1, int d2) {
        if (node == null) {
            return -1;
        }

        ArrayList<Integer> a1 = nodeToRootPath(node, d1);
        ArrayList<Integer> a2 = nodeToRootPath(node, d2);

        int LCA = -1;
        int i = a1.size() - 1;
        int j = a2.size() - 1;

        while (i >= 0 && j >= 0) {
            if (!a1.get(i).equals(a2.get(j))) {
                break;
            }
            LCA = a1.get(i);
            i--;
            j--;
        }

        return LCA;
    }

    // Method to find distance between two nodes
    // Time & Space - O(N)
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        if (node == null) {
            return -1;
        }

        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        // If either path is empty, node not found
        if (p1.isEmpty() || p2.isEmpty()) {
            return -1;
        }

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i).equals(p2.get(j))) {
            i--;
            j--;
        }

        return (i + 1) + (j + 1);
    }

    // Alternative method to find LCA using direct approach (without storing full paths)
    public static int lcaOptimized(Node node, int d1, int d2) {
        if (node == null) {
            return -1;
        }

        // If node matches either data
        if (node.data == d1 || node.data == d2) {
            return node.data;
        }

        // Store LCA candidates from each child
        int lcaResult = -1;
        int foundCount = 0;

        for (Node child : node.children) {
            int childLCA = lcaOptimized(child, d1, d2);
            if (childLCA != -1) {
                foundCount++;
                lcaResult = childLCA;
            }
        }

        // If both values found in different subtrees, current node is LCA
        if (foundCount == 2) {
            return node.data;
        }

        // If only one value found, return it
        if (foundCount == 1) {
            return lcaResult;
        }

        return -1; // Neither value found
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

        // Adding deeper nodes for better testing
        Node child10 = new Node(110);
        Node child11 = new Node(120);
        child4.children.add(child10);
        child4.children.add(child11);

        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        Node root = buildSampleTree();

        System.out.println("=== Node to Root Path ===");
        int data1 = 50;
        int data2 = 110;
        int data3 = 90;

        // Test nodeToRootPath
        ArrayList<Integer> path1 = nodeToRootPath(root, data1);
        System.out.println("Path from " + data1 + " to root: " + path1);

        ArrayList<Integer> path2 = nodeToRootPath(root, data2);
        System.out.println("Path from " + data2 + " to root: " + path2);

        ArrayList<Integer> path3 = nodeToRootPath(root, data3);
        System.out.println("Path from " + data3 + " to root: " + path3);

        // Test LCA
        System.out.println("\n=== Lowest Common Ancestor ===");
        System.out.println("LCA of " + data1 + " and " + data2 + ": " + lca(root, data1, data2));
        System.out.println("LCA of " + data1 + " and " + data3 + ": " + lca(root, data1, data3));
        System.out.println("LCA of " + data2 + " and " + data3 + ": " + lca(root, data2, data3));
        System.out.println("LCA of 10 and 100: " + lca(root, 10, 100));

        // Test Optimized LCA
        System.out.println("\n=== Optimized LCA ===");
        System.out.println("LCA of " + data1 + " and " + data2 + ": " + lcaOptimized(root, data1, data2));
        System.out.println("LCA of " + data1 + " and " + data3 + ": " + lcaOptimized(root, data1, data3));

        // Test Distance
        System.out.println("\n=== Distance Between Nodes ===");
        System.out.println("Distance between " + data1 + " and " + data2 + ": " + distanceBetweenNodes(root, data1, data2));
        System.out.println("Distance between " + data1 + " and " + data3 + ": " + distanceBetweenNodes(root, data1, data3));
        System.out.println("Distance between " + data2 + " and " + data3 + ": " + distanceBetweenNodes(root, data2, data3));
        System.out.println("Distance between 10 and 100: " + distanceBetweenNodes(root, 10, 100));
        System.out.println("Distance between 20 and 30: " + distanceBetweenNodes(root, 20, 30));
    }
}