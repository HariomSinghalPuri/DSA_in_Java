package Basics_of_Java;

public class Rev_15_2D_Array_in_Java {

	public static void main(String[] args) {
		int[][] matrix = new int [2][3] ;
		matrix [0][0] = 25;
		matrix [0][1] = 24;
		matrix [0][2] = 23;
		matrix [1][0] = 22;
		matrix [1][1] = 21;
		matrix [1][2] = 20;
		//System.out.println(matrix [1][2]);
		// Displaying the array (for loop)
		System.out.println("Printing a 2D array using  loop");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println("\n");
		}
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
		int j = 0;
		while (j < arr.length) {
			int k = 0;
			while (k < arr[j].length) {
				System.out.print(arr[j][k] + " ");
				k++;
			}
			System.out.println();
			j++;
		}
	}
}
