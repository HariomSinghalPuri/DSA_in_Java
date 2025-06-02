package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q3_Fibonacci_Till_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Digits upto you want to Print : ");
        int num = sc.nextInt();
        int a = 0;
        int b = 1;
        for(int i = 0; i<=num;i++){
            System.out.println(a);
            int c = a+b;
            a=b;
            b=c;
        }
    }
}
