package Core_Interfaces.Queue.PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueue_Demo {
    public static void main(String[] args) {
        // Create a priority queue of integers (natural ordering)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("Initial PriorityQueue: " + pq);

        // Access head of the queue
        System.out.println("Peek: " + pq.peek()); // Should return 10

        // Remove elements in priority order
        System.out.println("Poll: " + pq.poll()); // 10
        System.out.println("Poll: " + pq.poll()); // 20

        System.out.println("Queue after polling: " + pq);

        // Add more elements
        pq.offer(5);
        pq.offer(35);

        System.out.println("Final PriorityQueue: " + pq);

        // Size and check
        System.out.println("Size: " + pq.size());
        System.out.println("Is Empty? " + pq.isEmpty());
    }
}
