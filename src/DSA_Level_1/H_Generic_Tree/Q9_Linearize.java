package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q9_Linearize {

    // Method to get the last node (tail) of a tree (leftmost deepest node)
    public static Node getLastNode(Node curr) {
        if (curr == null) {
            return null;
        }

        while (curr.children.size() > 0) {
            curr = curr.children.get(0);
        }
        return curr;
    }

    // Optimized linearization that returns the tail
    public static Node linearizeOpt(Node root) {
        if (root == null) {
            return null;
        }

        if (root.children.size() == 0) {
            return root;
        }

        // Get tail of last child
        Node lastTreeTail = linearizeOpt(root.children.get(root.children.size() - 1));

        // Process children from right to left
        while (root.children.size() > 1) {
            // Remove the last child
            Node lastTreeHead = root.children.remove(root.children.size() - 1);

            // Get tail of the new last child
            Node secondLastTreeTail = linearizeOpt(root.children.get(root.children.size() - 1));

            // Attach the removed child to the tail of the second last child
            secondLastTreeTail.children.add(lastTreeHead);
        }

        return lastTreeTail;
    }

    // Basic linearization using faith and expectation
    public static void linearize(Node root) {
        if (root == null) {
            return;
        }

        // Faith: Linearize all children recursively
        for (Node child : root.children) {
            linearize(child);
        }

        // Meeting expectation: Merge children from right to left
        while (root.children.size() > 1) {
            // Remove the last child
            Node lastTreeRoot = root.children.remove(root.children.size() - 1);

            // Get the second last child
            Node secondLastTreeRoot = root.children.get(root.children.size() - 1);

            // Get the tail of the second last child's linearized tree
            Node secondLastTreeTail = getLastNode(secondLastTreeRoot);

            // Attach the removed tree to the tail
            secondLastTreeTail.children.add(lastTreeRoot);
        }
    }

    // Alternative linearization using iterative approach
    public static void linearizeIterative(Node root) {
        if (root == null) {
            return;
        }

        // Process each node in preorder
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            // Add children to stack in reverse order
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }

            // Merge children
            while (node.children.size() > 1) {
                Node last = node.children.remove(node.children.size() - 1);
                Node secondLast = node.children.get(node.children.size() - 1);
                Node tail = getLastNode(secondLast);
                tail.children.add(last);
            }
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

    // Method to check if tree is linearized (each node has at most one child)
    public static boolean isLinearized(Node root) {
        if (root == null) {
            return true;
        }

        if (root.children.size() > 1) {
            return false;
        }

        for (Node child : root.children) {
            if (!isLinearized(child)) {
                return false;
            }
        }

        return true;
    }

    // Method to get tree height (for verification)
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }

        int maxHeight = 0;
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

        // Adding deeper nodes
        Node child10 = new Node(110);
        Node child11 = new Node(120);
        child4.children.add(child10);
        child4.children.add(child11);

        return root;
    }

    // Helper method to build a simple tree
    public static Node buildSimpleTree() {
        Node root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        Node child4 = new Node(5);
        Node child5 = new Node(6);
        child1.children.add(child4);
        child1.children.add(child5);

        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Linearize Generic Tree ===\n");

        // Test 1: Basic linearization
        System.out.println("Test 1: Basic Linearization");
        Node root = buildSampleTree();
        System.out.println("Original Tree:");
        display(root);
        System.out.println("Height: " + getHeight(root));
        System.out.println("Is Linearized? " + isLinearized(root));

        System.out.println("\nLinearizing using basic approach...");
        linearize(root);

        System.out.println("\nLinearized Tree:");
        display(root);
        System.out.println("Height: " + getHeight(root));
        System.out.println("Is Linearized? " + isLinearized(root));

        // Test 2: Optimized linearization
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 2: Optimized Linearization");
        Node root2 = buildSimpleTree();
        System.out.println("Original Tree:");
        display(root2);
        System.out.println("Height: " + getHeight(root2));

        System.out.println("\nLinearizing using optimized approach...");
        Node tail = linearizeOpt(root2);

        System.out.println("\nLinearized Tree:");
        display(root2);
        System.out.println("Height: " + getHeight(root2));
        System.out.println("Tail node data: " + (tail != null ? tail.data : "null"));
        System.out.println("Is Linearized? " + isLinearized(root2));

        // Test 3: Iterative linearization
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 3: Iterative Linearization");
        Node root3 = buildSampleTree();
        System.out.println("Original Tree:");
        display(root3);

        System.out.println("\nLinearizing using iterative approach...");
        linearizeIterative(root3);

        System.out.println("\nLinearized Tree:");
        display(root3);
        System.out.println("Is Linearized? " + isLinearized(root3));

        // Test 4: Single node tree
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nTest 4: Single Node Tree");
        Node root4 = new Node(10);
        System.out.println("Original Tree:");
        display(root4);

        linearize(root4);
        System.out.println("\nAfter linearization:");
        display(root4);
        System.out.println("Is Linearized? " + isLinearized(root4));
    }
}