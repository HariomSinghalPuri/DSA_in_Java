package DSA_Level_1.F_Stack_And_Queue.A_StackAndQueue_Classes;


public class StackUnderflowException extends Exception{

    public StackUnderflowException() {
        super("Stack Underflow occurred");
    }

    public StackUnderflowException(String error) {
        super(error);
    }


}