import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
	private static Scanner in = new Scanner(System.in);
	static final double EPS = 1e-9;

    public static void productExceptSelf(int[] nums) {
        if (nums.length == 1) { 
            System.out.print(0); 
            return; 
        } 
        
        int p[] = new int[nums.length];
        int s[] = new int[nums.length];
        int ans[] = new int[nums.length];
        
        p[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            p[i] = p[i-1] * nums[i]; 
        }
        
        s[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            s[i] = s[i+1] * nums[i]; 
        }
        
        ans[0] = s[1];
        ans[nums.length-1] = p[nums.length-2];
        
        for (int i=1;i<nums.length-1;i++) {
            ans[i] = p[i-1] * s[i+1];
        }
        
        for (int i=0 ;i < ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }
    
    public static void usingLogFunc(int[] nums) {
        double sum = 0;
        
        for (int i=0;i<nums.length;i++) {
            sum += Math.log10(nums[i]);
        }
        
        for (int i=0; i<nums.length;i++) {
            System.out.print((int)(EPS + Math.pow(10.00, sum - Math.log10(nums[i]))) + " " );
        }
        System.out.println("");
    }

	public static void main(String[] args) {
		int t = in.nextInt();
		
		while (t>0) {
			int n = in.nextInt();
			int a[] = new int[n];

			for (int i=0;i<n;i++) a[i] = in.nextInt();
			
			usingLogFunc(a);
			t--;
		}
	}

}