class Solution {
    public int consecutiveNumbersSum(int N) {
        
        int count = 0;
        
        for (int i = 1; N > ((i-1) * i)/2; i++) {
            int sub = N - (((i-1) * i)/2);
            
            if (sub % i == 0) {
                count++;
            }
        }
        
        return count;
    }
}