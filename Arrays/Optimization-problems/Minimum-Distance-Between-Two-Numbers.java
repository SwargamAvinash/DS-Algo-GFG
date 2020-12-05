

class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minDis = Integer.MAX_VALUE;
        int xp = -1; int yp = -1;
        
        for (int i=0 ; i<n ; i++) {
            if (a[i] == x) {
                xp = i;
            } else if (a[i] == y) {
                yp = i;
            }
            
            if (xp != -1 && yp != -1) {
                minDis = Math.min(Math.abs(xp - yp), minDis);
            }
        }
        
        // System.out.println(xp + " ---> " + yp);
        // System.out.println(minDis);
        
        if(minDis == Integer.MAX_VALUE) return -1;
        if (xp == -1 || yp == -1) return -1;
        return minDis;
    }
}