package DSA_Level_1.C_Arrays.A_Arrays_and_Matrix_Operation;

import java.util.*;

public class Q10_Span_of_Array {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<=n-1; i++)
        {
            arr[i] = scn.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            int curr_val = arr[i];
            if(curr_val < min)
                min = curr_val;
            if(curr_val > max)
                max = curr_val;
        }

        int span = max - min;
        System.out.print(span);
    }

}
