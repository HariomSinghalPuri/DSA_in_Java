package DSA_Level_1.C_Arrays;

// Binary_Search :-

//public int search(int[] arr, int target) {
//    int left = 0, right = arr.length - 1;
//    while(left <= right)
//    {
//        int mid = left + (right - left) / 2;
//
//        if(arr[mid] == target)
//        {
//            // Successfull search
//            return mid;
//        }
//        else if(arr[mid] < target)
//        {
//            left = mid + 1;
//        }
//        else // arr[mid] > target
//        {
//            right = mid - 1;
//        }
//    }
//    // Unsucessfull search
//    return -1;
//}



import java.util.Arrays;
import java.util.Scanner;

public class Q7_Binary_Search {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        System.out.println("\nInitial array: " + Arrays.toString(arr));
        System.out.println("Searching for target: " + target);

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow
            System.out.println("\nCurrent search range: [" + left + ", " + right + "]");
            System.out.println("Mid index: " + mid + ", Mid value: " + arr[mid]);

            if (arr[mid] == target) {
                System.out.println("Found target at index: " + mid);
                return mid;
            } else if (arr[mid] < target) {
                System.out.println(arr[mid] + " < " + target + " → Searching RIGHT half");
                left = mid + 1;
            } else {
                System.out.println(arr[mid] + " > " + target + " → Searching LEFT half");
                right = mid - 1;
            }
        }

        System.out.println("Target not found in the array.");
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sorted array (space-separated numbers): ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Enter target number to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("\nResult: Target " + target + " not found.");
        } else {
            System.out.println("\nResult: Target " + target + " found at index " + result);
        }

        scanner.close();
    }
}