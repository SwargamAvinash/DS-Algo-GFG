import java.util.*;

class Solution {
	private static Scanner in = new Scanner(System.in);

	private static void printArray(int arr[]) {
		for (int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	private static void rightRotateOnce(int arr[], int n) {
		int temp = arr[n-1];
		for (int i=n-1;i>0;i--) {
			arr[i] = arr[i-1];
		}

		arr[0] = temp;
		printArray(arr);
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0;i<n;i++) {
				arr[i] = in.nextInt();
			}

			rightRotateOnce(arr,n);
			t--;
		}
	}
}