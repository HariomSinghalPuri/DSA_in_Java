package DSA_Level_1.C_Arrays.A_Arrays_and_Matrix_Operation;

// Inverse_Array

import java.io.*;

public class Q4_Inverse_Array {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a){
        // write your code here
        int[] ans = new int[a.length];

        for(int idx=0; idx<a.length; idx++)
        {
            int val = a[idx];
            ans[val] = idx;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }

}
