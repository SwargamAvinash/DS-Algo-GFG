import java.io.*;
import java.util.*;
import java.lang.*;


// Every DP Problem Define a state and Define State Transition..

// Ugly number is a number which is divided by any one of 2, 3, 5 
// So All the Ugly numbers are formed by multiplication of
		//(ugly_numbers) * (2, 3, 5)

class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n + 1];
        
        uglyNumbers[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int multiple_ugly_2 = uglyNumbers[i2] * 2;
        int multiple_ugly_3 = uglyNumbers[i3] * 3;
        int multiple_ugly_5 = uglyNumbers[i5] * 5;
        for (int i = 1; i <= n ; i++) {
            
            int ugly = Math.min(
                Math.min(multiple_ugly_2, multiple_ugly_3), 
                multiple_ugly_5
            );
            
            uglyNumbers[i] = ugly;
            
            if (ugly == multiple_ugly_2) {
                i2++;
                multiple_ugly_2 = uglyNumbers[i2] * 2;
            }
            if (ugly == multiple_ugly_3) {
                i3++;
                multiple_ugly_3 = uglyNumbers[i3] * 3;
            }
            if (ugly == multiple_ugly_5) {
                i5++;
                multiple_ugly_5 = uglyNumbers[i5] * 5;
            }
            
        }
        
        // for (int i=0 ; i<n ; i++) {
        //     System.out.println(uglyNumbers[i]);
        // }
        
        return uglyNumbers[n-1];
    }
}