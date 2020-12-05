class Solution {
    
	// Finding the Max Rectangle Area in an Array.. 
	// can be extended to use Find the Max Rectangle That you can Find 
	// In the Matrix..

	// Need to Undertand the DP Approach of the Problem..
    public int maxHistRectangleArea(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int max_area = 0;
        int area = 0;
        
        int i = 0;
        while (i < arr.length) {
            if (st.empty() || arr[st.peek()] <= arr[i]) {
                st.push(i++);
            } else {
                int top_val = arr[st.peek()];
                st.pop();
                
                area = top_val * i;
                if (!st.empty())  {
                    area = top_val * (i - st.peek() -1);
                }
                
                max_area = Math.max(max_area, area);
                
            }
        }
        
        while (!st.empty()) {
            int top_val = arr[st.peek()];
            st.pop();
            
            area = top_val * i;
            if (!st.empty())  {
                    area = top_val * (i - st.peek() -1);
            }
            max_area = Math.max(max_area, area);
            
        }
        
        return max_area;
    }
    
    
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) return 0;
        int C = matrix[0].length;
        int[][] intMat = new int[R][C];
        
        for (int i=0;i<R;i++) {
            for (int j=0 ;j<C ;j++) {
                intMat[i][j] = matrix[i][j] - '0';
                // System.out.print(intMat[i][j] + " ");
            }
            // System.out.println("");
        }
        
        // Calculate the Max Rectangle..Thinking First Row as Base..
        int result = maxHistRectangleArea(intMat[0]);
        
        for (int i=1 ;i<R;i++) {
            for (int j=0;j<C;j++) {
                if (intMat[i][j] == 1){
                    intMat[i][j] += intMat[i-1][j];
                }
            }
            result = Math.max(result, maxHistRectangleArea(intMat[i]));
        }
        
        return result;
    }
}