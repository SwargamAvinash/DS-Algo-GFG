class Solution {
    static long nthFibonacci(long n) {
        
        long mod = 1000000007;
        // code here
        long[] f = new long[(new Long(n)).intValue()];
        
        f[0] = 1;
        f[1] = 1;
        for (int i = 2 ; i < n; i++) {
            f[i] = (f[i-1] + f[i-2]) % mod;
        }
        
        return f[(new Long(n)).intValue() - 1];
    }
}