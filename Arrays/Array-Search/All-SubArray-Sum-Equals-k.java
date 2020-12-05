class Solution {
    public int subarraySum(int[] nums, int k) {
        // Just a 2 pointer Approach Can I use it to do this in O(n) -> Approach..
        int ans = 0;
        int[] preffixsum = new int[nums.length];
        
        preffixsum[0] = nums[0];
        for (int i=1 ;i<preffixsum.length;i++) {
            preffixsum[i] = preffixsum[i-1] + nums[i];
        }
        
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == k) {
                ans++;
            }
        }
        
        for (int i=0; i< nums.length;i++) {
            for (int j= i + 1; j < nums.length;j ++) {
                int sum = preffixsum[j] - preffixsum[i] + nums[i];
                if (sum == k) ans++;
            }
        }
        
        return ans;
    }
}

// Using HashMap and Storing the sum ....
// How to use the iteration 1 of the 
// Really Good Explanation -> 
// https://leetcode.com/problems/subarray-sum-equals-k/discuss/408341/Javascript-Brute-Force-and-HashMap-Solution-w-Explanation
class Solution {
    public int subarraySum(int[] nums, int k) {
        // You won't be able to use 2 Pointer approach in this Actually....
        // Keep Track of the sum in hashmap...
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i=0; i<nums.length;i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum-k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
}