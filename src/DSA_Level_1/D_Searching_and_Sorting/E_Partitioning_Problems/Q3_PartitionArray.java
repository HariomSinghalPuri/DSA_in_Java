package DSA_Level_1.D_Searching_and_Sorting.E_Partitioning_Problems;
import java.util.*;

public class Q3_PartitionArray {

    public static void partition(int[] arr, int pivot){
        //write your code here
        int i = 0, j = 0;
        while(i < arr.length)
        {
            // unexplored region : i to n-1
            // Smaller or equal region : 0 to j - 1
            // Greater region : j to i - 1

            if(arr[i] <= pivot)
            {
                // add unexplored element in smaller or equal region
                swap(arr, i, j);
                i++; j++;
            }
            else
            {
                // add unexplored element in greater region
                i++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr,pivot);
        print(arr);
    }

}