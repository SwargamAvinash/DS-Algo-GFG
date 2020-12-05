// -- Alogorithm

// -- two variables prefix_sum and suffix_sum and max_ans
// -- find suffix_sum by one loop through the Array. 
// -- And traverse through the array and add index to prefix_sum and subract from suffix_sum 
// -- if prefix and suffix are equal at some point update the max_ans

import java.util.*;
import java.lang.*;

class Solution {

	private static Scanner in = new Scanner(System.in);

	public static int findMaxEquilibriumSum(int arr[]) {
		int prefix_sum = 0;
		int suffix_sum = 0;
		int max_sum = Integer.MIN_VALUE;

		for (int i=0;i<arr.length;i++) suffix_sum += arr[i];

		for (int i=0 ;i<arr.length;i++) {
			suffix_sum -= arr[i];
			if (prefix_sum == suffix_sum) {
				max_sum = Math.max(prefix_sum, max_sum);
			}
			prefix_sum += arr[i];
		}

		if (max_sum == Integer.MIN_VALUE) return -1;
		return max_sum;
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t>0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i = 0;i < n; i++) arr[i] = in.nextInt();
			System.out.println(findMaxEquilibriumSum(arr));
			t--;
		}
	}
}