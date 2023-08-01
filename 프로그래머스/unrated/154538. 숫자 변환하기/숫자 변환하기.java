import java.util.*;

class Solution {
    static boolean[] visited = new boolean[1000000];
    
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }
        int result = bfs(x, y, n);
        return result;
    }
    
    static int bfs(int x, int y, int n) {
        int num = 1;
        Queue<Integer> queue = new LinkedList();
        if (x + n == y || x * 2 == y || x * 3 == y) {
            return num;
        }
        if (x + n < y) {
            queue.offer(x + n);
            visited[x + n] = true;
        }
        if (x * 2 < y) {
            queue.offer(x * 2);
            visited[x * 2] = true; 
        }
        if (x * 3 < y) {
            queue.offer(x * 3);
            visited[x * 3] = true;
        }
            
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i=0; i<qSize; i++) {
                int pQueue = queue.poll();
                
                int y1 = pQueue + n;
                int y2 = pQueue * 2;
                int y3 = pQueue * 3;
                
                if (y1 > y && y2 > y && y3 > y) {
                    break;
                }
                
                if (y1 == y || y2 == y || y3 == y) {
                    num++;
                    return num;
                }
                
                if (y1 < y && !visited[y1]) {
                    visited[y1] = true;
                    queue.offer(y1);
                }
                
                if (y2 < y && !visited[y2]) {
                    visited[y2] = true;
                    queue.offer(y2);
                }
                
                if (y3 < y && !visited[y3]) {
                    visited[y3] = true;
                    queue.offer(y3);
                }
            }
            num++;
        }
        return -1;
    }
}