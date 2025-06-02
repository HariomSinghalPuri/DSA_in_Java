package DSA_Level_1.B_Pattern;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Your Number: ");
        int n = scn.nextInt();

        int stars = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= stars; j++){
                System.out.print("*	");
            }
            System.out.println();
            stars++;
        }
    }
}
