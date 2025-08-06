package DSA_Level_1.F_Stack_And_Queue.A_StackAndQueue_Classes;

public class Q1_Normal_Stack {
    private int[] data;
    private int top;

    public Q1_Normal_Stack(int maxSize) {
        data = new int[maxSize];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void push(int val) {
        if (top == data.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        data[++top] = val;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return data[top];
    }

    // Main method to test the stack
    public static void main(String[] args) {
        Q1_Normal_Stack stack = new Q1_Normal_Stack(5);

        System.out.println("Testing Normal Stack:");
        System.out.println("---------------------");

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack after pushing 5 elements:");
        stack.display(); // Output: 50 40 30 20 10

        System.out.println("Top element: " + stack.peek()); // Output: 50

        stack.push(60); // Output: Stack overflow

        System.out.println("Popped element: " + stack.pop()); // Output: 50
        System.out.println("Popped element: " + stack.pop()); // Output: 40

        System.out.println("Stack after popping 2 elements:");
        stack.display(); // Output: 30 20 10

        System.out.println("Size of stack: " + stack.size()); // Output: 3

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Stack after popping all elements:");
        stack.display(); // Output: (empty line)

        stack.pop(); // Output: Stack underflow
        System.out.println("Top element of empty stack: " + stack.peek()); // Output: Stack underflow, -1
    }
}