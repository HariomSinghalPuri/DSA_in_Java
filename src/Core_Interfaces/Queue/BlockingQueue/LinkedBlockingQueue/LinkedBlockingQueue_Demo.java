package Core_Interfaces.Queue.BlockingQueue.LinkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueue_Demo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3); // bounded queue

        // Add elements
        queue.put("One");
        queue.put("Two");
        queue.offer("Three");

        System.out.println("Queue after additions: " + queue);

        // Peek without removing
        System.out.println("Peek: " + queue.peek());

        // Poll and take
        System.out.println("Poll: " + queue.poll());
        System.out.println("Take: " + queue.take());

        // Try blocking put (will wait if full)
        queue.put("Four");
        System.out.println("After put: " + queue);

        // Check status
        System.out.println("Contains 'Four': " + queue.contains("Four"));
        System.out.println("Is Empty? " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
    }
}

