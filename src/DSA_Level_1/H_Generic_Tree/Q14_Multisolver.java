package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q14_Multisolver {

    // ============ Approach 1: Using Static Variables ============
    static int size = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;

    public static void multisolver(Node root, int level) {
        if (root == null) return;

        // Preorder processing
        size++;
        if (root.data < min) min = root.data;
        if (root.data > max) max = root.data;
        if (level > height) height = level;

        for (Node child : root.children) {
            multisolver(child, level + 1);
        }
    }

    // Reset static variables
    public static void resetStaticValues() {
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
    }

    // ============ Approach 2: Using Class/Object ============
    public static class Multisolver {
        int size;
        int min;
        int max;
        int height;

        // Constructor for leaf node
        Multisolver(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.height = 0;
        }

        // Full constructor
        Multisolver(int size, int min, int max, int height) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Size: " + size +
                    ", Min: " + min +
                    ", Max: " + max +
                    ", Height: " + height;
        }
    }

    public static Multisolver multisolver2(Node root) {
        if (root == null) {
            return new Multisolver(0, Integer.MAX_VALUE, Integer.MIN_VALUE, -1);
        }

        // Initialize with current node
        Multisolver ans = new Multisolver(1, root.data, root.data, 0);

        for (Node child : root.children) {
            Multisolver temp = multisolver2(child);

            ans.size += temp.size;
            ans.max = Math.max(ans.max, temp.max);
            ans.min = Math.min(ans.min, temp.min);
            ans.height = Math.max(ans.height, temp.height + 1);
        }

        return ans;
    }

    // ============ Approach 3: Using Array ============
    public static void multisolver3(Node root, int level, int[] ans) {
        if (root == null) return;

        // ans[0] = size, ans[1] = min, ans[2] = max, ans[3] = height
        ans[0]++; // size
        if (root.data < ans[1]) ans[1] = root.data; // min
        if (root.data > ans[2]) ans[2] = root.data; // max
        if (level > ans[3]) ans[3] = level; // height

        for (Node child : root.children) {
            multisolver3(child, level + 1, ans);
        }
    }

    // ============ Approach 4: Using Pair Class ============
    public static class TreeStats {
        int size;
        int min;
        int max;
        int height;

        TreeStats() {
            this.size = 0;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.height = -1;
        }

        TreeStats(int size, int min, int max, int height) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.height = height;
        }

        public void display() {
            System.out.println("Size: " + size);
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Height: " + height);
        }
    }

    public static TreeStats getTreeStats(Node root) {
        if (root == null) {
            return new TreeStats();
        }

        TreeStats stats = new TreeStats(1, root.data, root.data, 0);

        for (Node child : root.children) {
            TreeStats childStats = getTreeStats(child);
            stats.size += childStats.size;
            stats.min = Math.min(stats.min, childStats.min);
            stats.max = Math.max(stats.max, childStats.max);
            stats.height = Math.max(stats.height, childStats.height + 1);
        }

        return stats;
    }

    // ============ Additional Utility Methods ============

    // Method to get size
    public static int getSize(Node root) {
        if (root == null) return 0;

        int size = 1;
        for (Node child : root.children) {
            size += getSize(child);
        }
        return size;
    }

    // Method to get minimum value
    public static int getMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int min = root.data;
        for (Node child : root.children) {
            min = Math.min(min, getMin(child));
        }
        return min;
    }

    // Method to get maximum value
    public static int getMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int max = root.data;
        for (Node child : root.children) {
            max = Math.max(max, getMax(child));
        }
        return max;
    }

    // Method to get height
    public static int getHeight(Node root) {
        if (root == null) return -1;

        int height = -1;
        for (Node child : root.children) {
            height = Math.max(height, getHeight(child));
        }
        return height + 1;
    }

    // Method to display tree
    public static void display(Node node) {
        if (node == null) return;

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

        // Adding more nodes for better testing
        Node child10 = new Node(15);
        Node child11 = new Node(25);
        Node child12 = new Node(35);
        Node child13 = new Node(45);

        child1.children.add(child10);
        child2.children.add(child11);
        child3.children.add(child12);
        child4.children.add(child13);

        return root;
    }

    public static Node buildSingleNodeTree() {
        return new Node(10);
    }

    public static Node buildTreeWithNegativeValues() {
        Node root = new Node(-10);
        Node child1 = new Node(-20);
        Node child2 = new Node(30);
        Node child3 = new Node(-40);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        Node child4 = new Node(-50);
        Node child5 = new Node(60);
        child1.children.add(child4);
        child1.children.add(child5);

        return root;
    }

    // ============ Main Method ============
    public static void main(String[] args) {
        System.out.println("=== Multisolver - Generic Tree ===\n");

        Node root = buildSampleTree();
        System.out.println("Tree Structure:");
        display(root);
        System.out.println();

        // ===== Approach 1: Static Variables =====
        System.out.println("=".repeat(60));
        System.out.println("Approach 1: Using Static Variables");
        resetStaticValues();
        multisolver(root, 0);
        System.out.println("Size: " + size);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Height: " + height);

        // ===== Approach 2: Class/Object =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Approach 2: Using Class/Object");
        Multisolver result2 = multisolver2(root);
        System.out.println("Size: " + result2.size);
        System.out.println("Min: " + result2.min);
        System.out.println("Max: " + result2.max);
        System.out.println("Height: " + result2.height);

        // ===== Approach 3: Array =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Approach 3: Using Array");
        int[] ans = {0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        multisolver3(root, 0, ans);
        System.out.println("Size: " + ans[0]);
        System.out.println("Min: " + ans[1]);
        System.out.println("Max: " + ans[2]);
        System.out.println("Height: " + ans[3]);

        // ===== Approach 4: Pair Class =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Approach 4: Using Pair Class");
        TreeStats stats = getTreeStats(root);
        stats.display();

        // ===== Verification using individual methods =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Verification using Individual Methods:");
        System.out.println("Size (getSize): " + getSize(root));
        System.out.println("Min (getMin): " + getMin(root));
        System.out.println("Max (getMax): " + getMax(root));
        System.out.println("Height (getHeight): " + getHeight(root));

        // ===== Test 2: Single Node Tree =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test: Single Node Tree");
        Node singleNode = buildSingleNodeTree();
        System.out.println("Tree:");
        display(singleNode);

        resetStaticValues();
        multisolver(singleNode, 0);
        System.out.println("\nStatic Approach:");
        System.out.println("Size: " + size);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Height: " + height);

        Multisolver resultSingle = multisolver2(singleNode);
        System.out.println("\nClass Approach:");
        System.out.println("Size: " + resultSingle.size);
        System.out.println("Min: " + resultSingle.min);
        System.out.println("Max: " + resultSingle.max);
        System.out.println("Height: " + resultSingle.height);

        // ===== Test 3: Tree with Negative Values =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test: Tree with Negative Values");
        Node negRoot = buildTreeWithNegativeValues();
        System.out.println("Tree:");
        display(negRoot);

        TreeStats negStats = getTreeStats(negRoot);
        System.out.println("\nStats:");
        negStats.display();

        // ===== Test 4: Comparing all approaches =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Comparison of All Approaches:");

        resetStaticValues();
        multisolver(root, 0);

        Multisolver result2b = multisolver2(root);

        int[] ans3 = {0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        multisolver3(root, 0, ans3);

        TreeStats stats4 = getTreeStats(root);

        System.out.println("Metric\t\tStatic\tClass\tArray\tPair");
        System.out.println("Size\t\t" + size + "\t" + result2b.size + "\t" + ans3[0] + "\t" + stats4.size);
        System.out.println("Min\t\t" + min + "\t" + result2b.min + "\t" + ans3[1] + "\t" + stats4.min);
        System.out.println("Max\t\t" + max + "\t" + result2b.max + "\t" + ans3[2] + "\t" + stats4.max);
        System.out.println("Height\t\t" + height + "\t" + result2b.height + "\t" + ans3[3] + "\t" + stats4.height);

        // Verify all approaches give same results
        boolean allMatch = (size == result2b.size && size == ans3[0] && size == stats4.size) &&
                (min == result2b.min && min == ans3[1] && min == stats4.min) &&
                (max == result2b.max && max == ans3[2] && max == stats4.max) &&
                (height == result2b.height && height == ans3[3] && height == stats4.height);

        System.out.println("\nAll approaches match: " + (allMatch ? "✅ Yes" : "❌ No"));
    }
}