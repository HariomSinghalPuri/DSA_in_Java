package Core_Interfaces.Queue.BlockingQueue.PriorityBlockingQueue.DelayDeque;

import java.util.concurrent.*;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Delayed {
    private final String name;
    private final long delayTime;  // in nanoseconds
    private final long startTime;

    public DelayedTask(String name, long delay, TimeUnit unit) {
        this.name = name;
        this.delayTime = unit.toNanos(delay);
        this.startTime = System.nanoTime() + this.delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.nanoTime();
        return unit.convert(remaining, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), o.getDelay(TimeUnit.NANOSECONDS));
    }

    @Override
    public String toString() {
        return name;
    }
}

public class DelayQueue_Demo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        queue.put(new DelayedTask("Task-1", 3, TimeUnit.SECONDS));
        queue.put(new DelayedTask("Task-2", 1, TimeUnit.SECONDS));
        queue.put(new DelayedTask("Task-3", 5, TimeUnit.SECONDS));

        System.out.println("Waiting for tasks to expire...");

        while (!queue.isEmpty()) {
            DelayedTask task = queue.take(); // Blocks until the delay has expired
            System.out.println("Executed: " + task + " at " + System.currentTimeMillis() / 1000);
        }
    }
}