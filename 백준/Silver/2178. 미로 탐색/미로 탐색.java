import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;
    static int[][] maze;
    static int N;
    static int M;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N][M];

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String mazeNum = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = mazeNum.charAt(j) - '0';
                maze[i][j] = value;
            }
        }

        bfs(0, 0);
        System.out.println(result);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] node = queue.poll();
                if (node[0] == N - 1 && node[1] == M - 1) {
                    queue.clear();
                    break;
                }

                int[] dx = {-1, 0, 1, 0};
                int[] dy = {0, 1, 0, -1};

                for (int i = 0; i < 4; i++) {
                    int a = node[0] + dx[i];
                    int b = node[1] + dy[i];

                    if (a >= 0 && b >= 0 && a < N && b < M && !visited[a][b] && maze[a][b] == 1) {
                        queue.add(new int[]{a, b});
                        visited[a][b] = true;
                    }

                }
            }
            result++;
        }
    }
}