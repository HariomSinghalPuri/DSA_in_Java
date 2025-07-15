package DSA_Level_1.B_Pattern;

public class Q21 {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 0 ; i< n ; i++){
            System.out.print(i);
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("-");
        }
        for (int i = 0 ; i< n ; i++){
            System.out.print("+");
        }
    }

}
