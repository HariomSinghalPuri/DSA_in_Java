package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q2_All_Prime_Till_N {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter The Lower Number: ");
        int low = scn.nextInt();
        System.out.print("Enter The Higher Number: ");
        int high = scn.nextInt();

        if (low > high) {
            System.out.println("Invalid range. The lower number should be less than or equal to the higher number.");
        } else {
            System.out.println("Prime numbers between " + low + " and " + high + " are:");

            for (int n = low; n <= high; n++) {
                boolean isPrime = true;

                if (n <= 1) {
                    isPrime = false;
                } else {
                    for (int div = 2; div * div <= n; div++) {
                        if (n % div == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

                if (isPrime) {
                    System.out.println(n);
                }
            }
        }

        scn.close();
    }
}
