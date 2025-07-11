package DSA_Level_1.E_Recursion.A_Basic_Recursion;

import java.util.*;

public class Q2_Print_Increasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n);
    }

    public static void printIncreasing(int n){
        // Base Case
        if(n == 0) return;

        // 1st statement -> Faith
        printIncreasing(n-1);

        // 2nd statement -> Work (Meeting Expectation with Faith)
        System.out.println(n);
    }

}
