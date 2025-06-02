package Core_Interfaces.Queue.BlockingQueue;

import java.util.concurrent.*;

public class BlockingQueue_Demo {
    public static void main(String[] args) {
        // Create a bounded blocking queue with capacity 3
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        try {
            // Add elements using put (waits if full)
            queue.put("Apple");
            queue.put("Banana");
            queue.put("Cherry");
            System.out.println("Queue after put(): " + queue);

            // Try adding one more element (will block or throw exception)
            boolean success = queue.offer("Date", 2, TimeUnit.SECONDS);
            System.out.println("Was able to add 'Date'?: " + success);

            // Access head without removing
            System.out.println("Peek: " + queue.peek());

            // Remove elements using take() (waits if empty)
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());
            System.out.println("Removed: " + queue.take());

            // Now queue is empty, next take will wait
            System.out.println("Trying to take one more element...");
            String fruit = queue.poll(2, TimeUnit.SECONDS);
            System.out.println("Element fetched after wait: " + fruit);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
