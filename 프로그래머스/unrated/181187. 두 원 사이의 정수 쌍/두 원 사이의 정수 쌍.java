class Solution {
    public long solution(int r1, int r2) {
        long result = 0;
        
        for (int i=1; i<=r2; i++) {
            double r1Len = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            double r2Len = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            
            result += (long)r2Len - (long)r1Len;
            if (r1Len == Math.floor(r1Len) && r1Len != 0.0) {
                result++;
            }
        }
        return result * 4 + (r2 - r1 + 1) * 4;
    }
}