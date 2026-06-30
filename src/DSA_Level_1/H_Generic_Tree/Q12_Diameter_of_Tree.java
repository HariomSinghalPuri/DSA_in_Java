package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q12_Diameter_of_Tree {

    static int maxDiameter = 0;

    // Method to calculate diameter of a generic tree
    public static int diameter(Node root) {
        if (root == null) {
            return -1;
        }

        int max1 = -1, max2 = -1;

        for (Node child : root.children) {
            int hc = diameter(child);

            // Update the two largest heights
            if (hc >= max1) {
                max2 = max1;
                max1 = hc;
            } else if (hc >= max2) {
                max2 = hc;
            }
        }

        // Calculate diameter passing through current node
        int dia = max1 + max2 + 2;
        maxDiameter = Math.max(dia, maxDiameter);

        // Return height of current node
        return max1 + 1;
    }

    // Alternative approach returning both height and diameter
    public static class DiaPair {
        int height;
        int diameter;

        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static DiaPair diameter2(Node root) {
        if (root == null) {
            return new DiaPair(-1, 0);
        }

        int max1 = -1, max2 = -1;
        int maxDiameter = 0;

        for (Node child : root.children) {
            DiaPair cp = diameter2(child);

            // Update maxDiameter
            maxDiameter = Math.max(maxDiameter, cp.diameter);

            // Update two largest heights
            if (cp.height >= max1) {
                max2 = max1;
                max1 = cp.height;
            } else if (cp.height >= max2) {
                max2 = cp.height;
            }
        }

        // Diameter passing through current node
        int diaThroughNode = max1 + max2 + 2;
        maxDiameter = Math.max(maxDiameter, diaThroughNode);

        // Return height and diameter
        return new DiaPair(max1 + 1, maxDiameter);
    }

    // Method to get diameter without using global variable
    public static int getDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        maxDiameter = 0;
        diameter(root);
        return maxDiameter;
    }

    // Method to find diameter using iterative approach
    public static int diameterIterative(Node root) {
        if (root == null) {
            return 0;
        }

        // Using stack for post-order traversal
        Stack<Node> stack = new Stack<>();
        Map<Node, Integer> heightMap = new HashMap<>();
        int maxDia = 0;

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();

            // Check if all children processed
            boolean allChildrenProcessed = true;
            for (Node child : node.children) {
                if (!heightMap.containsKey(child)) {
                    allChildrenProcessed = false;
                    stack.push(child);
                }
            }

            if (allChildrenProcessed) {
                stack.pop();

                // Find two largest heights
                int max1 = -1, max2 = -1;
                for (Node child : node.children) {
                    int height = heightMap.get(child);
                    if (height >= max1) {
                        max2 = max1;
                        max1 = height;
                    } else if (height >= max2) {
                        max2 = height;
                    }
                }

                // Calculate diameter through this node
                int dia = max1 + max2 + 2;
                maxDia = Math.max(maxDia, dia);

                // Store height
                heightMap.put(node, max1 + 1);
            }
        }

        return maxDia;
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

    // Method to calculate height of tree (for verification)
    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int maxHeight = -1;
        for (Node child : root.children) {
            maxHeight = Math.max(maxHeight, getHeight(child));
        }
        return maxHeight + 1;
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

        // Adding deeper nodes to create larger diameter
        Node child10 = new Node(110);
        Node child11 = new Node(120);
        child4.children.add(child10);
        child4.children.add(child11);

        Node child12 = new Node(130);
        Node child13 = new Node(140);
        child10.children.add(child12);
        child10.children.add(child13);

        return root;
    }

    // Helper method to build a tree with known diameter
    public static Node buildTreeWithKnownDiameter() {
        Node root = new Node(1);

        // Creating a chain: 1 -> 2 -> 3 -> 4 -> 5
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);

        // Creating another branch for diameter: 6 -> 7 -> 8
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        root.children.add(n6);
        n6.children.add(n7);
        n7.children.add(n8);

        // Diameter should be between 5 and 8: 5 -> 4 -> 3 -> 2 -> 1 -> 6 -> 7 -> 8
        // Distance = 7 edges

        return root;
    }

    // Helper method to build a single node tree
    public static Node buildSingleNodeTree() {
        return new Node(10);
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Diameter of Generic Tree ===\n");

        // Test 1: Sample tree
        System.out.println("Test 1: Sample Tree");
        Node root = buildSampleTree();
        System.out.println("Tree Structure:");
        display(root);
        System.out.println("Height: " + getHeight(root));

        // Reset maxDiameter
        maxDiameter = 0;
        int height = diameter(root);
        System.out.println("\nUsing Global Variable Approach:");
        System.out.println("Height: " + height);
        System.out.println("Diameter: " + maxDiameter);

        // Test 2: Using Pair Approach
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 2: Using Pair Approach");
        Node root2 = buildSampleTree();
        DiaPair result = diameter2(root2);
        System.out.println("Height: " + result.height);
        System.out.println("Diameter: " + result.diameter);

        // Test 3: Tree with known diameter
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 3: Tree with Known Diameter");
        Node root3 = buildTreeWithKnownDiameter();
        System.out.println("Tree Structure:");
        display(root3);

        maxDiameter = 0;
        diameter(root3);
        System.out.println("\nDiameter: " + maxDiameter);
        System.out.println("Expected Diameter: 7");

        // Test 4: Iterative approach
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 4: Iterative Approach");
        Node root4 = buildSampleTree();
        int diaIterative = diameterIterative(root4);
        System.out.println("Diameter (Iterative): " + diaIterative);

        // Test 5: Single node tree
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 5: Single Node Tree");
        Node root5 = buildSingleNodeTree();
        System.out.println("Tree Structure:");
        display(root5);

        maxDiameter = 0;
        diameter(root5);
        System.out.println("\nHeight: " + getHeight(root5));
        System.out.println("Diameter: " + maxDiameter);

        // Test 6: Using getDiameter method
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 6: Using getDiameter Method");
        Node root6 = buildSampleTree();
        int dia = getDiameter(root6);
        System.out.println("Diameter: " + dia);

        // Test 7: Compare all approaches
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 7: Comparison of All Approaches");
        Node root7 = buildSampleTree();

        maxDiameter = 0;
        diameter(root7);
        int dia1 = maxDiameter;

        DiaPair result2 = diameter2(root7);
        int dia2 = result2.diameter;

        int dia3 = diameterIterative(root7);

        System.out.println("Approach 1 (Global Variable): " + dia1);
        System.out.println("Approach 2 (Pair Class): " + dia2);
        System.out.println("Approach 3 (Iterative): " + dia3);

        if (dia1 == dia2 && dia2 == dia3) {
            System.out.println("✅ All approaches give the same result!");
        } else {
            System.out.println("❌ Results don't match!");
        }
    }
}