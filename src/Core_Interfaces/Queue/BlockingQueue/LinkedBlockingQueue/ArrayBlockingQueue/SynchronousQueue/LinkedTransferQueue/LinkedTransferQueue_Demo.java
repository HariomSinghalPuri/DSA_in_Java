package Core_Interfaces.Queue.BlockingQueue.LinkedBlockingQueue.ArrayBlockingQueue.SynchronousQueue.LinkedTransferQueue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueue_Demo {
    public static void main(String[] args) {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        // Producer Thread using transfer()
        new Thread(() -> {
            try {
                System.out.println("Producer: Transferring item...");
                queue.transfer("Message-1");
                System.out.println("Producer: Transfer complete.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer Thread using take()
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Delay to demonstrate blocking behavior
                String item = queue.take();
                System.out.println("Consumer: Received - " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}