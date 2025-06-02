package Core_Interfaces.Queue.Deque.ArrayDeque;

import java.util.*;

public class ArrayDeque_Demo {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Add elements to both ends
        deque.add("Java");
        deque.addFirst("Python");
        deque.addLast("C++");

        System.out.println("Deque after additions: " + deque);

        // Access elements without removing
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Remove elements from both ends
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());

        System.out.println("Deque after removals: " + deque);

        // Stack-like behavior
        deque.push("HTML");
        deque.push("CSS");
        System.out.println("After push: " + deque);

        System.out.println("Pop: " + deque.pop());
        System.out.println("Deque after pop: " + deque);
    }
}
