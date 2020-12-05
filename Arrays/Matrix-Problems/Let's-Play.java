import java.util.*;
import java.io.*;
import java.lang.*;


// Traverse the Matrix in spiral form...
// Traversing the Matrix in spiral.. form..
class Solution {
	private static Scanner in = new Scanner(System.in);

	private static void rotateMatrix(int[][] matrix, int R, int C) {
		int row = 0;
		int col = 0;
		int prev, curr;

		while (row < R && col < C) {

			if (row + 1 == R || col + 1 == C) break;

			prev = matrix[row + 1][col];

			for (int i = col ; i < C ; i++) {
				curr = matrix[row][col];
				matrix[row][col] = prev;
				prev = curr;
			}
			row++;

			for (int i = row; i < R ; i++) {
				curr = matrix[i][C-1];
				matrix[i][C-1] = prev;
				prev = curr;
			}
			C--;

			if (row < R) {
				
				for (int i = C-1 ; i >= col ; i--) {
					curr = matrix[R-1][i];
					matrix[R-1][i] = prev;
					prev = curr;
				}
			}
			R--;

			if (col < C) {
				for (int i = R-1 ; i >= row ; i--) {
					curr = matrix[R-1][i];
					matrix[R-1][i] = prev;
					prev = curr;
				}
			}
			col++;

		}
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int R = in.nextInt();
			int C = in.nextInt();
			int[][] matrix  = new int[R][C];

			for (int i=0 ;i< R ;i++) {
				for (int j=0 ; j< C ;j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			rotateMatrix(matrix, R, C);
			t--;
		}
	}
}