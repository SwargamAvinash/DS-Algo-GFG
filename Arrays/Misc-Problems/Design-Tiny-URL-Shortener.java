class Solution {
    String idToShortURL(long n) {
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
        long length = 62;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            long rem = n % length;
            sb.append(map[((int)rem)]);
            n = n/length;
        }
        
        return sb.reverse().toString();
    }
}