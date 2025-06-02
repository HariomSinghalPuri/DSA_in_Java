package Core_Interfaces.List.LinkedList;
import java.util.LinkedList;


public class LinkedListAsQueue {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

    // Enqueue (add at end)
        queue.offer(10);
        queue.offer(20);
        queue.offer(252);

    // Dequeue (remove from front)
        int front = queue.poll(); // 10
        System.out.println(queue);

    }
}
