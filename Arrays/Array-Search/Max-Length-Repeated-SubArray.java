class Solution {
    
    public int returnlengthUntilEq(int[] A, int[] B, int i, int j) {
        int count = 0;
        while (i<A.length && j<B.length) {
            if (A[i] == B[j]) {
                count++;
                i++;j++;
            } else {
                break;
            }
        }
        
        return count;
    }
    
    public int findLength(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        
        for (int i=0 ;i<B.length;i++) {
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(B[i], list);
            }
        }
        
        for (int i=0; i< A.length;i++) {
            if (map.containsKey(A[i])) {
                for (Integer index : map.get(A[i])) {
                    maxLength = Math.max(
                        maxLength, 
                        returnlengthUntilEq(A, B, i, index)
                    );
                }
            }
        }
        
        if (maxLength == Integer.MIN_VALUE) return 0;
        return maxLength;
    }
}