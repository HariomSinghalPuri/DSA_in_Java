package Core_Interfaces.Queue.Deque;

import java.util.*;

public class Deque_Demo {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Adding elements to both ends
        deque.addFirst("Front-1");
        deque.addLast("Rear-1");
        deque.offerFirst("Front-2");
        deque.offerLast("Rear-2");

        System.out.println("Deque after additions: " + deque);

        // Accessing elements from both ends
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Removing elements from both ends
        System.out.println("Removed First: " + deque.pollFirst());
        System.out.println("Removed Last: " + deque.pollLast());

        // Displaying the remaining deque
        System.out.println("Deque after removals: " + deque);

        // Push and pop (stack behavior)
        deque.push("Pushed");
        System.out.println("After push: " + deque);
        System.out.println("Popped: " + deque.pop());
    }
}
