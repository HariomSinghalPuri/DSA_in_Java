package DSA_Level_1.H_Generic_Tree;

import java.util.*;

public class Node {
    public int data;
    public ArrayList<Node> children;

    public Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}