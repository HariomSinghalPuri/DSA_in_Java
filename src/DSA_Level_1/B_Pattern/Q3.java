package DSA_Level_1.B_Pattern;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        System.out.println("Enter Your Number :");
        int n = scn.nextInt();

        int stars = 1;
        int spaces = n - 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= spaces;j++){
                System.out.print("	");
            }
            for(int j = 1; j <= stars;j++){
                System.out.print("*	");
            }

            System.out.println();
            stars++;
            spaces--;
        }

    }
}