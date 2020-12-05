

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int countsArray[] = new int[10001];
        int max = 0;
        for (int i=0; i< nums.length ;i++) {
            max = Math.max(max, nums[i]);
        }
        
        for (int i=0 ;i < nums.length;i++) {
            countsArray[nums[i]]++;
        }
        
        int res[] = new int[max+1];
        res[0]= 0;
        
        for (int i=1 ;i<=max ;i++) {
            int k = Math.max(0, i - 2);
            res[i] = Math.max(res[i-1] , countsArray[i] * i + res[k]);
        }
        
        return res[max];
    }
}