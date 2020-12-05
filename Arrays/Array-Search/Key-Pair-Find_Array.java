class Solution {

	// using sort and two pointer O(Logn)
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Arrays.sort(arr);
        
        int i=0;
        int j=n-1;
        
        while (i<j && i<n && j>0) {
            if (arr[i] + arr[j] > x) {
                j--;
            } else if (arr[i] + arr[j] < x){
                i++;
            } else {
                return true;
            }
        }
        
        return false;
    }

    //Using hashMap Solution --> O(n) , O(n) ->Space and Time
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Map<Integer, Boolean> hashmap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int b = x - arr[i];
            if (hashmap.containsKey(b)) {
                return true;
            }
            hashmap.put(arr[i], true);
        }
        
        return false;
    }
}