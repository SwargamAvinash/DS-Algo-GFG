
// Buying and selling in N days atmost k Transactions
class Solution{
    static int maxProfit(int K, int N, int A[])
    {
        int[][] profit = new int[K+1][N+1];
        
        for (int i =0 ;i <= K ;i++) {
            profit[i][0] = 0;
        }
        
        for (int i=0 ; i <= N;i++) {
            profit[0][i] = 0;
        }
        
        for (int i=1 ; i <= K ; i++) {
            
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1 ;j < N; j++) {
                prevDiff = Math.max(prevDiff, profit[i-1][j-1] - A[j-1]);
                profit[i][j] = Math.max(profit[i-1][j], prevDiff + A[j]);
            }
        }
        
        return profit[K][N-1];
    }
}