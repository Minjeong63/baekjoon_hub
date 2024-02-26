import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 목표지점 x, y 좌표
        int x = 0;
        int y = 0;
        // 지도 배열
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        // 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치에 -1 대입
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        answer = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        // 목표지점에서의 거리
        int dist = 1;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                Node node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    // index가 범위 안에 있으며 방문한 적이 없고 지도 값이 1일 때
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                        q.add(new Node(nx, ny));
                        answer[nx][ny] = dist;
                        visited[nx][ny] = true;
                    }
                }
            }
            dist++;
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}