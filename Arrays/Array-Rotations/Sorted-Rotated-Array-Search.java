import java.util.*;

class Solution {
	private static Scanner in = new Scanner(System.in);


	private static int binarySearch(int arr[], int start, int end, int find_x) {

		if (start > end) return -1;
		int mid = ((end - start)/2) + start;

		if (arr[mid] > find_x) {
			return binarySearch(arr, start, mid-1, find_x);
		}else if (arr[mid] < find_x) {
			return binarySearch(arr, mid+1, end, find_x);
		}else {
			return mid;
		}
	}

	private static int findPivot(int arr[]) {
		int pivot = -1;
		for (int i=1 ;i< arr.length; i++) {
			if (arr[i-1] > arr[i]) {
				pivot = i;
				break;
			}
		}

		return pivot;
	}

	private static int findTheNumber(int arr[], int find_x) {
		int pivot = findPivot(arr);

		if (pivot == -1) {
			return binarySearch(arr, 0, arr.length-1, find_x);
		}

		int s1 = binarySearch(arr, 0, pivot-1, find_x);
		if (s1 != -1) {
			return s1;
		}
		int s2 = binarySearch(arr, pivot, arr.length-1, find_x);
		if (s2 != -1) {
			return s2;
		}

		return -1;
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];

			for (int i=0 ; i< n;i++) {
				arr[i] = in.nextInt();
			}

			int find_x = in.nextInt();

			System.out.println(findTheNumber(arr, find_x));
			t--;
		}
	}
}