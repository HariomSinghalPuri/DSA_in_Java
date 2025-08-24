package DSA_Level_1.F_Stack_And_Queue.E_Stack_Queue_Interconversions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q1_Queue_to_Stack {

    // Push Efficient Approach
    public static class PushEfficientQueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public PushEfficientQueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        public int size() {
            return mainQ.size();
        }

        public void push(int val) {
            mainQ.add(val);
        }

        public int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            // Move all elements except the last one to helperQ
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            // Get the last element (which should be removed)
            int val = mainQ.remove();

            // Swap the queues
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            return val;
        }

        public int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            // Move all elements except the last one to helperQ
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            // Get the last element (but don't remove it from queue)
            int val = mainQ.remove();
            helperQ.add(val);

            // Swap the queues
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            return val;
        }
    }

    // Pop Efficient Approach
    public static class PopEfficientQueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public PopEfficientQueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        public int size() {
            return mainQ.size();
        }

        public void push(int val) {
            // Move all elements to helperQ
            while (mainQ.size() > 0) {
                helperQ.add(mainQ.remove());
            }

            // Add the new element to mainQ
            mainQ.add(val);

            // Move all elements back from helperQ to mainQ
            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
        }

        public int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return mainQ.remove();
        }

        public int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return mainQ.peek();
        }
    }

    // Test the implementations
    public static void main(String[] args) {
        System.out.println("Testing Push Efficient Approach:");
        PushEfficientQueueToStackAdapter stack1 = new PushEfficientQueueToStackAdapter();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        System.out.println("Top: " + stack1.top()); // Should be 30
        System.out.println("Pop: " + stack1.pop()); // Should be 30
        System.out.println("Top: " + stack1.top()); // Should be 20

        System.out.println("\nTesting Pop Efficient Approach:");
        PopEfficientQueueToStackAdapter stack2 = new PopEfficientQueueToStackAdapter();
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        System.out.println("Top: " + stack2.top()); // Should be 30
        System.out.println("Pop: " + stack2.pop()); // Should be 30
        System.out.println("Top: " + stack2.top()); // Should be 20
    }
}