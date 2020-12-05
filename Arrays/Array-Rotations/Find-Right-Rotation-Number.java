

// I think you are code is tooo messy... ...
// You are actually doing it wrong....you need to compare it with the last element,..
// To know which side of the array you need to search
class Solution {
    
    public int searchDamp(int arr[], int start, int end) {
        if (start > end) return -1;
        
        int mid = ((end-start)/2) + start;
        if (mid == 0 || mid == arr.length-1) {
            if (mid == 0 && arr[mid] > arr[mid + 1]) return mid + 1;
            
            if (mid == arr.length-1 && arr[mid] < arr[mid-1]) return mid;
            
            return -1;
        }
        if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
            return mid;
        } else if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
            return mid + 1;
        } else {
            int s1 = searchDamp(arr, start, mid -1);
            int s2 = searchDamp(arr, mid+1, end);
            
            if (s1 != -1) return s1;
            if (s2 != -1) return s2;
            
            return -1;
        }
    }
    
    int findKRotation(int arr[], int n) {
        if (n == 1) return 0;
       int rotations = searchDamp(arr, 0, n-1);
       if (rotations == -1) return 0;
       
       return rotations;
    }
}

// This is the correct Implementation you have split the array..
// Log(n) only if you are looking into one only...