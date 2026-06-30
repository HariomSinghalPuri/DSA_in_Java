package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q13_Ceil_and_Floor {

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    // Method to find ceil and floor of a given value in the tree
    public static void ceilAndFloor(Node node, int data) {
        if (node == null) {
            return;
        }

        // Update floor (largest value smaller than data)
        if (node.data < data) {
            floor = Math.max(floor, node.data);
        }
        // Update ceil (smallest value greater than data)
        else if (node.data > data) {
            ceil = Math.min(ceil, node.data);
        }

        // Recursively check all children
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    // Method to find kth largest element in the tree
    public static int kthLargest(Node node, int k) {
        if (node == null || k <= 0) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        // Find kth largest by finding floor of decreasing values
        for (int i = 1; i <= k; i++) {
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node, ans);
            ans = floor;
        }

        return ans;
    }

    // Method to find kth smallest element in the tree
    public static int kthSmallest(Node node, int k) {
        if (node == null || k <= 0) {
            return -1;
        }

        int ans = Integer.MIN_VALUE;

        // Find kth smallest by finding ceil of increasing values
        for (int i = 1; i <= k; i++) {
            ceil = Integer.MAX_VALUE;
            ceilAndFloor(node, ans);
            ans = ceil;
        }

        return ans;
    }

    // Method to find all elements in a range [lo, hi]
    public static List<Integer> findInRange(Node node, int lo, int hi) {
        List<Integer> result = new ArrayList<>();
        findInRangeHelper(node, lo, hi, result);
        return result;
    }

    private static void findInRangeHelper(Node node, int lo, int hi, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (node.data >= lo && node.data <= hi) {
            result.add(node.data);
        }

        for (Node child : node.children) {
            findInRangeHelper(child, lo, hi, result);
        }
    }

    // Method to get all elements in sorted order (in-order traversal)
    public static List<Integer> getSortedElements(Node node) {
        List<Integer> list = new ArrayList<>();
        getSortedElementsHelper(node, list);
        Collections.sort(list);
        return list;
    }

    private static void getSortedElementsHelper(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.data);
        for (Node child : node.children) {
            getSortedElementsHelper(child, list);
        }
    }

    // Method to find the maximum element in the tree
    public static int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int max = node.data;
        for (Node child : node.children) {
            max = Math.max(max, findMax(child));
        }
        return max;
    }

    // Method to find the minimum element in the tree
    public static int findMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int min = node.data;
        for (Node child : node.children) {
            min = Math.min(min, findMin(child));
        }
        return min;
    }

    // Reset ceil and floor to their default values
    public static void resetCeilFloor() {
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
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

    // Helper method to build a tree with duplicate values
    public static Node buildTreeWithDuplicates() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(20);
        Node child3 = new Node(30);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        Node child4 = new Node(15);
        Node child5 = new Node(25);
        child1.children.add(child4);
        child1.children.add(child5);

        Node child6 = new Node(15);
        Node child7 = new Node(25);
        child2.children.add(child6);
        child2.children.add(child7);

        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Ceil and Floor in Generic Tree ===\n");

        Node root = buildSampleTree();
        System.out.println("Tree Structure:");
        display(root);

        // ===== Test 1: Ceil and Floor for various values =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 1: Ceil and Floor for Various Values");
        int[] testValues = {25, 50, 75, 100, 5, 55, 85, 95};

        for (int data : testValues) {
            resetCeilFloor();
            ceilAndFloor(root, data);
            System.out.println("For value " + data + ":");
            System.out.println("  Ceil  = " + (ceil == Integer.MAX_VALUE ? "Not found" : ceil));
            System.out.println("  Floor = " + (floor == Integer.MIN_VALUE ? "Not found" : floor));
        }

        // ===== Test 2: Kth Largest =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 2: Kth Largest Elements");
        int[] kValues = {1, 2, 3, 4, 5};

        for (int k : kValues) {
            int kthLargest = kthLargest(root, k);
            System.out.println(k + "th Largest = " + kthLargest);
        }

        // ===== Test 3: Kth Smallest =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 3: Kth Smallest Elements");

        for (int k : kValues) {
            int kthSmallest = kthSmallest(root, k);
            System.out.println(k + "th Smallest = " + kthSmallest);
        }

        // ===== Test 4: Find in Range =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 4: Find Elements in Range");
        int[][] ranges = {{25, 75}, {10, 50}, {60, 90}, {1, 100}};

        for (int[] range : ranges) {
            List<Integer> result = findInRange(root, range[0], range[1]);
            System.out.println("Elements in [" + range[0] + ", " + range[1] + "]: " + result);
        }

        // ===== Test 5: Sorted Elements =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 5: Sorted Elements");
        List<Integer> sorted = getSortedElements(root);
        System.out.println("All elements in sorted order: " + sorted);
        System.out.println("Min = " + sorted.get(0));
        System.out.println("Max = " + sorted.get(sorted.size() - 1));

        // ===== Test 6: Tree with Duplicates =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 6: Tree with Duplicate Values");
        Node dupRoot = buildTreeWithDuplicates();
        System.out.println("Tree Structure:");
        display(dupRoot);

        resetCeilFloor();
        ceilAndFloor(dupRoot, 20);
        System.out.println("\nFor value 20:");
        System.out.println("  Ceil  = " + (ceil == Integer.MAX_VALUE ? "Not found" : ceil));
        System.out.println("  Floor = " + (floor == Integer.MIN_VALUE ? "Not found" : floor));

        // ===== Test 7: Edge Cases =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 7: Edge Cases");

        // Single node tree
        Node singleNode = new Node(10);
        resetCeilFloor();
        ceilAndFloor(singleNode, 5);
        System.out.println("Single node tree (value=10):");
        System.out.println("  For 5: Ceil = " + (ceil == Integer.MAX_VALUE ? "Not found" : ceil) +
                ", Floor = " + (floor == Integer.MIN_VALUE ? "Not found" : floor));

        resetCeilFloor();
        ceilAndFloor(singleNode, 15);
        System.out.println("  For 15: Ceil = " + (ceil == Integer.MAX_VALUE ? "Not found" : ceil) +
                ", Floor = " + (floor == Integer.MIN_VALUE ? "Not found" : floor));

        resetCeilFloor();
        ceilAndFloor(singleNode, 10);
        System.out.println("  For 10: Ceil = " + (ceil == Integer.MAX_VALUE ? "Not found" : ceil) +
                ", Floor = " + (floor == Integer.MIN_VALUE ? "Not found" : floor));

        // ===== Test 8: Performance with kthLargest =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 8: kthLargest and kthSmallest Comparison");
        int allK = 6; // Total unique elements in our tree

        System.out.println("All kthLargest values:");
        for (int i = 1; i <= allK; i++) {
            int val = kthLargest(root, i);
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("All kthSmallest values:");
        for (int i = 1; i <= allK; i++) {
            int val = kthSmallest(root, i);
            System.out.print(val + " ");
        }
        System.out.println();
    }
}