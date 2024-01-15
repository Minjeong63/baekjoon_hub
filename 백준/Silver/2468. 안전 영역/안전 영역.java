import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new int[N][N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int high = Integer.parseInt(input[j]);
                region[i][j] = high;
                min = Math.min(min, high);
                max = Math.max(max, high);
            }
        }

        for (int i = min - 1; i <= max; i++) {
            visited = new boolean[N][N];

            int sum = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && region[j][k] > i) {
                        dfs(j, k, i);
                        sum++;
                    }
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int xVal = x + dx[i];
            int yVal = y + dy[i];
            if (xVal >= 0 && yVal >= 0 && xVal < N && yVal < N && region[xVal][yVal] > h && !visited[xVal][yVal]) {
                dfs(xVal, yVal, h);
            }
        }
    }
}