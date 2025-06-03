package DSA_Level_1.A_Getting_Started;

import java.util.*;

public class Q11_Benjamin_Bulbs{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i = 1; i * i <= n; i++){
            System.out.println(i*i);
        }
    }
}
