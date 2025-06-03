package Basics_of_Java;

public class Rev_13_Break_Continue {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			  if (i == 4) {
			    break;
			  }
			  System.out.println(i);
			}
		{
			for (int i = 0; i < 10; i++) {
				  if (i == 4) {
				    continue;
				  }
				  System.out.print(i + " ");
				}
		}
	}

}
