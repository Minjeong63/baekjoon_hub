import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] fuel;
    static boolean[][] visited;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            dfs(new Node(0, i, 0, 0), 0, fuel[0][i]);
        }
        System.out.println(minResult);
    }

    static void dfs(Node node, int count, int sum) {
        if (visited[node.x][node.y]) {
            return;
        }
        if (count == N - 1) {
            minResult = Math.min(minResult, sum);
            return;
        }
        visited[node.x][node.y] = true;

        int[][] dxdy = {{1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < 3; i++) {
            int nx = node.x + dxdy[i][0];
            int ny = node.y + dxdy[i][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M
                    && !visited[nx][ny]
                    && (node.directionX != dxdy[i][0] || node.directionY != dxdy[i][1])) {
                dfs(new Node(nx, ny, dxdy[i][0], dxdy[i][1]), count + 1, sum + fuel[nx][ny]);
            }
        }
        visited[node.x][node.y] = false;
    }

    static class Node {
        int x;
        int y;
        int directionX;
        int directionY;

        Node(int x, int y, int directionX, int directionY) {
            this.x = x;
            this.y = y;
            this.directionX = directionX;
            this.directionY = directionY;
        }
    }
}