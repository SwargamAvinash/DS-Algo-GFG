
// This coin change problem we need to find how many ways A number can we formed with infinte coins
// Actually For Permutations this is the Same way you can find permutations 
// Too.. Same way you can find permutations to
class Solution
{
    private long countUtilBottomTop(int coins[], int n, int m) {
        long[] table = new long[n+1];
        
        Arrays.fill(table, 0);
        table[0] = 1;
        
        for (int i=0 ;i<m;i++) {
            for (int j = coins[i]; j <= n ; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        
        return table[n];
    }
    
    
    // Top Down Using Recursion..
	// Try to change it to memorization..
    private int countUtilTopDown(int coins[], int sum, int m) {
        if (sum < 0) return 0;
        if (sum == 0) return 1;
         
        if (m < 0 && sum > 0) return 0;
        
        return countUtilTopDown(coins, sum - coins[m], m) + 
            countUtilTopDown(coins, sum, m - 1);
    }
    
    
    public long count(int S[], int m, int n) 
    { 
        return countUtilBottomTop(S, n, m);
    } 
}

// Self Solving 
// Coin Change Problem.. coins used and sum created..
// In a Bottom up thingy you always need to fill every thing.. Most of the Times......
// You can optimize the space to O(n) y doing this in single aray.
class Solution {
    
    private int countUtilBottomTop(int coins[], int n, int m) {
        int[] table = new int[n+1];
        
        Arrays.fill(table, 0);
        table[0] = 1;
        
        for (int i=0 ;i<m;i++) {
            for (int j = coins[i]; j <= n ; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        
        return table[n];
    }
    
    private int coinChangeUtil(int coins[], int n, int m) {
        Arrays.sort(coins);
        int count[][] = new int[m][n+1];
        
        // when you create a matrix for DP In Bottom to Top you need 
        // To do the initialization..for First Row and Coloumn.
        for (int i=0 ;i < m; i++) count[i][0] = 1;
        for (int i = coins[0]; i <= n; i++) {
            if (i % coins[0] == 0) {
                count[0][i] = 1;
            }
        }
        
        for (int i=1 ;i < m; i++){
            for (int j = 1; j <= n; j++) {
                if (coins[i] > j) count[i][j] = count[i-1][j];
                else count[i][j] = count[i-1][j] + count[i][j - coins[i]];
            }
        }
        
        return count[m - 1][n];
    }
    
    
    public int change(int amount, int[] coins) {
        if (coins.length == 0 && amount == 0) return 1;
        if (coins.length == 0 && amount > 0) return 0;
        return countUtilBottomTop(coins, amount, coins.length);
    }
}