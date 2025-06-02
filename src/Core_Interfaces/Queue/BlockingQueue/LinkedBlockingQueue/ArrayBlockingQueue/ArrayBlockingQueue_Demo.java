package Core_Interfaces.Queue.BlockingQueue.LinkedBlockingQueue.ArrayBlockingQueue;

import java.util.concurrent.*;

public class ArrayBlockingQueue_Demo {
    public static void main(String[] args) {
        // Create a bounded queue with capacity 3 and fairness policy set to true
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3, true);

        try {
            // Adding elements to the queue
            queue.put("Java");
            queue.put("Python");
            queue.put("C++");
            System.out.println("Queue after put(): " + queue);

            // Try to add another element (will wait and fail after timeout)
            boolean offered = queue.offer("Go", 2, TimeUnit.SECONDS);
            System.out.println("Was 'Go' added? " + offered);

            // Access the head of the queue
            System.out.println("Head (peek): " + queue.peek());

            // Removing elements from the queue
            System.out.println("Removed (take): " + queue.take());
            System.out.println("Removed (poll): " + queue.poll(2, TimeUnit.SECONDS));

            // Display the current state of the queue
            System.out.println("Current Queue: " + queue);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
