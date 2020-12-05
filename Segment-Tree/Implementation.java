import java.util.*;
import java.lang.*;
import java.io.*;


// Segement Tree Implementation... Creation Time Complexity.. O(n)...
// When you have a problem where Extensive Range Queries are used.. Then 
// Create a segment tree and use it..

// You can Create an Min Query Segment Tree or Max Query Segment Tree.
class SegmentTree {

	public int[] tree;
	public int[] arr;

	public SegmentTree(int arr[], int n) {
		this.tree = new int[4*n];
		this.arr = arr;
		this.buildTree(arr, 0, 0, n-1);
		printArray(tree);
	}

	private static void printArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

	public int queryTree(int l, int r, int start, int end, int index) {
		if (r < start || end < l) return Integer.MIN_VALUE; // Completely Outside the Range..

		if (start >= l && end <= r) {
			return tree[index];
		}

		int q1, q2;
		int mid = (start + end) /2;
		q1 = queryTree(l, r, start, mid, 2*index + 1);
		q2 = queryTree(l, r, mid+1, end, 2*index + 2);

		return Math.max(q1, q2);
	}

	private void buildTree(int arr[], int index, int start, int end) {
		if (start == end) {
			tree[index] = arr[start];
		} else {
			int mid = (start + end) / 2;
			buildTree(arr, 2*index+1, start, mid);
			buildTree(arr, 2*index+2, mid+1, end);

			tree[index] = Math.max(tree[2*index+1], tree[2*index+2]);
		}
	}
}

class Solution {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int arr[] = new int[n];

		for (int i=0 ;i<n; i++) arr[i] = in.nextInt();

		SegmentTree segmentTree = new SegmentTree(arr, n);
		System.out.println(segmentTree.queryTree(0, 2, 0, n-1, 0));
	}
}