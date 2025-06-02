package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q6_Reverse_a_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num>0){
            int dig = num % 10;
            num = num/10;
            System.out.println(dig);
        }
    }
}
