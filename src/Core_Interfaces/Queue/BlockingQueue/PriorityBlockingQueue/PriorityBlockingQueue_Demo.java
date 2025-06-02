package Core_Interfaces.Queue.BlockingQueue.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueue_Demo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // Add elements (unordered)
        queue.put(50);
        queue.put(10);
        queue.put(30);

        System.out.println("Queue after insertion: " + queue);

        // Peek at the highest-priority (lowest) element
        System.out.println("Peek: " + queue.peek()); // Should return 10

        // Remove elements in priority order
        System.out.println("Take: " + queue.take()); // 10
        System.out.println("Poll: " + queue.poll()); // 30
        System.out.println("Take: " + queue.take()); // 50

        // Check if empty
        System.out.println("Is Empty? " + queue.isEmpty());

        // Add again
        queue.put(20);
        queue.put(5);
        queue.put(40);

        // Display current size
        System.out.println("Size: " + queue.size());
    }
}