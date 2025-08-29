package DSA_Level_1.F_Stack_And_Queue.E_Stack_Queue_Interconversions;

import java.util.Stack;

public class Q2_Stack_to_Queue {

    // Push Efficient Implementation
    public static class PushEfficientStackToQueueAdapter {
        Stack<Integer> mainS;

        public PushEfficientStackToQueueAdapter() {
            mainS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if (mainS.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }

            Stack<Integer> helperS = new Stack<>();
            int count = mainS.size() - 1;
            for (int i = 1; i <= count; i++) {
                helperS.push(mainS.pop());
            }

            int val = mainS.pop();
            while (!helperS.isEmpty()) {
                mainS.push(helperS.pop());
            }
            return val;
        }

        int peek() {
            if (mainS.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }

            Stack<Integer> helperS = new Stack<>();
            int count = mainS.size() - 1;
            for (int i = 1; i <= count; i++) {
                helperS.push(mainS.pop());
            }

            int val = mainS.peek();
            while (!helperS.isEmpty()) {
                mainS.push(helperS.pop());
            }
            return val;
        }
    }

    // Pop Efficient Implementation
    public static class PopEfficientStackToQueueAdapter {
        Stack<Integer> mainS;

        public PopEfficientStackToQueueAdapter() {
            mainS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            Stack<Integer> helperS = new Stack<>();
            while (!mainS.isEmpty()) {
                helperS.push(mainS.pop());
            }

            mainS.push(val);
            while (!helperS.isEmpty()) {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (mainS.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }

            return mainS.pop();
        }

        int peek() {
            if (mainS.isEmpty()) {
                System.out.println("Queue underflow");
                return -1;
            }

            return mainS.peek();
        }
    }

    // Test both implementations
    public static void main(String[] args) {
        System.out.println("Testing Push Efficient Implementation:");
        testPushEfficient();

        System.out.println("\nTesting Pop Efficient Implementation:");
        testPopEfficient();
    }

    private static void testPushEfficient() {
        PushEfficientStackToQueueAdapter queue = new PushEfficientStackToQueueAdapter();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Peek: " + queue.peek()); // Should be 10
        System.out.println("Remove: " + queue.remove()); // Should be 10
        System.out.println("Peek: " + queue.peek()); // Should be 20
        System.out.println("Size: " + queue.size()); // Should be 2

        queue.add(40);
        System.out.println("Remove: " + queue.remove()); // Should be 20
        System.out.println("Remove: " + queue.remove()); // Should be 30
        System.out.println("Remove: " + queue.remove()); // Should be 40
        System.out.println("Remove: " + queue.remove()); // Should be -1 (underflow)
    }

    private static void testPopEfficient() {
        PopEfficientStackToQueueAdapter queue = new PopEfficientStackToQueueAdapter();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Peek: " + queue.peek()); // Should be 10
        System.out.println("Remove: " + queue.remove()); // Should be 10
        System.out.println("Peek: " + queue.peek()); // Should be 20
        System.out.println("Size: " + queue.size()); // Should be 2

        queue.add(40);
        System.out.println("Remove: " + queue.remove()); // Should be 20
        System.out.println("Remove: " + queue.remove()); // Should be 30
        System.out.println("Remove: " + queue.remove()); // Should be 40
        System.out.println("Remove: " + queue.remove()); // Should be -1 (underflow)
    }
}