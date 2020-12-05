// This problem of finding a max subarray with equal number of ones and zeros
// is converted to finding the Max Subarray with Sum == 0..!!

//When ever you found a same sum.. As the previous sums.. (sum - k) it means you found a subarray
// sum_sub3 = k = sum_sb2 - sum_sb1; 

// You can Also Solve this problem with prefix_sum extra space Array.But O(n^2)
class GfG {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        for (int i=0 ; i < N ; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }
        
        // Now Problem changes into Find the MaxSubarray..
        // Which has the sum = 0... or K -> Pretty Simple..
        int sum = 0;
        int end_index = 0;
        int max_size = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0 ; i<N ;i++) {
            sum += arr[i];
            if (sum == 0) {
                max_size = i + 1;
                end_index = i;
            }
            
            if (map.containsKey(sum)) {
                // when you are doing this you actually found a subarray...
                // whose sum is equal to k..!!
                if (max_size < i - map.get(sum)) {
                    max_size = i - map.get(sum);
                    end_index = i;
                }
                
            } else {
                map.put(sum, i);
            }
        }
        if (max_size == Integer.MIN_VALUE) return 0;
        return max_size;
    }
}