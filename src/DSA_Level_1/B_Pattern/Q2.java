package DSA_Level_1.B_Pattern;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Your Number: ");
        int n = scn.nextInt();

        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print("*	");
            }
            System.out.println();
        }
    }
}
