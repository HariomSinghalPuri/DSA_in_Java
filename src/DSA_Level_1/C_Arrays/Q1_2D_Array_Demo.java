package DSA_Level_1.C_Arrays;

import java.util.*;


 // 2D Array Demo


public class Q1_2D_Array_Demo {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        // Declaration & Initialization
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        // INPUT
        for(int rows = 0; rows <= n-1; rows++)
        {
            for(int cols = 0; cols <= m-1; cols++)
            {
                arr[rows][cols] = scn.nextInt();
            }
        }

        // OUTPUT
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
