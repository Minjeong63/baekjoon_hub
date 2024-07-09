import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] visited;
    static boolean[] visitedColumn;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N][N];
        visitedColumn = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[0][i] = 1;
            visitedColumn[i] = true;
            dfs(0, 1);
            visited[0][i] = 0;
            visitedColumn[i] = false;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visitedColumn[i]) {
                continue;
            }

            boolean crossVisited = false;
            for (int j = Math.min(x + 1, i); j > 0; j--) {
                if (visited[x + 1 - j][i - j] == 1) {
                    crossVisited = true;
                    break;
                }
            }

            int j = x + 1;
            int k = i;
            while (true) {
                j--;
                k++;

                if (j < 0 || k < 0 || j >= N || k >= N) {
                    break;
                }

                if (visited[j][k] == 1) {
                    crossVisited = true;
                    break;
                }
            }

            if (crossVisited) {
                continue;
            }

            visited[x + 1][i] = 1;
            visitedColumn[i] = true;
            dfs(x + 1, depth + 1);
            visited[x + 1][i] = 0;
            visitedColumn[i] = false;
        }
    }
}