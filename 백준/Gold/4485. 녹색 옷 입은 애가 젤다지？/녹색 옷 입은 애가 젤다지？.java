import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = dijkstra();
            System.out.println("Problem " + index + ": " + result);
            index++;
        }
    }

    static int dijkstra() {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, A[0][0]));
        result[0][0] = A[0][0];

        while (!q.isEmpty()) {
            Node now = q.poll();
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int xVal = now.x + dx[i];
                int yVal = now.y + dy[i];
                if (xVal < 0 || yVal < 0 || xVal >= N || yVal >= N) {
                    continue;
                }
                if (result[now.x][now.y] + A[xVal][yVal] < result[xVal][yVal]) {
                    result[xVal][yVal] = result[now.x][now.y] + A[xVal][yVal];
                    q.add(new Node(xVal, yVal, result[xVal][yVal]));
                }
            }
        }
        return result[N - 1][N - 1];
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}