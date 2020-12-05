import java.util.*;


// When ever there is avg or some metric then make sure you use double or float 
// parameters.
class Solution {
	private static Scanner in = new Scanner(System.in);

	private static void findMinAvgSubArray(int arr[], int k) {
		if (arr.length < k) System.out.println(-1);
		int min_i = 0;
		int min_j = min_i + k - 1;
		double min_avg = 0;

		for (int a= min_i; a<= min_j ;a++)  {
			min_avg += arr[a];
		}
		min_avg = min_avg/k;
		
		double avg = min_avg;
		int i = min_i;
		int j = min_j;
		while (j < arr.length-1) {
		    avg = ((avg * k) + (arr[j+1] - arr[i]))/k;
			i++;j++;
			if (min_avg > avg) {
				min_avg = avg;
				min_i = i;
				min_j = j;
			}
		}

		System.out.println((min_i+1) + " " + (min_j+1));
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int arr[] = new int[n];

			for (int i=0; i<n;i++) arr[i] = in.nextInt();

			findMinAvgSubArray(arr, k);
			t--;
		}
	}
}