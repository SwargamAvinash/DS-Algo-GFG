import java.util.*;
import java.lang.*;

class Solution {

	private static Scanner in = new Scanner(System.in);
 
	// Every jumps[i] means min steps needed to reach n-1 from i...
	// When using Integer.MAX_VALUE and stuff.. and Adding Stuff to it Need to 
	// Remember Integer Overflow...
	private static int findMinSteps_EndToStart(int arr[], int posi) {
		int jumps[] = new int[arr.length];

		// Each jump[i] represents how much min steps needed to reach n-1 from i...

		jumps[arr.length - 1] = 0; // Min number from n-1 to n-1 0

		for (int i= arr.length-2 ; i>=0;i--) {
			if (arr[i] == 0) {
				jumps[i] = Integer.MAX_VALUE;
			} else if (arr[i] >= (arr.length - i - 1)) {
				jumps[i] = 1;
			} else {
				// Just loop through all the points that you can go from
				// add the minimun
				int min = Integer.MAX_VALUE;

				for (int j = i + 1; j<arr.length && (j<= i + arr[i]) ; j++) {
					if (min > (jumps[j])) {
						min = jumps[j];
					}
				}

				if (min != Integer.MAX_VALUE) {
					jumps[i] = 1 + min;
				} else {
					jumps[i] = min;
				}
			}
		}

		return jumps[0];
	}


	// The jumps[i] represents that the min number of steps required to reach i from 0...
	private static int findMinSteps_StartToEnd(int arr[], int posi) {
		int jumps[] = new int[arr.length];

		if (arr.length == 0 && arr[0] == 0) return Integer.MAX_VALUE;

		jumps[0] = 0;

		for (int i = 1 ; i < arr.length ; i++) {
			jumps[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j< i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}

		return jumps[arr.length - 1];
	}

	// This is Recursion -> O(n^n) -> we can change this to meorization...
	private static int findMinSteps(int arr[], int posi) {
		if (posi >= arr.length-1) return 0;

		if (arr[posi] == 0) return Integer.MAX_VALUE;

		int min_steps = Integer.MAX_VALUE;
		for (int i = posi+1 ; (i < arr.length) && (i <= (posi + arr[posi])) ; i++) {
			// Delegating them to sub-problems
			int jumps = findMinSteps(arr, i);
			if (jumps != Integer.MAX_VALUE && (1 + jumps) < min_steps) {
				min_steps = 1 + jumps;
			}
		}

		return min_steps;
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0; i<n ; i++) arr[i] = in.nextInt();
			
			int ans = findMinSteps_StartToEnd(arr, 0);
			System.out.println((ans!=Integer.MAX_VALUE) ? ans : -1);
			t--;
		}
	}
}