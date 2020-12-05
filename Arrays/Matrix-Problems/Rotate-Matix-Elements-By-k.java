import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
	private static Scanner in = new Scanner(System.in);

	private void rotateMatrixKTimes(int mat[][], int k) {
		// Do a Spiral Traversal in the Matrix..And you can Swap stuff..May bee..??
		// In Every Spiral Rotation check if k == Number of elements in outer..
		int m = mat.length;
		int n = mat.length;
		int row = 0;
		int col = 0;

		// Do you want to do it single step at a time..??
		// Can you do k rotations at once..?
		// Here I am thinking how to do this In-Place..
		// Converting one complex problem into a simpler solved one..
		// Store the circle in temp array and rotate the array and then 
		// Store it back to the Matrix..
		while (row < m && col < n) {

		}
	}

	public static void main(String[] args) {
		int R = in.nextInt();
		int C = in.nextInt();
		int k = in.nextInt();
		int[][] matrix = new int[R][C];

		for (int i=0 ;i < R; i++) {
			for (int j=0;j< C; j++) matrix[i][j] = in.nextInt();
		}

		rotateMatrixKTimes(matrix, k);
	}
}