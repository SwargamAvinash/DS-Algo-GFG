class Peak
{
    
    public int searchPeek(int a[], int start, int end) {
        
        int mid = ((end - start)/2) + start;
        
        if ((mid == 0 || a[mid] >= a[mid-1]) && 
		(mid == a.length-1 || a[mid] >= a[mid + 1])) {
            return mid;
        } else if (mid > 0 && a[mid] < a[mid-1]) {
            return searchPeek(a, start, mid-1);
        } else {
            return searchPeek(a, mid+1, end);
        }
    }
    
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] a,int n)
    {
        if (n == 1) return (n-1);
        if (a[0] > a[1]) return 0;
        if (a[n-1] > a[n-2]) return (n-1);
        
        return searchPeek(a, 0, n-1);
    }
}