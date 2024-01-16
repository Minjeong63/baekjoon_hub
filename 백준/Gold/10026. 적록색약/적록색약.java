import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] regions;
    static boolean[][] visited;
    static boolean[][] redGreenVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        regions = new char[N][N];
        visited = new boolean[N][N];
        redGreenVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                regions[i][j] = input[j];
            }
        }

        int noRedGreenPerson = 0;
        int redGreenPerson = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, false, visited);
                    noRedGreenPerson++;
                }
                if (!redGreenVisited[i][j]) {
                    dfs(i, j, true, redGreenVisited);
                    redGreenPerson++;
                }
            }
        }
        System.out.println(noRedGreenPerson + " " + redGreenPerson);
    }

    static void dfs(int x, int y, boolean redGreen, boolean[][] visited) {
        visited[x][y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int xVal = x + dx[i];
            int yVal = y + dy[i];
            if (xVal >= 0 && yVal >= 0 && xVal < N && yVal < N && !visited[xVal][yVal]) {
                if (!redGreen && regions[x][y] == regions[xVal][yVal]) {
                    dfs(xVal, yVal, false, visited);
                }
                if (redGreen) {
                    if (regions[x][y] == 'B' && regions[xVal][yVal] == 'B') {
                        dfs(xVal, yVal, true, visited);
                    }

                    if (regions[x][y] != 'B' && regions[xVal][yVal] != 'B') {
                        dfs(xVal, yVal, true, visited);
                    }
                }
            }
        }
    }
}