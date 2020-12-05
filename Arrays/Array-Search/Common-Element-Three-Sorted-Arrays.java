

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < n1 && j < n2 && k < n3) {
            if (A[i] < B[j] || A[i] < C[k]) {
                i++;
            } else if (B[j] < C[k] || B[j] < A[i]) {
                j++;
            } else if (C[k] < B[j] || C[k] < A[i]) {
                k++;
            } else if (A[i] == B[j] && B[j] == C[k]) {
                if (ans.indexOf(A[i]) == -1) ans.add(A[i]); 
				// You didn't have to do the search here. You could just checked the last element.
                i++;j++;k++;
            }
        }
        
        return ans;
    }
}