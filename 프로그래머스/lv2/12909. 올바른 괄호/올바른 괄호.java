class Solution {
    boolean solution(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        
        int bracket = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracket++;
            } else {
                bracket--;
            }
            
            if (bracket < 0) {
                return false;
            }
        }
        
        if (bracket != 0) {
            return false;
        }
            
        return true;
    }
}