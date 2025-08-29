package DSA_Level_1.F_Stack_And_Queue.E_Stack_Queue_Interconversions;

import java.io.*;
import java.util.*;

public class Q3_Smallest_No_Following_Pattern {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int maxSofar = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<str.length(); i++){
            maxSofar++;
            stk.push(maxSofar);

            if(str.charAt(i) == 'i'){
                while(!stk.isEmpty()){
                    System.out.print(stk.pop());
                }
            }
        }

        maxSofar++;
        stk.push(maxSofar);
        while(!stk.isEmpty()){
            System.out.print(stk.pop());
        }

    }
}
