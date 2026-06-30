package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q11_Maximum_Subtree_Sum {

    // ============ Similar Trees ============
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            boolean ans = areSimilar(c1, c2);
            if (ans == false) {
                return false;
            }
        }

        return true;
    }

    // ============ Mirror Trees ============
    public static boolean areMirror(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - 1 - i);

            boolean ans = areMirror(c1, c2);
            if (ans == false) {
                return false;
            }
        }

        return true;
    }

    // ============ Symmetric Tree ============
    public static boolean isSymmetric(Node node) {
        if (node == null) {
            return true;
        }
        return areMirror(node, node);
    }

    // ============ Maximum Subtree Sum ============
    // Class to store result for maximum subtree sum
    static class MaxSubtreeResult {
        int maxSum;
        Node maxNode;

        MaxSubtreeResult(int maxSum, Node maxNode) {
            this.maxSum = maxSum;
            this.maxNode = maxNode;
        }
    }

    // Method to find maximum subtree sum
    public static MaxSubtreeResult maxSubtreeSum(Node node) {
        if (node == null) {
            return new MaxSubtreeResult(Integer.MIN_VALUE, null);
        }

        // Calculate sum of current subtree
        int currentSum = node.data;
        for (Node child : node.children) {
            currentSum += child.data;
        }

        // Initialize result with current node
        MaxSubtreeResult result = new MaxSubtreeResult(currentSum, node);

        // Check all children
        for (Node child : node.children) {
            MaxSubtreeResult childResult = maxSubtreeSum(child);
            if (childResult.maxSum > result.maxSum) {
                result = childResult;
            }
        }

        return result;
    }

    // Alternative approach using global variables
    static int maxSum = Integer.MIN_VALUE;
    static Node maxNode = null;

    public static int maxSubtreeSumAlt(Node node) {
        if (node == null) {
            return 0;
        }

        // Calculate sum of current subtree
        int sum = node.data;
        for (Node child : node.children) {
            sum += maxSubtreeSumAlt(child);
        }

        // Update global max
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = node;
        }

        return sum;
    }

    // Method to get subtree sum for a specific node
    public static int getSubtreeSum(Node node) {
        if (node == null) {
            return 0;
        }

        int sum = node.data;
        for (Node child : node.children) {
            sum += getSubtreeSum(child);
        }
        return sum;
    }

    // ============ Display Methods ============
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

    // Method to display subtree rooted at a node
    public static void displaySubtree(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.data);
        for (Node child : node.children) {
            displaySubtree(child, indent + "  ");
        }
    }

    // ============ Tree Builders ============
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

    public static Node buildTreeWithNegativeValues() {
        Node root = new Node(-10);
        Node child1 = new Node(-20);
        Node child2 = new Node(-30);
        Node child3 = new Node(100);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        Node child4 = new Node(-50);
        Node child5 = new Node(-60);
        child1.children.add(child4);
        child1.children.add(child5);

        Node child6 = new Node(200);
        Node child7 = new Node(300);
        child3.children.add(child6);
        child3.children.add(child7);

        return root;
    }

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

    // ============ Main Method ============
    public static void main(String[] args) {
        System.out.println("=== Generic Tree Operations ===\n");

        // ===== Test 1: Similar Trees =====
        System.out.println("Test 1: Similar Trees");
        Node tree1 = buildSampleTree();
        Node tree2 = buildSampleTree();

        System.out.println("Tree 1:");
        display(tree1);
        System.out.println("\nTree 2:");
        display(tree2);

        boolean similar = areSimilar(tree1, tree2);
        System.out.println("\nAre the trees similar? " + (similar ? "Yes ✅" : "No ❌"));

        // Modify tree2 to make it different
        if (!tree2.children.isEmpty()) {
            tree2.children.remove(0);
        }
        similar = areSimilar(tree1, tree2);
        System.out.println("After modifying Tree 2, are they similar? " + (similar ? "Yes ✅" : "No ❌"));

        // ===== Test 2: Mirror Trees =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 2: Mirror Trees");
        Node tree3 = buildSampleTree();
        Node tree4 = buildSampleTree();

        System.out.println("Tree 3:");
        display(tree3);
        System.out.println("\nTree 4 (will be mirrored):");
        display(tree4);

        // Mirror tree4
        mirrorTree(tree4);
        System.out.println("\nMirrored Tree 4:");
        display(tree4);

        boolean mirror = areMirror(tree3, tree4);
        System.out.println("\nAre Tree 3 and Tree 4 mirrors? " + (mirror ? "Yes ✅" : "No ❌"));

        // ===== Test 3: Symmetric Tree =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 3: Symmetric Tree");
        Node symTree = buildSymmetricTree();
        System.out.println("Symmetric Tree:");
        display(symTree);

        boolean symmetric = isSymmetric(symTree);
        System.out.println("\nIs the tree symmetric? " + (symmetric ? "Yes ✅" : "No ❌"));

        // ===== Test 4: Maximum Subtree Sum =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 4: Maximum Subtree Sum");
        Node root = buildSampleTree();
        System.out.println("Original Tree:");
        display(root);

        // Calculate subtree sums for each node
        System.out.println("\nSubtree sums:");
        calculateAndDisplaySubtreeSums(root);

        // Find maximum subtree sum using first approach
        MaxSubtreeResult result = maxSubtreeSum(root);
        System.out.println("\nMaximum Subtree Sum (Approach 1):");
        System.out.println("Sum: " + result.maxSum);
        System.out.println("Root node of max subtree: " + result.maxNode.data);
        System.out.println("Subtree with max sum:");
        displaySubtree(result.maxNode, "");

        // Find maximum subtree sum using second approach
        maxSum = Integer.MIN_VALUE;
        maxNode = null;
        maxSubtreeSumAlt(root);
        System.out.println("\nMaximum Subtree Sum (Approach 2):");
        System.out.println("Sum: " + maxSum);
        System.out.println("Root node of max subtree: " + maxNode.data);

        // ===== Test 5: Maximum Subtree Sum with Negative Values =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 5: Maximum Subtree Sum with Negative Values");
        Node negRoot = buildTreeWithNegativeValues();
        System.out.println("Tree with negative values:");
        display(negRoot);

        System.out.println("\nSubtree sums:");
        calculateAndDisplaySubtreeSums(negRoot);

        MaxSubtreeResult negResult = maxSubtreeSum(negRoot);
        System.out.println("\nMaximum Subtree Sum:");
        System.out.println("Sum: " + negResult.maxSum);
        System.out.println("Root node of max subtree: " + negResult.maxNode.data);
        System.out.println("Subtree with max sum:");
        displaySubtree(negResult.maxNode, "");
    }

    // Helper method to mirror a tree
    public static void mirrorTree(Node node) {
        if (node == null) {
            return;
        }

        Collections.reverse(node.children);
        for (Node child : node.children) {
            mirrorTree(child);
        }
    }

    // Helper method to calculate and display subtree sums
    public static void calculateAndDisplaySubtreeSums(Node node) {
        if (node == null) {
            return;
        }

        int sum = getSubtreeSum(node);
        System.out.println("Node " + node.data + " : " + sum);

        for (Node child : node.children) {
            calculateAndDisplaySubtreeSums(child);
        }
    }
}