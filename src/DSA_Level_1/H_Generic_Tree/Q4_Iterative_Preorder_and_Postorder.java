package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Q4_Iterative_Preorder_and_Postorder {

    // Pair class for stack operations
    static class Pair {
        Node node;
        int state; // -1 = pre-order, 0 to children.size()-1 = processing children, children.size() = post-order

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void iterativePreandPostOrder(Node root) {
        if (root == null) {
            return;
        }

        Stack<Pair> stk = new Stack<>();

        Pair rootPair = new Pair(root, -1);
        stk.push(rootPair);

        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();

        while (stk.size() > 0) {
            Pair parent = stk.peek();

            if (parent.state == -1) {
                // Pre-order: Add node when first encountered
                preorder.add(parent.node.data);
                parent.state++;

            } else if (parent.state == parent.node.children.size()) {
                // Post-order: Add node when all children are processed
                postorder.add(parent.node.data);
                stk.pop();

            } else {
                // Process child
                Pair child = new Pair(parent.node.children.get(parent.state), -1);
                stk.push(child);
                parent.state++;
            }
        }

        // Print preorder
        for (Integer i : preorder) {
            System.out.print(i + " ");
        }

        System.out.println();

        // Print postorder
        for (Integer i : postorder) {
            System.out.print(i + " ");
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

    // Main method for testing
    public static void main(String[] args) {
        Node root = buildSampleTree();

        System.out.println("=== Iterative Preorder and Postorder ===");
        iterativePreandPostOrder(root);
    }
}