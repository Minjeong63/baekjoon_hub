import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }
        
        for (int i=0; i<completion.length; i++) {
            if (map.get(completion[i]) > 1) {
                map.put(completion[i], map.get(completion[i]) - 1);
            } else {
                map.remove(completion[i]);
            }
        }
        
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            answer = element.getKey();
        }
        return answer;
    }
}