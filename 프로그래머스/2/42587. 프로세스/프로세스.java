import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // index를 q에 넣기
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            q.add(i);
        }
        
        int[] copyPriorities = new int[priorities.length];
        for (int i=0; i<priorities.length; i++) {
            copyPriorities[i] = priorities[i];
        }
        Arrays.sort(copyPriorities);
        
        int priorityIndex = copyPriorities.length - 1;
        
        // q가 빌 때까지 반복문
        while (!q.isEmpty()) {
            // 우선순위가 가장 높은 index가 아니면 다시 q에 넣기
            if (priorities[q.peek()] != copyPriorities[priorityIndex]) {
                q.add(q.poll());
            }
            
            // 우선순위가 가장 높은 index면 q에서 poll하고 answer++
            // answer이 location이랑 같으면 q에서 poll한 index를 return
            else {
                answer++;
                int index = q.poll();
                if (index == location) {
                    break;
                }
                priorityIndex--;
            }
        }
        
        return answer;
    }
}