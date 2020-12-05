import java.util.*;
import java.lang.*;


// You could have done it in O(n) 
// When you have to find multiple maximums then you can do it O(n) time...
// Just have to play with if else conditions..
class Solution {
	private static Scanner in = new Scanner(System.in);

	public static int maxTripletSumOptimized(int arr[]) {
		int maxA = Integer.MIN_VALUE;
		int maxB = Integer.MIN_VALUE;
		int maxC = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length ; i++) {
			if (arr[i] > maxA) {
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			} else if (arr[i] > maxB) {
				maxC = maxB;
				maxB = arr[i];
			} else if (arr[i] > maxC) {
				maxC = arr[i];
			}
		}

		return (maxA + maxB + maxC);
	}

	public static int maxTripletSum(int arr[]) {
		if (arr.length < 3) return -1;
		Arrays.sort(arr);

		return (arr[arr.length-1] + arr[arr.length-2] + arr[arr.length-3]);
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0 ;i < n;i++) arr[i] = in.nextInt();

			System.out.println(maxTripletSumOptimized(arr));
			t--;
		}
	}
}