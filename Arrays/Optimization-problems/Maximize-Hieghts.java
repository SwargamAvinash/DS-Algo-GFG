class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        if (n == 1) return 0;
        // Sort the Array First.
        Arrays.sort(arr);
        // for (int i=0;i<n;i++) System.out.print(arr[i] + " ");
        // System.out.println("");
        
        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        
        if (small > big) {
            // swaping
            small = small + big;
            big = small - big;
            small = small - big;
        }
        
        for (int i=1;i<n-1;i++) {
            int add = arr[i] + k;
            int sub = arr[i] - k;
            
            if (sub >= small || add <= big) continue;
            
            if (big - sub <= add - small) {
                small = sub;
            }else {
                big = add;
            }
            
        }
        
        return Math.min(ans, big-small);
    }
}
