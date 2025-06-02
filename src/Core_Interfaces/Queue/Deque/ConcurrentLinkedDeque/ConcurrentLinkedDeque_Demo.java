package Core_Interfaces.Queue.Deque.ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDeque_Demo {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        // Adding elements at both ends
        deque.addFirst("Front-1");
        deque.addLast("Rear-1");
        deque.offerFirst("Front-2");
        deque.offerLast("Rear-2");

        System.out.println("Deque after additions: " + deque);

        // Accessing elements from both ends
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Removing elements from both ends
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());

        System.out.println("Deque after removals: " + deque);

        // Stack-like operations
        deque.push("Pushed");
        System.out.println("After push: " + deque);
        System.out.println("Pop: " + deque.pop());

        // Check presence and size
        System.out.println("Contains 'Rear-1': " + deque.contains("Rear-1"));
        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Size: " + deque.size());
    }
}

