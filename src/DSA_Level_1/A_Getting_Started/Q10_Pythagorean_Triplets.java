package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q10_Pythagorean_Triplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your 1st Number: ");
        int a = sc.nextInt();
        System.out.println("Enter Your 2nd Number: ");
        int b = sc.nextInt();
        System.out.println("Enter Your 3rd Number: ");
        int c = sc.nextInt();

        if(a*a == b*b + c*c){
            System.out.println("Yes" +" "+ a +" "+ b + " " + c +" " + "Is a Pythagorean Triplets");
        }else{
            System.out.println("No" +" "+ a +" "+ b + " " + c +" " +  "Is not a Pythagorean Triplets");
        }


    }
}
