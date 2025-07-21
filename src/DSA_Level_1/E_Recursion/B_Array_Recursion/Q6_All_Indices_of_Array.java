package DSA_Level_1.E_Recursion.B_Array_Recursion;

import java.io.*;

public class Q6_All_Indices_of_Array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int counter) {
        // Base Case
        if(idx == arr.length)
        {
            int[] freq = new int[counter];
            return freq;
        }

        // 1. Update Counter if arr[idx] = x
        if(arr[idx] == x) counter++;

        // 2. Faith
        int[] freq = allIndices(arr, x, idx + 1, counter);

        //3. Update Values in freq array
        if(arr[idx] == x)
            freq[counter - 1] = idx;

        return freq;
    }

}