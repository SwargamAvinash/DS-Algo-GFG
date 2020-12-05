import java.util.*;
import java.lang.*;
import java.io.*;


// Left Rotation ... Obviously you don't need to rotate an Array All d times
// If an array is rotated you can predetermied tell which location the Id is will present.
class GFG
 {
     
     private static Scanner in = new Scanner(System.in);
     
     
     private static void printArray(int[] arr) {
         for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
         }
         System.out.println("");
     }
     
     private static int[] leftRotate(int[] arr) {
         int temp = arr[0];
         
         for (int i=1;i<arr.length;i++) {
             arr[i-1] = arr[i];
         }
         
         arr[arr.length - 1] = temp;
        //  printArray(arr);
         return arr;
     }
     
     private static void rotateArray(int[] arr, int d) {
         if (d == 0) printArray(arr);
         int[] rotatedArray = new int[arr.length];
         
         for (int i=0 ;i<arr.length ;i++) {
             rotatedArray[(i - d + arr.length) % arr.length] = arr[i];
         }
         printArray(rotatedArray);
     }
	public static void main (String[] args)
	 {
	     int t = in.nextInt();
	     while (t>0) {
	         int n = in.nextInt();
	         int d = in.nextInt();
	         
	         int arr[] = new int[n];
	         
	         for (int i = 0;i<n;i++) {
	             arr[i] = in.nextInt();
	         }
	         
	         d = d % n;
	         rotateArray(arr, d);
	         t--;
	     }
	 }
}