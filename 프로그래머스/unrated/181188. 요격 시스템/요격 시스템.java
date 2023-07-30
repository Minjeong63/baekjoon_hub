import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            return e1[1] - e2[1];
        });
        
        int position = -1;
        int num = 0;
        
        for (int i=0; i<targets.length; i++) {
            int left = targets[i][0];
            int right = targets[i][1];
            
            if (position < left) {
                num++;
                position = right-1;
                continue;
            } else if (position <= right) {
               continue;
            }
            
        }
        return num;
    }
}