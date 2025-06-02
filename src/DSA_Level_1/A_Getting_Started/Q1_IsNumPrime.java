package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q1_IsNumPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Number: ");
        int t = sc.nextInt();
        for(int i = 0 ; i < t ; i++ ){
            int n = sc.nextInt();

            int count = 0;
            for(int div = 2; div*div <= n; div++){
                if(n%div == 0){
                    count++;
                    break;
                }
            }

            if(count == 0){
                System.out.println("Prime");
            }else{
                System.out.println("Not Prime");
            }
        }
        sc.close();

    }
}
