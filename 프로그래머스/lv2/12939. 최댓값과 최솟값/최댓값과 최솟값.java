import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        
        int[] nArr = new int[sArr.length];
        for (int i=0; i<sArr.length; i++) {
            nArr[i] = Integer.parseInt(sArr[i]);
        }
        
        Arrays.sort(nArr);
        return nArr[0] + " " + nArr[nArr.length-1];
    }
}