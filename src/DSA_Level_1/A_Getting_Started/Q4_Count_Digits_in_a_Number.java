package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q4_Count_Digits_in_a_Number {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        int digit = 0;
        while(num!=0){
            num = num/10;
            digit++;
        }
        System.out.println(digit);
    }
}
