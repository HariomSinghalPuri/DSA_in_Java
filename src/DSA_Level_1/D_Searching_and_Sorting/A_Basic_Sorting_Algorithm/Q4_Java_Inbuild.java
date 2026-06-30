package DSA_Level_1.D_Searching_and_Sorting.A_Basic_Sorting_Algorithm;

import java.util.Arrays;

public class Q4_Java_Inbuild {

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,5,8,2,1,9,3,6};
        System.out.println("Original Array : ");
        printArray(arr);
        Arrays.sort(arr);
        // Arrays.sort(arr,starting, last point+1) daalne se bhi sort hota hai
//        Arrays.sort(arr,0,3);

        // Ek aur Technique hai reverse order ke liyeb
        // .sort(arr,collections.reverseorder())  ---> ise reverse me array mil jaega

        System.out.println("Sorted Array : ");
        printArray(arr);

    }
}
