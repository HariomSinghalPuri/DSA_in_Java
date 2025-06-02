package Core_Interfaces.Queue.BlockingQueue.LinkedBlockingQueue.ArrayBlockingQueue.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue_Demo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // Producer thread
        new Thread(() -> {
            try {
                System.out.println("Producer: Waiting to put...");
                queue.put("Data-1");
                System.out.println("Producer: Put completed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Delay to demonstrate blocking behavior
                System.out.println("Consumer: Waiting to take...");
                String data = queue.take();
                System.out.println("Consumer: Took - " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}