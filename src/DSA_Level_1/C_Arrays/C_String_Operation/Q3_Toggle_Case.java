package DSA_Level_1.C_Arrays.C_String_Operation;

import java.util.*;

public class Q3_Toggle_Case {

    public static String toggleCase(String str){
        String ans = "";

        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) >= 'A'
                    && str.charAt(i) <= 'Z') // uppercase
            {
                ans += (char)(str.charAt(i) + (32));
            }
            else
            {
                ans += (char)(str.charAt(i) - (32));
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

}
