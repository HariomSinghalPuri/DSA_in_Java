package Core_Interfaces.List.LinkedList;

import java.util.LinkedList;


public class LinkedListAsStack {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

// Push (add at front)
        stack.push(10);
        stack.push(20);
        stack.push(22);
// Pop (remove from front)
        int top = stack.pop(); // 20

        System.out.println(stack);
    }
}
