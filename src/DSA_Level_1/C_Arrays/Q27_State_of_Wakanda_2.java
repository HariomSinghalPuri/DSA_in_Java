package DSA_Level_1.C_Arrays;

import java.util.*;

public class Q27_State_of_Wakanda_2 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        for(int gap = 0; gap < n; gap++)
        {
            // gap = col - row
            for(int row = 0, col = gap; col < n; row++, col++)
            { System.out.println(arr[row][col]); }
        }
    }

}
