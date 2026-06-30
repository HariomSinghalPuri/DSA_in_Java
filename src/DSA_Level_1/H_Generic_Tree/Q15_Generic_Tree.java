package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q15_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }
    }

    // ============ Construct Tree from Array ============
    public static Node construct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node root = null;
        Stack<Node> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                Node child = new Node(arr[i]);

                if (stk.isEmpty()) {
                    // This is the root node
                    root = child;
                } else {
                    // Add as child to the top of stack
                    Node parent = stk.peek();
                    parent.children.add(child);
                }

                stk.push(child);
            } else {
                // Delimiter - pop the stack
                stk.pop();
            }
        }

        return root;
    }

    // ============ Display Tree ============
    public static void display(Node root) {
        if (root == null) return;

        // Meeting Expectation: Print current node
        print(root);

        // Faith: Recursively display children
        for (Node child : root.children) {
            display(child);
        }
    }

    // Helper method to print a node
    public static void print(Node node) {
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
    }

    // ============ Alternative Display Methods ============

    // Display with indentation
    public static void displayWithIndent(Node root, String indent) {
        if (root == null) return;

        System.out.println(indent + root.data);
        for (Node child : root.children) {
            displayWithIndent(child, indent + "  ");
        }
    }

    // Display level-wise
    public static void displayLevelWise(Node root) {
        if (root == null) return;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.remove();
                System.out.print(node.data + " ");
                q.addAll(node.children);
            }
            System.out.println();
        }
    }

    // ============ Tree Information Methods ============

    // Get size of tree
    public static int getSize(Node root) {
        if (root == null) return 0;

        int size = 1;
        for (Node child : root.children) {
            size += getSize(child);
        }
        return size;
    }

    // Get height of tree
    public static int getHeight(Node root) {
        if (root == null) return -1;

        int height = -1;
        for (Node child : root.children) {
            height = Math.max(height, getHeight(child));
        }
        return height + 1;
    }

    // Get maximum value
    public static int getMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int max = root.data;
        for (Node child : root.children) {
            max = Math.max(max, getMax(child));
        }
        return max;
    }

    // Get minimum value
    public static int getMin(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int min = root.data;
        for (Node child : root.children) {
            min = Math.min(min, getMin(child));
        }
        return min;
    }

    // ============ Traversal Methods ============

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        for (Node child : root.children) {
            preorder(child);
        }
    }

    // Postorder traversal
    public static void postorder(Node root) {
        if (root == null) return;

        for (Node child : root.children) {
            postorder(child);
        }
        System.out.print(root.data + " ");
    }

    // Level order traversal
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.data + " ");
            q.addAll(node.children);
        }
        System.out.println();
    }

    // ============ Search Methods ============

    // Find if value exists
    public static boolean find(Node root, int data) {
        if (root == null) return false;

        if (root.data == data) return true;

        for (Node child : root.children) {
            if (find(child, data)) {
                return true;
            }
        }
        return false;
    }

    // Get node to root path
    public static ArrayList<Integer> nodeToRootPath(Node root, int data) {
        if (root == null) return new ArrayList<>();

        if (root.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }

        for (Node child : root.children) {
            ArrayList<Integer> path = nodeToRootPath(child, data);
            if (!path.isEmpty()) {
                path.add(root.data);
                return path;
            }
        }

        return new ArrayList<>();
    }

    // ============ Main Method for Testing ============
    public static void main(String[] args) {
        System.out.println("=== Generic Tree Operations ===\n");

        // Sample array representation of a generic tree
        // -1 indicates end of children for a node
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, -1, 40, 90, -1, 100, -1, -1, -1};

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // Construct the tree
        Node root = construct(arr);

        // ===== Test 1: Display Tree =====
        System.out.println("=".repeat(60));
        System.out.println("Test 1: Display Tree");
        System.out.println("\nTree Structure:");
        display(root);

        // ===== Test 2: Display with Indentation =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 2: Display with Indentation");
        displayWithIndent(root, "");

        // ===== Test 3: Level Wise Display =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 3: Level Wise Display");
        displayLevelWise(root);

        // ===== Test 4: Tree Information =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 4: Tree Information");
        System.out.println("Size: " + getSize(root));
        System.out.println("Height: " + getHeight(root));
        System.out.println("Maximum: " + getMax(root));
        System.out.println("Minimum: " + getMin(root));

        // ===== Test 5: Traversals =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 5: Traversals");

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.print("Level Order: ");
        levelOrder(root);

        // ===== Test 6: Search =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 6: Search Operations");

        int[] searchValues = {30, 60, 90, 200, 10};
        for (int val : searchValues) {
            boolean found = find(root, val);
            System.out.println("Find " + val + ": " + (found ? "Found ✅" : "Not Found ❌"));
        }

        // ===== Test 7: Node to Root Path =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 7: Node to Root Path");

        int[] pathValues = {60, 70, 90, 100, 10};
        for (int val : pathValues) {
            ArrayList<Integer> path = nodeToRootPath(root, val);
            System.out.println("Path from " + val + " to root: " + path);
        }

        // ===== Test 8: Edge Cases =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 8: Edge Cases");

        // Empty array
        System.out.println("Empty array:");
        int[] emptyArr = {};
        Node emptyRoot = construct(emptyArr);
        System.out.println("Root: " + (emptyRoot == null ? "null ✅" : "not null ❌"));

        // Single node
        System.out.println("\nSingle node:");
        int[] singleArr = {10, -1};
        Node singleRoot = construct(singleArr);
        System.out.println("Tree Structure:");
        display(singleRoot);
        System.out.println("Size: " + getSize(singleRoot));
        System.out.println("Height: " + getHeight(singleRoot));

        // ===== Test 9: Multiple Tree Construction =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 9: Multiple Tree Construction");

        int[][] testArrays = {
                {1, 2, -1, 3, -1, -1},
                {5, 10, 20, -1, -1, 15, -1, -1, 25, 30, -1, -1, -1},
                {100, 200, 300, -1, 400, -1, -1, 500, -1, -1, 600, -1, -1}
        };

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("\nTree " + (i + 1) + ":");
            System.out.println("Array: " + Arrays.toString(testArrays[i]));
            Node testRoot = construct(testArrays[i]);
            System.out.println("Display:");
            display(testRoot);
            System.out.println("Size: " + getSize(testRoot));
        }

        // ===== Test 10: Verify Correct Construction =====
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test 10: Verify Tree Construction");
        System.out.println("\nOriginal Tree:");
        display(root);

        // Reconstruct from same array
        Node reconstructed = construct(arr);
        System.out.println("\nReconstructed Tree:");
        display(reconstructed);

        // Compare sizes
        boolean sameSize = getSize(root) == getSize(reconstructed);
        System.out.println("\nSame size: " + (sameSize ? "✅ Yes" : "❌ No"));

        // Compare structure (simplified)
        boolean sameStructure = areTreesSimilar(root, reconstructed);
        System.out.println("Same structure: " + (sameStructure ? "✅ Yes" : "❌ No"));
    }

    // Helper method to check if two trees are similar
    public static boolean areTreesSimilar(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.children.size() != n2.children.size()) return false;

        for (int i = 0; i < n1.children.size(); i++) {
            if (!areTreesSimilar(n1.children.get(i), n2.children.get(i))) {
                return false;
            }
        }
        return true;
    }
}