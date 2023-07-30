import java.util.*;

class Solution {
    static boolean[][] visited;
    static int rowLength;
    static int columnLength;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int minTime = 0;
    static boolean endArrived = false;
    
    public int solution(String[] maps) {
        rowLength = maps.length;
        columnLength = maps[0].length();
        visited = new boolean[rowLength][columnLength];
        
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    lBfs(maps, i, j);
                }
            }
        }
        
        return endArrived ? minTime : -1;
    }
    
    static void lBfs(String[] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        loop : while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            for (int i=0; i<qSize; i++) {
                int[] pollQueue = queue.poll();
                
                for (int j=0; j<4; j++) {
                    int deltaX = pollQueue[0] + dx[j];
                    int deltaY = pollQueue[1] + dy[j];
                    
                    if (deltaX >= 0 && deltaX < rowLength && deltaY >= 0 && deltaY < columnLength && maps[deltaX].charAt(deltaY) == 'L') {
                        minTime++;
                        visited = new boolean[rowLength][columnLength];
                        bfs(maps, deltaX, deltaY);
                        break loop;
                    } 
                    
                    if (deltaX >= 0 && deltaX < rowLength && deltaY >= 0 && deltaY < columnLength && (maps[deltaX].charAt(deltaY) == 'O' || maps[deltaX].charAt(deltaY) == 'S' || maps[deltaX].charAt(deltaY) == 'E') && !visited[deltaX][deltaY]) {
                        visited[deltaX][deltaY] = true;
                        queue.offer(new int[] {deltaX, deltaY});
                    }
                }
            }
            minTime++;
        }
    }
    
    
    static void bfs(String[] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        loop : while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            for (int i=0; i<qSize; i++) {
                int[] pollQueue = queue.poll();
                
                for (int j=0; j<4; j++) {
                    int deltaX = pollQueue[0] + dx[j];
                    int deltaY = pollQueue[1] + dy[j];
                    
                    if (deltaX >= 0 && deltaX < rowLength && deltaY >= 0 && deltaY < columnLength && maps[deltaX].charAt(deltaY) == 'E') {
                        minTime++;
                        endArrived = true;
                        break loop;
                    } 
                    
                    if (deltaX >= 0 && deltaX < rowLength && deltaY >= 0 && deltaY < columnLength && (maps[deltaX].charAt(deltaY) == 'O' || maps[deltaX].charAt(deltaY) == 'S') && !visited[deltaX][deltaY]) {
                        visited[deltaX][deltaY] = true;
                        queue.offer(new int[] {deltaX, deltaY});
                    }
                }
            }
            minTime++;
        }
    }
}