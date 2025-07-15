package DSA_Level_1.C_Arrays.Tasks;

import java.util.Scanner;

public class Q1_Taking_User_Input_Output {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Size of The Array");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter The Value One BY one : ");
        for (int i = 0; i < size; i++){
            arr[i] = sc.nextInt() ;
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }




    }
}
