package DSA_Level_1.A_Getting_Started;

import java.util.Scanner;

public class Q7_Rotate_a_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number: ");
        int n = sc.nextInt();
        System.out.println("Enter The Number of Rotation: ");
        int k = sc.nextInt();

        int temp = n ;
        int node = 0 ;
        while(temp>0){
            temp = temp/10;
            node++;
        }
        int div = 1 ;
        int mult = 1;
        for(int i = 1; i<=node;  i++){
            if(i<=k){
                div = div * 10;
            }else {
                mult = mult* 10;
            }
        }
        int q = n / div;
        int r = n % div;
        r = r * mult + q;
        System.out.println("The Rotated Number is: " +r);
    }
}
