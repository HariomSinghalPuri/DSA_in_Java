package DSA_Level_1.E_Recursion.E_Advanced_Problems;

import java.util.*;

public class Q4_Target_Sum_Subsets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();
        int target = scn.nextInt();

        printTargetSumSubsets(arr, 0, "", 0, target);
    }

    public static void printTargetSumSubsets(int[] arr, int idx, String output, int currSum, int targetSum) {
        if (idx == arr.length)
        {
            if(currSum == targetSum) {
                System.out.println(output + ".");
            }
            return;
        }

        // Pruning Step
        if(currSum > targetSum) return;

        // First Character
        int ele = arr[idx];

        // 1. Integer Present in Subset
        printTargetSumSubsets(arr, idx + 1, output + ele + ", ", currSum + ele, targetSum);

        // 2. Integer Not Present in Subset
        printTargetSumSubsets(arr, idx + 1, output, currSum, targetSum);
    }

}