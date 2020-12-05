class Solution {
    public List<String> summaryRanges(int[] nums) {
        // Club all continous subArrays with 1 increment..
        
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        
        int s = 0;
        int e = 0;
        while (s <= e && e < nums.length-1) {
            if (nums[e] + 1 == nums[e+1]) {
                e++;
            } else {
                ans.add( (s == e) ? ("" + nums[s]) : (nums[s] + "->" + nums[e]));
                e++;
                s = e;
            }
        }
        ans.add( (s == e) ? ("" + nums[s]) : (nums[s] + "->" + nums[e]));
        return ans;
    }
}