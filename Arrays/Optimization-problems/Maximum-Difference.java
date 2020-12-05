import java.util.*;

class Solution {
	private static Scanner in = new Scanner(System.in);

	private static int findMaxDifference(int a[]) {
		// Keep Track of the Minimum you see and
		// Also Keep Track of the Max Difference you see.
		int min = a[0];
		int max_diff = Integer.MIN_VALUE;

		for (int i=1;i<n;i++) {
			min = Math.min(min, a[i]);
			max_diff = Math.max(max_diff, a[i] - min);
		}
		if (max_diff == 0) return -1;
		return max_diff;
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int a[] = new int[n];

			for (int i=0;i<n;i++) a[i] = in.nextInt();

			System.out.println(findMaxDifference(a));
			t--;
		}
	}
}