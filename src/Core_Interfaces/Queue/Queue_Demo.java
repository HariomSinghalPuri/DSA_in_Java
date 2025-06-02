package Core_Interfaces.Queue;

import java.util.*;

public class Queue_Demo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("A");
        queue.offer("B");
        queue.add("C");

        // Displaying the queue
        System.out.println("Queue: " + queue);

        // Accessing the head of the queue
        System.out.println("Peek (head element): " + queue.peek());

        // Removing elements
        System.out.println("Removed (poll): " + queue.poll());
        System.out.println("Removed (remove): " + queue.remove());

        // Displaying the final queue
        System.out.println("Queue after removals: " + queue);

        // Checking size
        System.out.println("Size: " + queue.size());

        // Checking if empty
        System.out.println("Is empty?: " + queue.isEmpty());

        // Contains
        System.out.println("Contains 'A'?: " + queue.contains("A"));
        System.out.println("Contains 'C'?: " + queue.contains("C"));
    }
}
