package DSA_Level_1.E_Recursion.C_String_Sequence_Recursion;

import java.util.*;

public class Q3_Print_Permutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        printPermutations(str, "");
    }

    public static void printPermutations(String input, String output) {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }


        // Choices (Edges) for string "abc" are a, b, c
        for(int i=0; i<input.length(); i++)
        {
            char choice = input.charAt(i);
            String newInput = input.substring(0, i) + input.substring(i + 1);
            printPermutations(newInput, output + choice);
        }

    }

}