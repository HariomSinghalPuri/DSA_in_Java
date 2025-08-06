package DSA_Level_1.F_Stack_And_Queue.A_StackAndQueue_Classes;


public class StackOverflowException extends Exception{
    public StackOverflowException() {
        super("Stack Overflow occurred");
    }

    public StackOverflowException(String error) {
        super(error);
    }

}
