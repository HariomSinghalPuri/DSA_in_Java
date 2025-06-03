package Basics_of_Java;
//Using Recurrsion we will add number 1 to 10.
public class Rev_19_Recurrsion {
	public static void main(String[] args) {
	    int result = sum(10);
	    System.out.println(result);
	}
	public static int sum(int k) {
		if (k > 0) {
	      return k + sum(k - 1);
	    }
		else {
	      return 0;
	    }
	}
}
