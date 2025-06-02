package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q8_GCD_and_LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your 1st Digit: ");
        int n1 = sc.nextInt();
        System.out.println("Enter Your 2nd Digit: ");
        int n2 = sc.nextInt();

        int on1 = n1;
        int on2 = n2;

        while(n1 % n2 != 0){
            int rem = n1 % n2;
            n1 = n2 ;
            n2 = rem;
        }
        int gcd = n2 ;
        int lcm = (on1 * on2) / gcd;

        System.out.println("GCD of Two Number is: " + gcd);
        System.out.println("LCM of Two Number is: " + lcm);
    }
}
