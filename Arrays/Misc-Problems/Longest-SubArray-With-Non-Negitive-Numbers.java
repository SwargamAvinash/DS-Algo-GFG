import java.util.*;
import java.lang.*;

class Solution {
	private static Scanner in = new Scanner(System.in);

	private static int longestSubArray(int arr[], int n) {
		int s = -1; // Starting from -1 actually really good..
		int e;
		int longest = Integer.MIN_VALUE;

		for (int i= s + 1; i< n;i++) {
			if (arr[i] >= 0) {
				e = i;
				if (longest == Integer.MIN_VALUE || longest < (e - s)) {
					longest = (e - s);
				}
			} else {
				s = i;
			}
		}

		if (longest == Integer.MIN_VALUE) return 0;
		return longest;
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0 ; i<n ; i++) arr[i] = in.nextInt();

			System.out.println(longestSubArray(arr, n));
			t--;
		}
	}
}