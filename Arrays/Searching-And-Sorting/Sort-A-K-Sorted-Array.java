import java.util.*;


// the first element of the sorted array will be present in the next 
// 3 indeces of the array only..
// So with this thinking the comparisions actually got decreased...
class Solution {

	private static Scanner in = new Scanner(System.in);

	public static void sortkSortedArray(int arr[], int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k && i < n ; i++) pq.add(arr[i]);
		
		int i = 0;
		int j = k + 1;
		while(!pq.isEmpty()) {
			arr[i++] = pq.poll();
			if (j < n) pq.add(arr[j++]);
		}
		
		for (int m = 0 ; m < n; m++) System.out.print(arr[m] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];

			for (int i=0; i < n;i++) arr[i] = in.nextInt();

			sortkSortedArray(arr, n, k);
			t--;
		}
	}
}