class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array

	// Two types of solutions you can use hashmap or sorting for 
	// Finding the sum..
	public boolean findTriplets(int nums[] , int n)
    {
        if (nums.length < 3) return false;
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        for (int i=0 ; i < nums.length-1 ; i++) {
            int l = i+1;
            int r = nums.length-1;
            
            while (l < r) {
                int x = nums[i] + nums[l] + nums[r];
                if (x == 0) {
                    set.add(Arrays.asList(nums[i], nums[l] ,nums[r]));
                    return true;
                    
                } else if (x > 0) {
                    r--;
                } else if (x < 0) {
                    l++;
                }
            }
        }
        
        return false;
    }
}