package DSA_Level_1.A_Getting_Started;

import java.util.*;

public class Q9_Prime_Factorization{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Your Number : ");
        int n = scn.nextInt();

        // Approach 1
//     for(int factor = 2; factor <= n; factor++)
//     {
//         while(n % factor == 0)
//         {
//             System.out.print(factor + " ");
//             n = n / factor;
//         }
//     }

        // Approach 2: Optimization
        for(int factor = 2; factor * factor <= n; factor++)
        {
            while(n % factor == 0)
            {
                System.out.print(factor + " ");
                n = n / factor;
            }
        }

        // Prime Factor greater than root n, there can be only one such prime factor
        if(n != 1) System.out.print(n);
    }
}