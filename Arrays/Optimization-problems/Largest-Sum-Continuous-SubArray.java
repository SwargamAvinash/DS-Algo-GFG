import java.util.*;


// This is also called kadane's Algorithm..
class Solution {
	private static Scanner in = new Scanner(System.in);

	private static int maxSum_KadaneAlgo(int[] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;

		for (int i =0;i< arr.length;i++) {
			max_ending_here += arr[i];

			if (max_so_far < max_ending_here) max_so_far = max_ending_here;
			if (max_ending_here < 0) max_ending_here = 0;
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		int t = in.nextInt();

		while (t>0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int =0; i<n ;i++) arr[i] = in.nextInt();

			System.out.println(maxSum_KadaneAlgo(arr));

			t--;
		}
	}
}