package DSA_Level_1.C_Arrays.D_Searching_and_Sorting;

// Linear_Search

import java.util.*;

public class Q2_Linear_Search {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<=n-1; i++)
        {
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();

        int ans = -1;
        for(int i=0; i<n; i++)
        {
            if(arr[i] == d)
            {
                ans = i;
                break;
            }
        }
        System.out.print(ans);

    }

}