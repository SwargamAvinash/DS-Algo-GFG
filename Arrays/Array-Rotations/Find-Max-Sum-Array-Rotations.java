

//Array Rotation -> Just find out a way to make the sum in O(1) time..
class GfG
{
    
    private int arraySum(int arr[]) {
        int sum = 0;
        for (int i=0 ;i< arr.length ; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    int max_sum(int A[], int n)
    {
        int arr_sum = arraySum(A);
        int max = 0;
        
        // Initial sum
        
        for (int i=0;i<n;i++) {
            max += (i * A[i]);
        }
        
        int rotationSum = max;
        
        for (int i=1; i<=n; i++) {
            rotationSum = rotationSum + (arr_sum - (n * (A[n-i])));
            
            if (rotationSum > max) max = rotationSum;
        }
        
        return max;
    }	
}
