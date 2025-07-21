package DSA_Level_1.E_Recursion.B_Array_Recursion;

import java.util.*;

public class Q5_Last_Index {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();

        int x = scn.nextInt();
        int ans = lastIndex(arr, arr.length - 1, x);
        System.out.println(ans);
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx < 0) return -1;
        if(arr[idx] == x) return idx;

        int val = lastIndex(arr, idx - 1, x);
        return val;
    }

}