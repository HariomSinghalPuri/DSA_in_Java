package Core_Interfaces.Queue.Deque.LinkedBlockingDeque;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDeque_Demo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(5);

        // Add elements from both ends
        deque.putFirst("First-1");
        deque.putLast("Last-1");
        deque.offerFirst("First-2");
        deque.offerLast("Last-2");

        System.out.println("Deque after additions: " + deque);

        // Peek elements
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Remove elements
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());

        // Push & Pop (stack behavior)
        deque.push("Stack-Top");
        System.out.println("After push: " + deque);
        System.out.println("Pop: " + deque.pop());

        // Blocking put/take
        deque.put("BlockingElement");
        System.out.println("After blocking put: " + deque);
        System.out.println("Take: " + deque.take());

        // Status checks
        System.out.println("Contains 'Last-1': " + deque.contains("Last-1"));
        System.out.println("Is Empty? " + deque.isEmpty());
        System.out.println("Size: " + deque.size());
    }
}
