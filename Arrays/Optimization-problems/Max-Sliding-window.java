class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [] res = new int[nums.length-k+1];
        int index = 0;
        for (int i= 0; i<k;i++) {
            pq.add(nums[i]);
        }
        
        res[index++] = pq.peek();
        for (int i=k;i<nums.length;i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            res[index++] = pq.peek();
        }
        
        return res;
    }
}