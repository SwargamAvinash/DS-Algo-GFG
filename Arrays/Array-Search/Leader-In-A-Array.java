import java.util.*;
import java.lang.*;

// Coming TLE 

class Solution {
	private static Scanner in = new Scanner(System.in);

	public static void printLeaders(int arr[]) {
	    List<Integer> ans = new ArrayList<>();
		int max_so_far = arr[arr.length-1];

		ans.add(arr[arr.length-1]);
		for (int i = arr.length-2;i >= 0; i--) {

			if (max_so_far <= arr[i]) {
				ans.add(arr[i]);
				max_so_far = arr[i];
			}
		}
		for (int i=ans.size()-1; i>=0 ;i--) {
		    System.out.print(ans.get(i) + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int t  = in.nextInt();

		while (t> 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0;i<n;i++) arr[i] = in.nextInt();

			printLeaders(arr);
			t--;
		}
	}
}