
// Using a Segment Tree to reduce the Complexity to O(K logn)
class SegmentTree {

	public int[] tree;
	public int[] arr;

	public SegmentTree(int arr[], int n) {
		this.tree = new int[4*n];
		this.arr = arr;
		this.buildTree(arr, 0, 0, n-1);
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
    public int[] maxSlidingWindow(int[] nums, int k) {
        // We can make an Max Segment Tree For Range Queries...
        // And use it..
        SegmentTree sTree = new SegmentTree(nums, nums.length);
        int s = 0;
        int e = k - 1;
        List<Integer> ans = new ArrayList<>();
        
        while (s <= e && e < nums.length) {
            ans.add(sTree.queryTree(s, e, 0, nums.length-1, 0));
            s++;e++;
        }
    
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}