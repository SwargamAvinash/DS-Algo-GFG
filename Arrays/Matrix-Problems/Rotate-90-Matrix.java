import java.io.*;
import java.util.*;
import java.lang.*;

class Solution{
    
    static void printMatrix(int matrix[][], int n){
        for (int i=0 ;i < n;i++) {
            for (int j=0;j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    static void transposeMatrix(int matrix[][], int n) {
        for (int i=0 ; i < n ;i++) {
            for (int j = 0; j < i ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // printMatrix(matrix, n);
    }
    
    static void inverseColumns(int matrix[][], int n) {
        for (int j =0;j<n; j++) {
            for (int i=0 ,k = n - 1 ;i < k; i++, k--){
                int temp = matrix[k][j];
                matrix[k][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    
    static void rotateby90(int matrix[][], int n) 
    { 
        // When you are doing Inplace 90 Degree rotate.
        // Need to rotate in circles and update them.-> Not that easy..
        
        // Just transpose the matrix and reverse it's columns..
        // printMatrix(matrix, n);
        transposeMatrix(matrix, n);
        inverseColumns(matrix, n);
    }
}
