package DSA_Level_1.C_Arrays.B_Number_Base_Conversion;

import java.util.*;

// Decimal_to_Any_Base :

public class Q5_Decimal_to_Any_Base {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b){
        int ans = 0;
        int power = 1; //10^0

        while(n != 0){
            int r = n % b;
            n = n / b;

            ans += (r * power);
            power *= 10;
        }

        return ans;
    }
}